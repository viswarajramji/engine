package com.engine.sale.service;

import com.engine.sale.model.SalesTransactionData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private static final String TOPIC = "data_ingestion_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(SalesTransactionData salesTransactionData) {
        try {
            this.kafkaTemplate.send(TOPIC,"SalesTransaction", objectMapper.writeValueAsString(salesTransactionData));
        } catch (JsonProcessingException e) {
            logger.error("Unable to parse the payload:",e);
        }
    }
}

