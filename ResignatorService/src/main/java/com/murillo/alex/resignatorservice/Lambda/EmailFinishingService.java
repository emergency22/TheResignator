package com.murillo.alex.resignatorservice.Lambda;

import com.murillo.alex.resignatorservice.Lambda.Response.EmailGenerationResponse;

public class EmailFinishingService {

    private final String recipientAddress;
    private String subject;
    private final String executionDate;
    private String body;


    public EmailFinishingService() {}

    public EmailFinishingService(EmailGenerationResponse emailGenerationResponse) {
        this.recipientAddress = emailGenerationResponse.getRecipientAddress();
        this.subject = "Letter of Resignation";
        this.executionDate = emailGenerationResponse.getExecutionDate();
        this.body = formatEmail(emailGenerationResponse);
    }

    private String formatEmail(EmailGenerationResponse emailGenerationResponse) {

        StringBuilder emailContent = new StringBuilder();

        emailContent.append("Formal Letter of Resignation").append("\n\n\n");
        emailContent.append(emailGenerationResponse.getExecutionDate()).append("\n\n");
        emailContent.append("Dear ").append(emailGenerationResponse.getRecipientName()).append("\n\n");
        emailContent.append("Please accept this letter as my formal resignation from my position as ")
                .append(emailGenerationResponse.getPosition())
                .append(" at ")
                .append(emailGenerationResponse.getOrganization())
                .append(". My last day will be on ")
                .append(emailGenerationResponse.getLastDay())
                .append("\n\n");
        emailContent.append("I appreciate the opportunities for growth and development you have provided during my time at ")
                .append(emailGenerationResponse.getOrganization())
                .append(". Thank you for your guidance and support.")
                .append("\n\n");
        emailContent.append("Please let me know if I can be of any help during the transition period. I wish you and ")
                .append(emailGenerationResponse.getOrganization())
                .append(" all the best.")
                .append("\n\n\n");
        emailContent.append("Sincerely, ")
                .append(emailGenerationResponse.getSignature()).append("\n")
                .append(emailGenerationResponse.getSenderAddress()).append("\n")
                .append(emailGenerationResponse.getSenderPhone());

        //for testing
        System.out.println(emailContent.toString());

        return emailContent.toString();
    }

}
