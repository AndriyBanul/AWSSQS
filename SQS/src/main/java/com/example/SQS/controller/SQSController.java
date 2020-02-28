package com.example.SQS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSController {

    @Value("${cloud.aws.endpoint}")
    private String url;

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @GetMapping
    public void sendMessage(){
        queueMessagingTemplate.send(url, MessageBuilder.withPayload("The last messages from SQS sender").build());
    }


}
