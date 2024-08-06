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
    @Column(name = "row_num")
    @JsonProperty("row_num")
    private Long rowNum;

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


    public String getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(String currentArea) {
        this.currentArea = currentArea;
    }

    public String getTrxnTimestamp() {
        return trxnTimestamp;
    }

    public void setTrxnTimestamp(String trxnTimestamp) {
        this.trxnTimestamp = trxnTimestamp;
    }

    public String getCarDrivingStatus() {
        return carDrivingStatus;
    }

    public void setCarDrivingStatus(String carDrivingStatus) {
        this.carDrivingStatus = carDrivingStatus;
    }

    public Double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(Double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public Double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(Double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCustomerMobileNo() {
        return customerMobileNo;
    }

    public void setCustomerMobileNo(String customerMobileNo) {
        this.customerMobileNo = customerMobileNo;
    }

    public String getCustomerAnonymizedMobileNo() {
        return customerAnonymizedMobileNo;
    }

    public void setCustomerAnonymizedMobileNo(String customerAnonymizedMobileNo) {
        this.customerAnonymizedMobileNo = customerAnonymizedMobileNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerAgeBand() {
        return customerAgeBand;
    }

    public void setCustomerAgeBand(String customerAgeBand) {
        this.customerAgeBand = customerAgeBand;
    }

    public String getCustomerNationality() {
        return customerNationality;
    }

    public void setCustomerNationality(String customerNationality) {
        this.customerNationality = customerNationality;
    }

    public String getCustomerPassportNo() {
        return customerPassportNo;
    }

    public void setCustomerPassportNo(String customerPassportNo) {
        this.customerPassportNo = customerPassportNo;
    }

    public String getCustomerIdNo() {
        return customerIdNo;
    }

    public void setCustomerIdNo(String customerIdNo) {
        this.customerIdNo = customerIdNo;
    }

    public String getCustomerHomeAddress() {
        return customerHomeAddress;
    }

    public void setCustomerHomeAddress(String customerHomeAddress) {
        this.customerHomeAddress = customerHomeAddress;
    }

    public String getCustomerLeaseStartDate() {
        return customerLeaseStartDate;
    }

    public void setCustomerLeaseStartDate(String customerLeaseStartDate) {
        this.customerLeaseStartDate = customerLeaseStartDate;
    }

    public Integer getCustomerLeasePeriod() {
        return customerLeasePeriod;
    }

    public void setCustomerLeasePeriod(Integer customerLeasePeriod) {
        this.customerLeasePeriod = customerLeasePeriod;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarPlateNo() {
        return carPlateNo;
    }

    public void setCarPlateNo(String carPlateNo) {
        this.carPlateNo = carPlateNo;
    }

    public String getCarRegistrationDate() {
        return carRegistrationDate;
    }

    public void setCarRegistrationDate(String carRegistrationDate) {
        this.carRegistrationDate = carRegistrationDate;
    }

    public String getCarRegistrationExpiryDate() {
        return carRegistrationExpiryDate;
    }

    public void setCarRegistrationExpiryDate(String carRegistrationExpiryDate) {
        this.carRegistrationExpiryDate = carRegistrationExpiryDate;
    }

    public String getOfficeMobileNo() {
        return officeMobileNo;
    }

    public void setOfficeMobileNo(String officeMobileNo) {
        this.officeMobileNo = officeMobileNo;
    }

    public String getOfficeAnonymizedMobileNo() {
        return officeAnonymizedMobileNo;
    }

    public void setOfficeAnonymizedMobileNo(String officeAnonymizedMobileNo) {
        this.officeAnonymizedMobileNo = officeAnonymizedMobileNo;
    }

    public String getOfficeArea() {
        return officeArea;
    }

    public void setOfficeArea(String officeArea) {
        this.officeArea = officeArea;
    }

    public String getOfficeOfficeNo() {
        return officeOfficeNo;
    }

    public void setOfficeOfficeNo(String officeOfficeNo) {
        this.officeOfficeNo = officeOfficeNo;
    }

    public String getOfficeWorkingHours() {
        return officeWorkingHours;
    }

    public void setOfficeWorkingHours(String officeWorkingHours) {
        this.officeWorkingHours = officeWorkingHours;
    }

    public String getAgentMobileNo() {
        return agentMobileNo;
    }

    public void setAgentMobileNo(String agentMobileNo) {
        this.agentMobileNo = agentMobileNo;
    }

    public String getAgentAnonymizedMobileNo() {
        return agentAnonymizedMobileNo;
    }

    public void setAgentAnonymizedMobileNo(String agentAnonymizedMobileNo) {
        this.agentAnonymizedMobileNo = agentAnonymizedMobileNo;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentGender() {
        return agentGender;
    }

    public void setAgentGender(String agentGender) {
        this.agentGender = agentGender;
    }

    public Integer getAgentAge() {
        return agentAge;
    }

    public void setAgentAge(Integer agentAge) {
        this.agentAge = agentAge;
    }

    public String getAgentAgeBand() {
        return agentAgeBand;
    }

    public void setAgentAgeBand(String agentAgeBand) {
        this.agentAgeBand = agentAgeBand;
    }

    public String getAgentNationality() {
        return agentNationality;
    }

    public void setAgentNationality(String agentNationality) {
        this.agentNationality = agentNationality;
    }
}
