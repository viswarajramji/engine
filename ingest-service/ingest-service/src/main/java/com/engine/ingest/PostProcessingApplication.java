package com.engine.ingest;

import com.engine.ingest.imports.CarDataBatchImportService;
import com.engine.ingest.imports.OfficeBranchDataBatchImportService;
import com.engine.ingest.imports.SalesAgentDataBatchImportService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostProcessingApplication {

    @Autowired
    private CarDataBatchImportService carDataBatchImportService;

    @Autowired
    private OfficeBranchDataBatchImportService officeBranchDataBatchImportService;

    @Autowired
    private SalesAgentDataBatchImportService salesAgentDataBatchImportService;

    @PostConstruct
    public void watchFiles() {
        carDataBatchImportService.refreshCarData();
        officeBranchDataBatchImportService.refreshOfficeBranchData();
        salesAgentDataBatchImportService.refreshSalesAgentData();

    }
}
