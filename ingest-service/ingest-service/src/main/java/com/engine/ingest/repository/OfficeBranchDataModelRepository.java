package com.engine.ingest.repository;

import com.engine.ingest.model.OfficeBranchDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeBranchDataModelRepository extends JpaRepository<OfficeBranchDataModel, String> {
}
