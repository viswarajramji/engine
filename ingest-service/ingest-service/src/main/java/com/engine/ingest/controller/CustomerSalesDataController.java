package com.engine.ingest.controller;


import com.engine.ingest.model.views.CustomerSalesDataView;
import com.engine.ingest.repository.CustomerSalesDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer-sales")
public class CustomerSalesDataController {

    @Autowired
    private CustomerSalesDataRepository customerSalesDataRepository;

    @GetMapping
    public List<CustomerSalesDataView> getAllCustomerSalesData() {
        List<CustomerSalesDataView> data = customerSalesDataRepository.findAll();
        return data;
    }
}