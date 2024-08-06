package com.engine.ingest.model;

import com.engine.ingest.utils.AnonymizationUtil;
import jakarta.persistence.*;

@Entity
@Table(name = "office_branch_data")
public class OfficeBranchDataModel {

    @Id
    private String officeId;

    private String mobileNo;

    private String anonymizedMobileNo;

    private String area;
    private String officeNo;
    private String workingHours;

    // Getters and Setters
    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        this.anonymizedMobileNo = AnonymizationUtil.anonymize(mobileNo);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getAnonymizedMobileNo() {
        return anonymizedMobileNo;
    }

}
