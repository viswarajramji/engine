package com.engine.gps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gps")
public class GpsTransactionController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.gps.default}")
    private String DEFAULT_TOPIC;

    @PostMapping("/send")
    public String sendGpsData(@RequestBody String jsonPayload) {
        try {
            kafkaTemplate.send(DEFAULT_TOPIC, jsonPayload);
            return "Message sent to default topic topic";
        } catch (Exception e) {
            return "Failed to send message: " + e.getMessage();
        }
    }
}
