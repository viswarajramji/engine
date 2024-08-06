package com.engine.ingest.imports;

import com.engine.ingest.model.OfficeBranchDataModel;
import com.engine.ingest.repository.OfficeBranchDataModelRepository;
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
public class OfficeBranchDataBatchImportService {

    @Autowired
    private OfficeBranchDataModelRepository officeBranchDataModelRepository;

    private static final String FILE_PATH = "data/office_branch_data_file.csv"; // Path to the CSV file in resources

    @Transactional
    public void refreshOfficeBranchData() {
        officeBranchDataModelRepository.deleteAll();
        List<OfficeBranchDataModel> officeBranchEntities = readOfficeBranchDataFromFile();
        if (!officeBranchEntities.isEmpty()) {
            officeBranchDataModelRepository.saveAll(officeBranchEntities);
        }
    }

    private List<OfficeBranchDataModel> readOfficeBranchDataFromFile() {
        List<OfficeBranchDataModel> officeBranchEntities = new ArrayList<>();
        Resource resource = new ClassPathResource(FILE_PATH);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            // Skip header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 5) {
                    OfficeBranchDataModel officeBranch = new OfficeBranchDataModel();
                    officeBranch.setOfficeId(fields[0]);
                    officeBranch.setMobileNo(fields[1]);
                    officeBranch.setArea(fields[2]);
                    officeBranch.setOfficeNo(fields[3]);
                    officeBranch.setWorkingHours(fields[4]);
                    officeBranchEntities.add(officeBranch);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Import of Office data failed ",e);
        }
        return officeBranchEntities;
    }
}
