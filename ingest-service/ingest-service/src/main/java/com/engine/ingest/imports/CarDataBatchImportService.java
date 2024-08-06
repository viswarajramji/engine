package com.engine.ingest.imports;

import com.engine.ingest.model.CarDataModel;
import com.engine.ingest.repository.CarDataModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarDataBatchImportService {

    @Autowired
    private CarDataModelRepository carDataModelRepository;

    private static final String FILE_PATH = "data/car_data_file.csv"; // Path to the CSV file in resources

    @Transactional
    public void refreshCarData() {
        carDataModelRepository.deleteAll();
        List<CarDataModel> carEntities = readCarDataFromFile();
        if (!carEntities.isEmpty()) {
            carDataModelRepository.saveAll(carEntities);
        }
    }

    private List<CarDataModel> readCarDataFromFile() {
        List<CarDataModel> carEntities = new ArrayList<>();
        Resource resource = new ClassPathResource(FILE_PATH);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            // Skip header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 6) {
                    CarDataModel carDataModel=new CarDataModel();
                    carDataModel.setCarId(fields[0]);
                    carDataModel.setCarMake(fields[1]);
                    carDataModel.setCarModel(fields[2]);
                    carDataModel.setPlateNo(fields[3]);
                    carDataModel.setRegistrationDate(LocalDate.parse(fields[4]));
                    carDataModel.setRegistrationExpiryDate(LocalDate.parse(fields[5]));
                    carEntities.add(carDataModel);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Import of car data failed ",e);
        }
        return carEntities;
    }
}
