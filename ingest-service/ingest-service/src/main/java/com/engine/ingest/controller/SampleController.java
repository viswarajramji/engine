package com.engine.ingest.controller;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SampleController {

    @GetMapping("/hello")
    public String postSalesTransaction() {
        return "Transaction sent to Kafka topic";
    }
}

