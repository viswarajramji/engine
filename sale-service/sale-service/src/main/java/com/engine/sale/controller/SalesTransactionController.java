package com.engine.sale.controller;

import com.engine.sale.model.SalesTransactionData;
import com.engine.sale.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SalesTransactionController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/transaction")
    public String postSalesTransaction(@RequestBody SalesTransactionData salesTransaction) {
        kafkaProducer.sendMessage(salesTransaction);
        return "Transaction sent to Kafka topic";
    }
}
