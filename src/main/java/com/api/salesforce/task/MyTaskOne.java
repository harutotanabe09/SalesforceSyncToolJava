package com.api.salesforce.task;

import com.api.salesforce.service.BulkSalesforceJob;
import com.api.salesforce.service.DescribeSObjects;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyTaskOne implements Tasklet {

  @Autowired BulkSalesforceJob sfdcJob;

  @Autowired DescribeSObjects ds;

  @Value("${salesforce.login}")
  private String login;

  @Value("${salesforce.password}")
  private String password;

  @Value("${salesforce.apiVersion}")
  private String apiVersion;

  /**
   * ジョブ実行
   *
   * @param contribution
   * @param chunkContext
   * @return
   * @throws Exception
   */
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws Exception {
    ds.describeSObjectsSample(
        login, password, "https://login.salesforce.com/services/Soap/u/" + apiVersion);
    sfdcJob.run("Account", login, password, apiVersion, "import.csv");
    return RepeatStatus.FINISHED;
  }
}
