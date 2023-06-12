package service.request;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailGenerationRequest {
    private final String recipientAddress;
    private final String recipientName;
    private final String signature;
    private final String senderAddress;
    private final String senderPhone;

    private final SimpleDateFormat executionDate;

    private final SimpleDateFormat lastDay;

    public EmailGenerationRequest(String recipientAddress, String recipientName, String signature, String senderAddress, String senderPhone, SimpleDateFormat executionDate, SimpleDateFormat lastDay) {
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
        this.signature = signature;
        this.senderAddress = senderAddress;
        this.senderPhone = senderPhone;
        this.executionDate = executionDate;
        this.lastDay = lastDay;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public String getRecipientName() {
        return recipientName;
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

    public SimpleDateFormat getExecutionDate() {
        return executionDate;
    }

    public SimpleDateFormat getLastDay() {
        return lastDay;
    }
}
