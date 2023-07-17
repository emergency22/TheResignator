package com.murillo.alex.resignatorservice.Lambda.Response;

public class EmailGenerationResponse {

    private final String recipientAddress;
    private final String subject;
    private final String executionDate;
    private final String body;

    public EmailGenerationResponse(String recipientAddress, String subject, String executionDate, String body) {
        this.recipientAddress = recipientAddress;
        this.subject = subject;
        this.executionDate = executionDate;
        this.body = body;
    }
}
