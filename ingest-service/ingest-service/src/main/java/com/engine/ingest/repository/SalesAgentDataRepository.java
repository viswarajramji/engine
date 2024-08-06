package com.engine.ingest.repository;

import com.engine.ingest.model.SalesAgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesAgentDataRepository extends JpaRepository<SalesAgentEntity, String> {
}
