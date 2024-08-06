package com.engine.ingest.repository;

import com.engine.ingest.model.CustomerDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDataModelRepository extends JpaRepository<CustomerDataModel, String> {
}
