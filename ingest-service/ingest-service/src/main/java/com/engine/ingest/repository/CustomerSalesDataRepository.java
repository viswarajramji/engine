package com.engine.ingest.repository;


import com.engine.ingest.model.views.CustomerSalesDataView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerSalesDataRepository extends JpaRepository<CustomerSalesDataView, Long> {
    // Custom query methods can be defined here if needed
    List<CustomerSalesDataView> findByCurrentArea(String city);

    @Query("SELECT gps.currentArea AS area, gps.carDrivingStatus AS status, COUNT(gps) AS count " +
            "FROM GpsTransactionModel gps " +
            "GROUP BY gps.currentArea, gps.carDrivingStatus")
    List<Object[]> countCarDrivingStatusPerArea();

    @Query("SELECT " +
            "EXTRACT(YEAR FROM st.transactionTimestamp) AS transactionYear, " +
            "EXTRACT(MONTH FROM st.transactionTimestamp) AS transactionMonth, " +
            "COUNT(st) AS salesCount " +
            "FROM SalesTransactionsModel st " +
            "GROUP BY EXTRACT(YEAR FROM st.transactionTimestamp), " +
            "EXTRACT(MONTH FROM st.transactionTimestamp) " +
            "ORDER BY transactionYear, transactionMonth")
    List<Object[]> countSalesPerMonthAndYear();
}