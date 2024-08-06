package com.engine.ingest.strategy.impl;

import com.engine.ingest.model.GpsTransactionModel;
import com.engine.ingest.model.SalesTransactionsModel;
import com.engine.ingest.repository.GpsTransactionRepository;
import com.engine.ingest.repository.SalesTransactionsDataModelRepository;
import com.engine.ingest.strategy.DataProcessorStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component("SALES_TRANSACTION")
public class SalesTransactionDataProcessor implements DataProcessorStrategy {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SalesTransactionsDataModelRepository salesTransactionsDataModelRepository;

    @Override
    public void processData(String data) throws IOException {
        //write validation
        SalesTransactionsModel salesTransactionsModel = objectMapper.readValue(data, SalesTransactionsModel.class);
        salesTransactionsDataModelRepository.save(salesTransactionsModel);
    }
}