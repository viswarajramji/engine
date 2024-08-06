package com.engine.ingest.strategy.impl;

import com.engine.ingest.model.GpsTransactionModel;
import com.engine.ingest.repository.GpsTransactionRepository;
import com.engine.ingest.strategy.DataProcessorStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component("GPS_TRANSACTION")
public class GpsTransactionDataProcessor implements DataProcessorStrategy {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GpsTransactionRepository gpsTransactionRepository;

    @Override
    public void processData(String data) throws IOException {
        //write validation
        GpsTransactionModel gpsTransactionModel = objectMapper.readValue(data, GpsTransactionModel.class);
        gpsTransactionRepository.save(gpsTransactionModel);
    }
}
