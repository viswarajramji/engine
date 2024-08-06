package com.engine.gps.listener;

import com.engine.gps.constants.ApplicationConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

@Service
public class GpsTransactionListener {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.valid}")
    private String VALID_TOPIC;

    @Value("${kafka.topic.invalid}")
    private String INVALID_TOPIC;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Schema schema;

    public GpsTransactionListener() {
        try (InputStream schemaStream = getClass().getClassLoader().getResourceAsStream("schema/gps_transaction_schema.json")) {
            if (schemaStream == null) {
                throw new IllegalStateException("Schema file not found");
            }
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
            schema = SchemaLoader.load(rawSchema);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON schema", e);
        }
    }

    @KafkaListener(topics = "${kafka.topic.gps.default}", groupId = "${kafka.consumer.group.id}")
    public void listen(String jsonPayload) {
        try {
            // Deserialize and validate the payload
            JsonNode jsonNode = objectMapper.readTree(jsonPayload);
            JSONObject jsonObject = new JSONObject(jsonNode.toString());
            schema.validate(jsonObject);
            kafkaTemplate.send(VALID_TOPIC, ApplicationConstants.KEY_NAME, jsonPayload);
        } catch (Exception e) {
            kafkaTemplate.send(INVALID_TOPIC, jsonPayload);
        }
    }


}
