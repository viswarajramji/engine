package com.engine.ingest.service;

import com.engine.ingest.model.views.CustomerSalesDataView;
import com.engine.ingest.repository.CustomerSalesDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DataExportService {

    private static final int BATCH_SIZE = 2000;
    private static final String EXPORT_DIRECTORY = "src/main/resources/export/data/";

    @Autowired
    private CustomerSalesDataRepository repository;
    @Autowired
    private ObjectMapper objectMapper;

    public void exportDataToFiles() throws IOException {
        ensureExportDirectoryExists();

        long totalRecords = repository.count();
        long batches = (totalRecords / BATCH_SIZE) + (totalRecords % BATCH_SIZE == 0 ? 0 : 1);

        for (int i = 0; i < batches; i++) {
            List<CustomerSalesDataView> dataBatch = repository.findAll(PageRequest.of(i, BATCH_SIZE)).getContent();
            writeDataToFile(dataBatch, i);
        }
    }

    private void ensureExportDirectoryExists() throws IOException {
        Files.createDirectories(Paths.get(EXPORT_DIRECTORY));
    }

//    private void writeDataToFile(List<CustomerSalesDataView> dataBatch, int batchNumber) throws IOException {
//        File file = new File(EXPORT_DIRECTORY + "data_batch_" + batchNumber + ".json");
//        try (FileWriter writer = new FileWriter(file)) {
//            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//            objectMapper.writeValue(writer, dataBatch);
//        }
//    }

    private void writeDataToFile(List<CustomerSalesDataView> dataBatch, int batchNumber) throws IOException {
        File file = new File(EXPORT_DIRECTORY + "data_batch_" + batchNumber + ".csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Write the header
            writer.write("BatchID,TRXN_Timestamp,Car_Driving_Status,Current_Longitude,Current_Latitude,Current_Area,KM,Amount,customer_mobile_no,customer_anonymized_mobile_no,Customer_Name,Customer_Gender,Customer_Age,Customer_Age_Band,Customer_Nationality,Customer_Passport_No,Customer_Id_No,Customer_Home_address,Customer_Lease_Start_Date,Customer_Lease_Period,Car_Make,Car_Model,Car_Plate_No,Car_Registration_Date,Car_Registration_Expiry_Date,Office_Mobile_No,office_anonymized_mobile_no,Office_Area,Office_Office_No,Office_Working_Hours,Agent_Mobile_No,agent_anonymized_mobile_no,Agent_Name,Agent_Gender,Agent_Age,Agent_Age_Band,Agent_Nationality\n");

            // Write each record
            for (CustomerSalesDataView record : dataBatch) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                        batchNumber,
                        record.getTrxnTimestamp(),
                        record.getCarDrivingStatus(),
                        record.getCurrentLongitude(),
                        record.getCurrentLatitude(),
                        record.getCurrentArea(),
                        record.getKm(),
                        record.getAmount(),
                        record.getCustomerMobileNo(),
                        record.getCustomerAnonymizedMobileNo(),
                        record.getCustomerName(),
                        record.getCustomerGender(),
                        record.getCustomerAge(),
                        record.getCustomerAgeBand(),
                        record.getCustomerNationality(),
                        record.getCustomerPassportNo(),
                        record.getCustomerIdNo(),
                        record.getCustomerHomeAddress(),
                        record.getCustomerLeaseStartDate(),
                        record.getCustomerLeasePeriod(),
                        record.getCarMake(),
                        record.getCarModel(),
                        record.getCarPlateNo(),
                        record.getCarRegistrationDate(),
                        record.getCarRegistrationExpiryDate(),
                        record.getOfficeMobileNo(),
                        record.getOfficeAnonymizedMobileNo(),
                        record.getOfficeArea(),
                        record.getOfficeOfficeNo(),
                        record.getOfficeWorkingHours(),
                        record.getAgentMobileNo(),
                        record.getAgentAnonymizedMobileNo(),
                        record.getAgentName(),
                        record.getAgentGender(),
                        record.getAgentAge(),
                        record.getAgentAgeBand(),
                        record.getAgentNationality()
                ));
            }
        }
    }
}
