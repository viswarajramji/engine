package com.engine.sale.service;

import com.engine.sale.model.KafkaMessageWrapper;
import com.engine.sale.model.SalesTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC = "demo";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(SalesTransaction salesTransaction) {
        try {
            String payload = objectMapper.writeValueAsString(salesTransaction);
            this.kafkaTemplate.send(TOPIC,"SalesTransaction", payload);
        } catch (JsonProcessingException e) {

            //add slf4j
            e.printStackTrace();
        }
    }
}

