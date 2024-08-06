package com.engine.ingest.strategy;

import java.io.IOException;

public interface DataProcessorStrategy {
    void processData(String data) throws IOException;
}
