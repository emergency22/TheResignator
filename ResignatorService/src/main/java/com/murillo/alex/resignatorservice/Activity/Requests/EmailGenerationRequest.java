package com.murillo.alex.resignatorservice.Activity.Requests;

import java.text.SimpleDateFormat;

public class EmailGenerationRequest {
    private final String recipientAddress;
    private final String recipientFirstName;
    private final String position;
    private final String organization;
    private final String senderFirstName;
    private final String senderLastName;
    private final String senderAddress;
    private final String senderPhone;

    private final SimpleDateFormat executionDate;

    private final SimpleDateFormat lastDay;

    public EmailGenerationRequest(String recipientAddress, String recipientFirstName, String senderLastName, String position, String organization, String senderFirstName, String senderAddress, String senderPhone, SimpleDateFormat executionDate, SimpleDateFormat lastDay) {
        this.recipientAddress = recipientAddress;
        this.recipientFirstName = recipientFirstName;
        this.position = position;
        this.organization = organization;
        this.senderFirstName = senderFirstName;
        this.senderLastName = senderLastName;
        this.senderAddress = senderAddress;
        this.senderPhone = senderPhone;
        this.executionDate = executionDate;
        this.lastDay = lastDay;
    }



    public String getRecipientAddress() {
        return recipientAddress;
    }

    public String getRecipientFirstName() {
        return recipientFirstName;
    }

    public String getPosition() {
        return position;
    }

    public String getOrganization() {
        return organization;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public SimpleDateFormat getExecutionDate() {
        return executionDate;
    }

    public SimpleDateFormat getLastDay() {
        return lastDay;
    }
}
