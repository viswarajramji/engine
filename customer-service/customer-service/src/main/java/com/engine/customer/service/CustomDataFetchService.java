package com.engine.customer.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Slf4j
public class CustomDataFetchService {


    private static final Logger log = LoggerFactory.getLogger(CustomDataFetchService.class);


    @Value("${customer.url}")
    private String customerUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomDataService customDataService;

    private String[] customerIds = {"C123456", "C789012", "C345678", "C456789", "C567890"};
    private int currentIndex = 0;

    @Scheduled(fixedRate = 30000) // 30 seconds
    public void fetchCustomerData() {
        if (customerIds.length == 0) {
            log.warn("No customer IDs available for fetching data.");
            return;
        }

        String customerId = customerIds[currentIndex];

        try {
            log.info("Fetching data for customer ID: {}", customerId);
            ResponseEntity<String> response = restTemplate.getForEntity(customerUrl, String.class,customerId);

            if (response.getStatusCode() == HttpStatus.OK) {
                log.info("Successfully fetched data for customer ID: {}", customerId);
                customDataService.processMessage(response.getBody());
            } else {
                log.error("Failed to fetch data for customer ID: {}. Status code: {}", customerId, response.getStatusCode());
            }
        } catch (Exception ex) {
            log.error("Exception occurred while fetching data for customer ID: {}", customerId, ex);
        }

        currentIndex = (currentIndex + 1) % customerIds.length;
    }
}
