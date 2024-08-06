package com.engine.customer.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleOracleCRMSystemController {

    // In-memory customer data
    private static final Map<String, Map<String, Object>> customerData = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // Adding sample customer data
        Map<String, Object> customer1 = new HashMap<>();
        customer1.put("customerId", "1");
        customer1.put("mobileNo", "123-456-7890");
        customer1.put("name", "John Doe");
        customer1.put("gender", "Male");
        customer1.put("age", 30);
        customer1.put("nationality", "American");
        customer1.put("passportNo", "P12345678");
        customer1.put("idNo", "ID123456");
        customer1.put("homeAddress", "123 Main St, Anytown, USA");
        customer1.put("leaseStartDate", "2023-01-01");
        customer1.put("leasePeriod", 12);

        Map<String, Object> customer2 = new HashMap<>();
        customer2.put("customerId", "2");
        customer2.put("mobileNo", "987-654-3210");
        customer2.put("name", "Jane Smith");
        customer2.put("gender", "Female");
        customer2.put("age", 28);
        customer2.put("nationality", "Canadian");
        customer2.put("passportNo", "P87654321");
        customer2.put("idNo", "ID789012");
        customer2.put("homeAddress", "456 Elm St, Othertown, Canada");
        customer2.put("leaseStartDate", "2022-06-15");
        customer2.put("leasePeriod", 24);

        Map<String, Object> customer3 = new HashMap<>();
        customer3.put("customerId", "3");
        customer3.put("mobileNo", "555-123-4567");
        customer3.put("name", "Alice Johnson");
        customer3.put("gender", "Female");
        customer3.put("age", 35);
        customer3.put("nationality", "British");
        customer3.put("passportNo", "P23456789");
        customer3.put("idNo", "ID345678");
        customer3.put("homeAddress", "789 Oak St, Londontown, UK");
        customer3.put("leaseStartDate", "2021-09-10");
        customer3.put("leasePeriod", 18);

        Map<String, Object> customer4 = new HashMap<>();
        customer4.put("customerId", "4");
        customer4.put("mobileNo", "666-234-5678");
        customer4.put("name", "Bob Williams");
        customer4.put("gender", "Male");
        customer4.put("age", 40);
        customer4.put("nationality", "Australian");
        customer4.put("passportNo", "P34567890");
        customer4.put("idNo", "ID456789");
        customer4.put("homeAddress", "101 Pine St, Sydney, Australia");
        customer4.put("leaseStartDate", "2020-12-01");
        customer4.put("leasePeriod", 36);

        Map<String, Object> customer5 = new HashMap<>();
        customer5.put("customerId", "5");
        customer5.put("mobileNo", "777-345-6789");
        customer5.put("name", "Emily Davis");
        customer5.put("gender", "Female");
        customer5.put("age", 29);
        customer5.put("nationality", "New Zealand");
        customer5.put("passportNo", "P45678901");
        customer5.put("idNo", "ID567890");
        customer5.put("homeAddress", "202 Birch St, Wellington, NZ");
        customer5.put("leaseStartDate", "2024-02-20");
        customer5.put("leasePeriod", 6);

        // Adding all customer data to the map
        customerData.put("1", customer1);
        customerData.put("2", customer2);
        customerData.put("3", customer3);
        customerData.put("4", customer4);
        customerData.put("5", customer5);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<String> getCustomerById(@PathVariable("id") String id) {
        Map<String, Object> responseData = customerData.getOrDefault(id, new HashMap<>() {{
            put("error", "Customer not found");
        }});
        try {
            String jsonResponse = objectMapper.writeValueAsString(responseData);
            return ResponseEntity.ok(jsonResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"An error occurred\"}");
        }
    }
}