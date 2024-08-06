package com.engine.ingest.controller;

import com.engine.ingest.data.CarDrivingStatusPerAreaResponse;
import com.engine.ingest.data.SalesCountResponse;
import com.engine.ingest.model.views.CustomerSalesDataView;
import com.engine.ingest.service.CustomerSalesDataService;
import com.engine.ingest.service.DataExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/customer-sales")
public class CustomerSalesDataController {

    @Autowired
    private CustomerSalesDataService customerSalesDataService;

    @Autowired
    private DataExportService dataExportService;

    @GetMapping
    public List<CustomerSalesDataView> getAllCustomerSalesData() {
        return customerSalesDataService.getAllCustomerSalesData();
    }

    @GetMapping("/querybycity")
    public List<CustomerSalesDataView>  getDataByCity(@RequestParam String city) {
        return customerSalesDataService.getDataByCity(city);
    }

    @GetMapping("/countstatusbyarea")
    public  List<CarDrivingStatusPerAreaResponse>  countStatusByArea() {
        return customerSalesDataService.countStatusByArea();
    }

    @GetMapping("/export")
    public String exportData() {
        try {
            dataExportService.exportDataToFiles();
            return "Data export completed successfully.";
        } catch (IOException e) {
            return "Data export failed: " + e.getMessage();
        }
    }

    @GetMapping("/salescount")
    public List<SalesCountResponse> getSalesCounts() {
        return customerSalesDataService.getSalesCount();
    }




}