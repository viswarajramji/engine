//package com.engine.gps.service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.networknt.schema.JsonSchema;
//import com.networknt.schema.JsonSchemaFactory;
//import com.networknt.schema.ValidationMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import java.io.InputStream;
//import java.util.Set;
//
//@Service
//public class GpsTransactionProducerService {
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    private static final String VALID_TOPIC = "gps_valid_topic";
//    private static final String INVALID_TOPIC = "gps_invalid_topic";
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//    private final JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance();
//    private final JsonSchema jsonSchema;
//
//    public GpsTransactionProducerService() {
//        try (InputStream schemaStream = getClass().getResourceAsStream("/gps_transaction_schema.json")) {
//            this.jsonSchema = schemaFactory.getSchema(schemaStream);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load JSON schema", e);
//        }
//    }
//
//    public void processMessage(String jsonPayload) {
//        try {
//            JsonNode jsonNode = objectMapper.readTree(jsonPayload);
//            Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);
//
//            if (errors.isEmpty()) {
//                kafkaTemplate.send(VALID_TOPIC, jsonPayload);
//            } else {
//                kafkaTemplate.send(INVALID_TOPIC, jsonPayload);
//            }
//        } catch (Exception e) {
//            kafkaTemplate.send(INVALID_TOPIC, "Invalid JSON payload: " + e.getMessage());
//        }
//    }
//}
//
