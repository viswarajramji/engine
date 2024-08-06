package com.engine.ingest.repository;

import com.engine.ingest.model.CarDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDataModelRepository extends JpaRepository<CarDataModel, Long> {
    // You can define custom query methods here if needed
}

