package com.engine.ingest.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataProcessorFactory {

    private final Map<String, DataProcessorStrategy> strategies;

    @Autowired
    public DataProcessorFactory(Map<String, DataProcessorStrategy>strategies) {
        this.strategies = strategies;
    }

    public void executeStrategy(String key, String data) throws IOException {
        DataProcessorStrategy strategy = strategies.get(key);
        if (strategy != null) {
            strategy.processData(data);
            return;
        }
      throw new IllegalArgumentException("No strategy found for key: " + key);
    }
}
