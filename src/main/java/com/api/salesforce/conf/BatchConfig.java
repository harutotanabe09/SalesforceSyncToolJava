package com.api.salesforce.conf;

import com.api.salesforce.task.MyTaskOne;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Sprign Batch's Config Class<br> */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

  @Autowired private JobBuilderFactory jobs;

  @Autowired private StepBuilderFactory steps;

  @Autowired private MyTaskOne myTaskOne;

  /**
   * 実行ステップ１のメソッド <br>
   *
   * @return
   */
  @Bean
  public Step stepOne() {
    return steps.get("stepOne").tasklet(myTaskOne).build();
  }

  /**
   * メインタスクのメソッド <br>
   *
   * @return
   */
  @Bean
  public Job JobExecute() {
    return jobs.get("Jobs") //
        .start(stepOne())
        .build();
  }
}
