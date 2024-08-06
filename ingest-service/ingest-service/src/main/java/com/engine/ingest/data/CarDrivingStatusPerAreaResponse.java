package com.engine.ingest.data;

public class CarDrivingStatusPerAreaResponse {

    private String area;
    private String status;
    private String count;

    // Constructor with parameters matching the query fields
    public CarDrivingStatusPerAreaResponse(String area, String status, String count) {
        this.area = area;
        this.status = status;
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
