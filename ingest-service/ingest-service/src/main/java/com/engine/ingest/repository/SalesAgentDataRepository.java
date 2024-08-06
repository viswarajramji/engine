package com.engine.ingest.repository;

import com.engine.ingest.model.SalesAgentDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesAgentDataRepository extends JpaRepository<SalesAgentDataModel, String> {
    // Custom query methods can be defined here if needed
}

