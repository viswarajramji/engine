package com.engine.ingest.data;

public class SalesCountResponse {
    private Integer year;
    private Integer month;
    private Long salesCount;

    // Default constructor
    public SalesCountResponse() {}

    // Parameterized constructor
    public SalesCountResponse(Integer year, Integer month, Long salesCount) {
        this.year = year;
        this.month = month;
        this.salesCount = salesCount;
    }

    // Getters and setters
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Long getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Long salesCount) {
        this.salesCount = salesCount;
    }


}
