package com.engine.ingest.strategy.impl;
import com.engine.ingest.model.CustomerDataModel;
import com.engine.ingest.repository.CustomerDataModelRepository;
import com.engine.ingest.strategy.DataProcessorStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component("CUSTOMER_DATA")
public class CustomerDataProcessor implements DataProcessorStrategy {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerDataModelRepository customerDataModelRepository;

    @Override
    public void processData(String data) throws IOException {
        //write validation
        CustomerDataModel customerDataModel = objectMapper.readValue(data, CustomerDataModel.class);
        customerDataModelRepository.save(customerDataModel);
    }
}