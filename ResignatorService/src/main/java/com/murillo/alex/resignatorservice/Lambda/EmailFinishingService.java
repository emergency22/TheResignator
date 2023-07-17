package com.murillo.alex.resignatorservice.Lambda;

import com.murillo.alex.resignatorservice.Lambda.Response.EmailGenerationResponse;

import java.text.SimpleDateFormat;

public class EmailFinishingService {

//    private final String recipientAddress;
//    private String subject;
//    private final String executionDate;
//    private String body;

    private String senderEmail;
    private String firstName;
    private String lastName;
    private String position;
    private String organization;
    private String recipientFirstName;
    private String recipientEmail;
    private SimpleDateFormat executionDate;
    private String lastDay;

    public EmailFinishingService(String senderEmail, String firstName, String lastName, String position, String organization, String recipientFirstName, String recipientEmail, SimpleDateFormat executionDate, String lastDay) {
        this.senderEmail = senderEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.organization = organization;
        this.recipientFirstName = recipientFirstName;
        this.recipientEmail = recipientEmail;
        this.executionDate = executionDate;
        this.lastDay = lastDay;
    }

//    public EmailFinishingService(EmailGenerationResponse emailGenerationResponse) {
//        this.recipientAddress = emailGenerationResponse.getRecipientAddress();
//        this.subject = "Letter of Resignation";
//        this.executionDate = emailGenerationResponse.getExecutionDate();
//        this.body = formatEmail(emailGenerationResponse);
//    }

    public EmailGenerationResponse formatEmail() {

        String subject = "Formal Letter of Resignation";

        StringBuilder body = new StringBuilder();

        body.append("Formal Letter of Resignation").append("\n\n\n");
        body.append(emailGenerationResponse.getExecutionDate()).append("\n\n");
        body.append("Dear ").append(emailGenerationResponse.getRecipientName()).append("\n\n");
        body.append("Please accept this letter as my formal resignation from my position as ")
                .append(emailGenerationResponse.getPosition())
                .append(" at ")
                .append(emailGenerationResponse.getOrganization())
                .append(". My last day will be on ")
                .append(emailGenerationResponse.getLastDay())
                .append("\n\n");
        body.append("I appreciate the opportunities for growth and development you have provided during my time at ")
                .append(emailGenerationResponse.getOrganization())
                .append(". Thank you for your guidance and support.")
                .append("\n\n");
        body.append("Please let me know if I can be of any help during the transition period. I wish you and ")
                .append(emailGenerationResponse.getOrganization())
                .append(" all the best.")
                .append("\n\n\n");
        body.append("Sincerely, ")
                .append(emailGenerationResponse.getSignature()).append("\n")
                .append(emailGenerationResponse.getSenderAddress()).append("\n")
                .append(emailGenerationResponse.getSenderPhone());

        //for testing
        System.out.println(body.toString());

        return new EmailGenerationResponse(this.recipientEmail, subject, this.executionDate, body.toString());
    }

}
