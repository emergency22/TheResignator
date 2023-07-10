package com.murillo.alex.resignatorservice.Activity;

import com.murillo.alex.resignatorservice.Entity.Email;

public class EmailFormatterService {

    private final String recipientAddress;
    private String subject;
    private final String executionDate;
    private String body;


    public EmailFormatterService(Email email) {
        this.recipientAddress = email.getRecipientAddress();
        this.subject = "Letter of Resignation";
        this.executionDate = email.getExecutionDate();
        this.body = formatEmail(email);
    }

    private String formatEmail(Email email) {

        StringBuilder emailContent = new StringBuilder();

        emailContent.append("Formal Letter of Resignation").append("\n\n\n");
        emailContent.append(email.getExecutionDate()).append("\n\n");
        emailContent.append("Dear ").append(email.getRecipientName()).append("\n\n");
        emailContent.append("Please accept this letter as my formal resignation from my position as ")
                .append(email.getPosition())
                .append(" at ")
                .append(email.getOrganization())
                .append(". My last day will be on ")
                .append(email.getLastDay())
                .append("\n\n");
        emailContent.append("I appreciate the opportunities for growth and development you have provided during my time at ")
                .append(email.getOrganization())
                .append(". Thank you for your guidance and support.")
                .append("\n\n");
        emailContent.append("Please let me know if I can be of any help during the transition period. I wish you and ")
                .append(email.getOrganization())
                .append(" all the best.")
                .append("\n\n\n");
        emailContent.append("Sincerely, ")
                .append(email.getSignature()).append("\n")
                .append(email.getSenderAddress()).append("\n")
                .append(email.getSenderPhone());

        //for testing
        System.out.println(emailContent.toString());

        return emailContent.toString();
    }

}
