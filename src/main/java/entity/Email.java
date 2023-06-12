package entity;

public class Email {
    private final String recipientAddress;
    private final String recipientName;
    private String subject;
    private String body;
    private final String signature;
    private final String senderAddress;
    private final String senderPhone;
    private final String executionDate;
    private final String lastDay;

    public Email(String recipientAddress, String recipientName, String signature, String senderAddress, String senderPhone, String executionDate, String lastDay) {
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
        this.subject = generateSubject();
        this.body = generateBody();
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

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
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
