package com.engine.ingest.listener;

import com.engine.ingest.strategy.DataProcessorFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class IngestMessageListener {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.invalid}")
    private String INVALID_TOPIC_DLQ;

    @Autowired
    private DataProcessorFactory dataProcessorFactory;


    @KafkaListener(topics = "${kafka.topic.gps.default}", groupId = "${kafka.consumer.group.id}")
    public void listen(ConsumerRecord<String, String> record) {
        try {
             dataProcessorFactory.executeStrategy(record.key(),record.value());
        } catch (Exception e) {
            kafkaTemplate.send(INVALID_TOPIC_DLQ,record.key(), record.value());
        }
    }
}