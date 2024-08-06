package com.engine.ingest.repository;
import com.engine.ingest.model.GpsTransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpsTransactionRepository extends JpaRepository<GpsTransactionModel, Long> {

}
