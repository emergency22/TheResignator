package com.murillo.alex.resignatorservice.Activity.Results;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailGenerationResult {

    private final String recipientAddress;
    private final String subject;
    private final String executionDate;
    private final String body;

    public EmailGenerationResult(String recipientAddress, String subject, String executionDate, String body) {
        this.recipientAddress = recipientAddress;
        this.subject = subject;
        this.executionDate = executionDate;
        this.body = body;
    }

//    private Date parseExecutionDate(String executionDateString) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            return sdf.parse(executionDateString);
//        } catch (ParseException e) {
//            e.printStackTrace(); // or throw an exception based on your use case
//            return null;
//        }
//    }

    public String getExecutionDate() {
        return this.executionDate;
    }

    public String getRecipientAddress() {
        return this.recipientAddress;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getBody() {
        return this.body;
    }

    @Override
    public String toString() {
        return "EmailGenerationResult{" +
                "recipientAddress='" + recipientAddress + '\'' +
                ", subject='" + subject + '\'' +
                ", executionDate='" + executionDate + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
