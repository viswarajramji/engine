package com.engine.ingest.service;

import com.engine.ingest.data.CarDrivingStatusPerAreaResponse;
import com.engine.ingest.data.SalesCountResponse;
import com.engine.ingest.model.views.CustomerSalesDataView;
import com.engine.ingest.repository.CustomerSalesDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerSalesDataService {

    @Autowired
    private CustomerSalesDataRepository customerSalesDataRepository;


    public List<CustomerSalesDataView> getAllCustomerSalesData() {
        List<CustomerSalesDataView> data = customerSalesDataRepository.findAll();
        return data==null? Collections.EMPTY_LIST:data;
    }

    public List<CustomerSalesDataView>  getDataByCity(String city) {
        List<CustomerSalesDataView> data = customerSalesDataRepository.findByCurrentArea(city);
        return data==null? Collections.EMPTY_LIST:data;
    }

    public List<CarDrivingStatusPerAreaResponse>  countStatusByArea() {
        List<CarDrivingStatusPerAreaResponse> list=new ArrayList<>();
        List<Object[]> data = customerSalesDataRepository.countCarDrivingStatusPerArea();
        data.forEach(value->{
            list.add(new CarDrivingStatusPerAreaResponse(String.valueOf(value[0]),String.valueOf(value[1]),String.valueOf(value[2])));
        });
        return list;

    }

    public List<SalesCountResponse> getSalesCount() {
        List<Object[]> queryResults = customerSalesDataRepository.countSalesPerMonthAndYear();
        List<SalesCountResponse> salesCountResponses = new ArrayList<>();

        for (Object[] result : queryResults) {
            Integer year = (Integer) result[0];
            Integer month = (Integer) result[1];
            Long salesCount = (Long) result[2];
            SalesCountResponse dto =  new SalesCountResponse(year, month, salesCount);
            salesCountResponses.add(dto);
        }

        return salesCountResponses;
    }

}
