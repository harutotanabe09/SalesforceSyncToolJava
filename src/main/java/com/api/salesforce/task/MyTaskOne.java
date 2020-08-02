package com.api.salesforce.task;

import com.api.salesforce.service.BulkSalesforceJob;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** */
@Service
public class MyTaskOne implements Tasklet {
  @Autowired BulkSalesforceJob sfdcJob;

  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws Exception {
    sfdcJob.run("Account", "ex7477tanabe+01@gmail.com", "tanabe1678", "import.csv");
    return RepeatStatus.FINISHED;
  }
}
