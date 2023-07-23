package com.murillo.alex.resignatorservice.Activity.Results;

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
