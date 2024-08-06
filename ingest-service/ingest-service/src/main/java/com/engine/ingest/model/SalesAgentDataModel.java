package com.engine.ingest.model;


import com.engine.ingest.utils.AnonymizationUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales_agent_data")
public class SalesAgentDataModel {


    @Id
    private String agentId;
    private String mobileNo;
    private String anonymizedMobileNo;
    private String name;
    private String gender;
    private Integer age;
    private String nationality;
    private String officeId;

    // Getters and Setters

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        this.anonymizedMobileNo = AnonymizationUtil.anonymize(mobileNo);
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

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getAnonymizedMobileNo() {
        return anonymizedMobileNo;
    }

}