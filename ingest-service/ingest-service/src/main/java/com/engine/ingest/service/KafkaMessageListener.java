package com.engine.ingest.service;

import com.engine.ingest.model.SalesTransactions;
import com.engine.ingest.repository.SalesTransactionsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    @Autowired
    private SalesTransactionsRepository salesTransactionsRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "data_ingestion_topic", groupId = "group_id")
    public void listen(ConsumerRecord<String, String> record) {

        try {
            // Deserialize the payload into SalesTransactionEntity
            System.out.println(record.key());
            SalesTransactions salesTransaction = objectMapper.readValue(record.value(), SalesTransactions.class);

            // Optionally use the key if needed
            // Save the SalesTransactionEntity to the repository
            salesTransactionsRepository.save(salesTransaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

