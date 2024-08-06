package com.engine.ingest.repository;


import com.engine.ingest.model.views.CustomerSalesDataView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSalesDataRepository extends JpaRepository<CustomerSalesDataView, Long> {
    // Custom query methods can be defined here if needed
}