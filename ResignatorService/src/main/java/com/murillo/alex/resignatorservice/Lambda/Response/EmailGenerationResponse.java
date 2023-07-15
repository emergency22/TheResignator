package com.murillo.alex.resignatorservice.Lambda.Response;

public class EmailGenerationResponse {
    private final String recipientAddress;
    private final String recipientName;
    private final String position;
    private final String organization;
    private final String signature;
    private final String senderAddress;
    private final String senderPhone;
    private final String executionDate;
    private final String lastDay;

    public EmailGenerationResponse(String recipientAddress, String recipientName, String position, String organization, String signature, String senderAddress, String senderPhone, String executionDate, String lastDay) {
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
        this.position = position;
        this.organization = organization;
        this.signature = signature;
        this.senderAddress = senderAddress;
        this.senderPhone = senderPhone;
        this.executionDate = executionDate;
        this.lastDay = lastDay;
    }

    private String generateSubject() {
        return null;
    }

    private String generateBody() {
        return null;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getPosition() {
        return position;
    }

    public String getOrganization() {
        return organization;
    }

    public String getSignature() {
        return signature;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public String getLastDay() {
        return lastDay;
    }

}
