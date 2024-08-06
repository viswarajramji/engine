package com.engine.ingest.model.views;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
@Table(name = "CUSTOMER_DATA_VIEW") // Use the view name as the table name
public class CustomerSalesDataView {

    @Id
    @Column(name = "TRXN_TIMESTAMP")
    @JsonProperty("TRXN_Timestamp")
    private String trxnTimestamp;

    @Column(name = "CAR_DRIVING_STATUS")
    @JsonProperty("Car_Driving_Status")
    private String carDrivingStatus;

    @Column(name = "CURRENT_LONGITUDE")
    @JsonProperty("Current_Longitude")
    private Double currentLongitude;

    @Column(name = "CURRENT_LATITUDE")
    @JsonProperty("Current_Latitude")
    private Double currentLatitude;

    @Column(name = "CURRENT_AREA")
    @JsonProperty("Current_Area")
    private String currentArea;

    @Column(name = "KM")
    @JsonProperty("KM")
    private Double km;

    @Column(name = "AMOUNT")
    @JsonProperty("Amount")
    private Double amount;

    @Column(name = "customer_mobile_no")
    @JsonProperty("customer_mobile_no")
    private String customerMobileNo;

    @Column(name = "customer_anonymized_mobile_no")
    @JsonProperty("customer_anonymized_mobile_no")
    private String customerAnonymizedMobileNo;

    @Column(name = "Customer_Name")
    @JsonProperty("Customer_Name")
    private String customerName;

    @Column(name = "Customer_Gender")
    @JsonProperty("Customer_Gender")
    private String customerGender;

    @Column(name = "Customer_Age")
    @JsonProperty("Customer_Age")
    private Integer customerAge;

    @Column(name = "Customer_Age_Band")
    @JsonProperty("Customer_Age_Band")
    private String customerAgeBand;

    @Column(name = "Customer_Nationality")
    @JsonProperty("Customer_Nationality")
    private String customerNationality;

    @Column(name = "Customer_Passport_No")
    @JsonProperty("Customer_Passport_No")
    private String customerPassportNo;

    @Column(name = "Customer_Id_No")
    @JsonProperty("Customer_Id_No")
    private String customerIdNo;

    @Column(name = "Customer_Home_address")
    @JsonProperty("Customer_Home_address")
    private String customerHomeAddress;

    @Column(name = "Customer_Lease_Start_Date")
    @JsonProperty("Customer_Lease_Start_Date")
    private String customerLeaseStartDate;

    @Column(name = "Customer_Lease_Period")
    @JsonProperty("Customer_Lease_Period")
    private Integer customerLeasePeriod;

    @Column(name = "Car_Make")
    @JsonProperty("Car_Make")
    private String carMake;

    @Column(name = "Car_Model")
    @JsonProperty("Car_Model")
    private String carModel;

    @Column(name = "Car_Plate_No")
    @JsonProperty("Car_Plate_No")
    private String carPlateNo;

    @Column(name = "Car_Registration_Date")
    @JsonProperty("Car_Registration_Date")
    private String carRegistrationDate;

    @Column(name = "Car_Registration_Expiry_Date")
    @JsonProperty("Car_Registration_Expiry_Date")
    private String carRegistrationExpiryDate;

    @Column(name = "Office_Mobile_No")
    @JsonProperty("Office_Mobile_No")
    private String officeMobileNo;

    @Column(name = "office_anonymized_mobile_no")
    @JsonProperty("office_anonymized_mobile_no")
    private String officeAnonymizedMobileNo;

    @Column(name = "Office_Area")
    @JsonProperty("Office_Area")
    private String officeArea;

    @Column(name = "Office_Office_No")
    @JsonProperty("Office_Office_No")
    private String officeOfficeNo;

    @Column(name = "Office_Working_Hours")
    @JsonProperty("Office_Working_Hours")
    private String officeWorkingHours;

    @Column(name = "Agent_Mobile_No")
    @JsonProperty("Agent_Mobile_No")
    private String agentMobileNo;

    @Column(name = "agent_anonymized_mobile_no")
    @JsonProperty("agent_anonymized_mobile_no")
    private String agentAnonymizedMobileNo;

    @Column(name = "Agent_Name")
    @JsonProperty("Agent_Name")
    private String agentName;

    @Column(name = "Agent_Gender")
    @JsonProperty("Agent_Gender")
    private String agentGender;

    @Column(name = "Agent_Age")
    @JsonProperty("Agent_Age")
    private Integer agentAge;

    @Column(name = "Agent_Age_Band")
    @JsonProperty("Agent_Age_Band")
    private String agentAgeBand;

    @Column(name = "Agent_Nationality")
    @JsonProperty("Agent_Nationality")
    private String agentNationality;
    // Getters and Setters
}
