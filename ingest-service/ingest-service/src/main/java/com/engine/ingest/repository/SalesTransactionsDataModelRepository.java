package com.engine.ingest.repository;

import com.engine.ingest.model.SalesTransactionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesTransactionsDataModelRepository extends JpaRepository<SalesTransactionsModel, Long> {
}
