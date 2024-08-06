package com.engine.ingest.imports;
import com.engine.ingest.model.SalesAgentDataModel;
import com.engine.ingest.repository.SalesAgentDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesAgentDataBatchImportService {

    @Autowired
    private SalesAgentDataRepository salesAgentEntityRepository;

    private static final String FILE_PATH = "data/sales_agent_data_file.csv"; // Path to the CSV file in resources

    @Transactional
    public void refreshSalesAgentData() {
        // Delete all existing data
        salesAgentEntityRepository.deleteAll();
        // Reimport data from the file
        List<SalesAgentDataModel> salesAgentEntityList = readSalesAgentDataFromFile();
        if (!salesAgentEntityList.isEmpty()) {
            salesAgentEntityRepository.saveAll(salesAgentEntityList);
        }
    }

    private List<SalesAgentDataModel> readSalesAgentDataFromFile() {
        List<SalesAgentDataModel> salesAgentEntityList = new ArrayList<>();
        Resource resource = new ClassPathResource(FILE_PATH);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            // Skip header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 7) {
                    SalesAgentDataModel salesAgentEntity = new SalesAgentDataModel();
                    salesAgentEntity.setAgentId(fields[0]);
                    salesAgentEntity.setMobileNo(fields[1]);
                    salesAgentEntity.setName(fields[2]);
                    salesAgentEntity.setGender(fields[3]);
                    salesAgentEntity.setAge(Integer.parseInt(fields[4]));
                    salesAgentEntity.setNationality(fields[5]);
                    salesAgentEntity.setOfficeId(fields[6]);
                    salesAgentEntityList.add(salesAgentEntity);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Import of sales agent data failed ",e);
        }
        return salesAgentEntityList;
    }
}
