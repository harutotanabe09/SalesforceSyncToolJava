package com.api.salesforce.service;

import static com.slack.api.webhook.WebhookPayloads.*;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import java.io.IOException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log
public class SlackMessageService {

  @Value("${slack.api}")
  private String slackToken;

  /**
   * pi.webhook.WebhookResponse; import lombok.ext
   *
   * @param msg
   * @throws IOException
   */
  public void message(String msg) {
    try {
      Slack slack = Slack.getInstance();
      String webhookUrl = slackToken; // https://hooks.slack.com/services/T1234567/AAAAAAAA/ZZZZZZ
      Payload payload = Payload.builder().text("Hello, World! + :star2: +").build();
      WebhookResponse response = slack.send(webhookUrl, payload);
      System.out.println(response);
    } catch (Exception e) {
      log.warning(e.getStackTrace().toString());
    }
  }
}
