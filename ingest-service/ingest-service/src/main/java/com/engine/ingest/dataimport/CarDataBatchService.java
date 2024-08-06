package com.engine.ingest.dataimport;

import com.engine.ingest.model.CarEntity;
import com.engine.ingest.repository.CarRepository;
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
public class CarDataBatchService {

    @Autowired
    private CarRepository carRepository;

    private static final String FILE_PATH = "data/car_data_file.csv"; // Path to the CSV file in resources

    @Transactional
    public void refreshCarData() {
        // Delete all existing data
        carRepository.deleteAll();

        // Reimport data from the file
        List<CarEntity> carEntities = readCarDataFromFile();
        if (!carEntities.isEmpty()) {
            carRepository.saveAll(carEntities);
        }
    }

    private List<CarEntity> readCarDataFromFile() {
        List<CarEntity> carEntities = new ArrayList<>();
        Resource resource = new ClassPathResource(FILE_PATH);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            // Skip header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 6) {
                    CarEntity car = new CarEntity();
                    car.setCarId(fields[0]);
                    car.setCarMake(fields[1]);
                    car.setCarModel(fields[2]);
                    car.setPlateNo(fields[3]);
                    car.setRegistrationDate(LocalDate.parse(fields[4]));
                    car.setRegistrationExpiryDate(LocalDate.parse(fields[5]));
                    carEntities.add(car);
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return carEntities;
    }
}
