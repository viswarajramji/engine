package com.engine.ingest.repository;

import com.engine.ingest.model.OfficeBranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeBranchRepository extends JpaRepository<OfficeBranchEntity, String> {
}
