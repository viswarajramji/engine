package com.engine.ingest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer_data")
@Getter
@Setter
public class CustomerDataModel {

    @Id
    private String customerId;

    private String mobileNo;

    private String name;

    private String gender;  // Assuming gender will be stored as a String. Adjust if you use an enum.

    private Integer age;

    private String nationality;

    private String passportNo;

    private String idNo;

    private String homeAddress;

    private String leaseStartDate;  // Ideally, use LocalDate if you need date handling.

    private Integer leasePeriod;
}
