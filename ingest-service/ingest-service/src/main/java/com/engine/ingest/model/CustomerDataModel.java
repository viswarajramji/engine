package com.engine.ingest.model;

import com.engine.ingest.utils.AnonymizationUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer_data")
public class CustomerDataModel {

    @Id
    private String customerId;

    private String mobileNo;

    private String anonymizedMobileNo;

    private String name;

    private String gender;  // Assuming gender will be stored as a String. Adjust if you use an enum.

    private Integer age;

    private String nationality;

    private String passportNo;

    private String idNo;

    private String homeAddress;

    private String leaseStartDate;  // Ideally, use LocalDate if you need date handling.

    private Integer leasePeriod;

//    public void setMobileNo(String mobileNo) {
//        this.mobileNo = mobileNo;
//        this.anonymizedMobileNo = AnonymizationUtil.anonymize(mobileNo);
//    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        this.anonymizedMobileNo = AnonymizationUtil.anonymize(mobileNo);
    }

    public String getAnonymizedMobileNo() {
        return anonymizedMobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(String leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public Integer getLeasePeriod() {
        return leasePeriod;
    }

    public void setLeasePeriod(Integer leasePeriod) {
        this.leasePeriod = leasePeriod;
    }
}
