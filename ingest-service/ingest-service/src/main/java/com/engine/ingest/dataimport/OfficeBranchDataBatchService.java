package com.engine.ingest.dataimport;


import com.engine.ingest.model.OfficeBranchEntity;
import com.engine.ingest.repository.OfficeBranchRepository;
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
public class OfficeBranchDataBatchService {

    @Autowired
    private OfficeBranchRepository officeBranchRepository;

    private static final String FILE_PATH = "data/office_branch_data_file.csv"; // Path to the CSV file in resources

    @Transactional
    public void refreshOfficeBranchData() {
        // Delete all existing data
        officeBranchRepository.deleteAll();

        // Reimport data from the file
        List<OfficeBranchEntity> officeBranchEntities = readOfficeBranchDataFromFile();
        if (!officeBranchEntities.isEmpty()) {
            officeBranchRepository.saveAll(officeBranchEntities);
        }
    }

    private List<OfficeBranchEntity> readOfficeBranchDataFromFile() {
        List<OfficeBranchEntity> officeBranchEntities = new ArrayList<>();
        Resource resource = new ClassPathResource(FILE_PATH);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            // Skip header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 5) {
                    OfficeBranchEntity officeBranch = new OfficeBranchEntity();
                    officeBranch.setOfficeId(fields[0]);
                    officeBranch.setMobileNo(fields[1]);
                    officeBranch.setArea(fields[2]);
                    officeBranch.setOfficeNo(fields[3]);
                    officeBranch.setWorkingHours(fields[4]);
                    officeBranchEntities.add(officeBranch);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return officeBranchEntities;
    }
}
