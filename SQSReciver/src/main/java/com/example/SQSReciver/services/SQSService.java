package com.example.SQSReciver.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class SQSService {

    @Value("${cloud.aws.endpoint}")
    private String url;

    @SqsListener(value = { "${cloud.aws.endpoint}" }, deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void readMessage(String message){
        System.out.println("Reading Message..." +  message);
    }

}
