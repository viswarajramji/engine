//package com.engine.gps.listener;
//
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.KafkaStreams;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.Produced;
//import org.apache.kafka.streams.kstream.Consumed;
//import org.apache.kafka.streams.kstream.Materialized;
//import org.apache.kafka.streams.kstream.Windowed;
//import org.apache.kafka.streams.state.Stores;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafkaStreams;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.serializer.JsonSerde;
//import org.json.JSONObject;
//import org.json.JSONTokener;
//import org.everit.json.schema.Schema;
//import org.everit.json.schema.loader.SchemaLoader;
//
//import java.io.InputStream;
//import java.util.Properties;
//
//@Configuration
//@EnableKafkaStreams
//public class GpsTransactionStreams {
//
//    @Value("${kafka.topic.gps.default}")
//    private String inputTopic;
//
//    @Value("${kafka.topic.valid}")
//    private String validTopic;
//
//    @Value("${kafka.topic.invalid}")
//    private String invalidTopic;
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    private final Schema schema;
//
//    public GpsTransactionStreams() {
//        try (InputStream schemaStream = getClass().getClassLoader().getResourceAsStream("schema/gps_transaction_schema.json")) {
//            if (schemaStream == null) {
//                throw new IllegalStateException("Schema file not found");
//            }
//            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
//            schema = SchemaLoader.load(rawSchema);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load JSON schema", e);
//        }
//    }
//
//    @Bean
//    public KafkaStreams kafkaStreams(StreamsBuilder streamsBuilder) {
//        KStream<String, String> stream = streamsBuilder.stream(inputTopic);
//
//        KStream<String, String>[] branches = stream.branch(
//                (key, value) -> isValid(value),
//                (key, value) -> true
//        );
//
//        branches[0].to(validTopic, Produced.with(Serdes.String(), Serdes.String()));
//        branches[1].to(invalidTopic, Produced.with(Serdes.String(), Serdes.String()));
//
//        Properties streamsConfig = new Properties();
//        streamsConfig.put(StreamsConfig.APPLICATION_ID_CONFIG, "gps-transaction-stream-processor");
//        streamsConfig.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        streamsConfig.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        streamsConfig.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//
//        KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), streamsConfig);
//        streams.start();
//
//        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
//
//        return streams;
//    }
//
//    private boolean isValid(String jsonPayload) {
//        try {
//            JsonNode jsonNode = objectMapper.readTree(jsonPayload);
//            JSONObject jsonObject = new JSONObject(jsonNode.toString());
//            schema.validate(jsonObject);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
