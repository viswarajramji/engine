package com.engine.customer.service;

import com.engine.customer.constants.ApplicationConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.everit.json.schema.Schema;
import java.io.InputStream;

@Service
public class CustomDataService {

    @Value("${kafka.topic.valid}")
    private String VALID_TOPIC;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private final Schema schema;

    public CustomDataService() {
        try (InputStream schemaStream = getClass().getClassLoader().getResourceAsStream("schema/customer_data_schema.json")) {
            if (schemaStream == null) {
                throw new IllegalStateException("Schema file not found");
            }
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
            schema = SchemaLoader.load(rawSchema);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON schema", e);
        }
    }

    public void processMessage( String messagePayload) {
        try {
            JsonNode jsonNode = objectMapper.readTree(messagePayload);
            JSONObject jsonObject = new JSONObject(jsonNode.toString());
            schema.validate(jsonObject);
            this.kafkaTemplate.send(VALID_TOPIC, ApplicationConstants.KEY_NAME, messagePayload);
        }catch (Exception ex){
            throw new RuntimeJsonMappingException("Request Validation failed "+ex.toString());
        }
    }
}

