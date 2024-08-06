package com.engine.sale.controller;

import com.engine.sale.service.SalesTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SalesTransactionController {

    @Autowired
    private SalesTransactionService salesTransactionService;

    @PostMapping("/transaction")
    public ResponseEntity<String> postSalesTransaction(@RequestBody String messagePayload) {
        salesTransactionService.processMessage(messagePayload);
        return ResponseEntity.ok("Sale Transaction sent to Kafka topic");
    }
}
