package com.engine.ingest;

import com.engine.ingest.dataimport.CarDataBatchService;
import com.engine.ingest.dataimport.OfficeBranchDataBatchService;
import com.engine.ingest.dataimport.SalesAgentDataBatchService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostProcessingApplication {


    @Autowired
    private CarDataBatchService carDataBatchService;

    @Autowired
    private OfficeBranchDataBatchService officeBranchDataBatchService;

    @Autowired
    private SalesAgentDataBatchService salesAgentDataBatchService;

    @PostConstruct
    public void watchFiles() {
        carDataBatchService.refreshCarData();
        officeBranchDataBatchService.refreshOfficeBranchData();
        salesAgentDataBatchService.refreshSalesAgentData();
    }
}
