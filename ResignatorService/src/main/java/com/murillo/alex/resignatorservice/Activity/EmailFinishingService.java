package com.murillo.alex.resignatorservice.Activity;

import com.murillo.alex.resignatorservice.Activity.Results.EmailGenerationResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailFinishingService {
    private final String senderEmail;
    private final String firstName;
    private final String lastName;
    private final String position;
    private final String organization;
    private final String recipientFirstName;
    private final String recipientEmail;
    private final String executionDate;
    private final String lastDay;
    private final Logger log = LogManager.getLogger();


    public EmailFinishingService(String senderEmail, String firstName, String lastName, String position, String organization, String recipientFirstName, String recipientEmail, String executionDate, String lastDay) {
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

    /**
     * Formats the email body.
     */
    public EmailGenerationResult formatEmail() {
        log.info("EmailFinishingService formatEmail method activated.");

        String subject = "Formal Letter of Resignation";

        StringBuilder body = new StringBuilder();

        body.append("Dear ").append(this.recipientFirstName).append(",").append("<br><br>");
        body.append("Please accept this letter as my formal resignation from my position as ")
                .append(this.position)
                .append(" at ")
                .append(this.organization)
                .append(". My last day will be on ")
                .append(this.lastDay).append(".")
                .append("<br><br>");
        body.append("I appreciate the opportunities for growth and development you have provided during my time at ")
                .append(this.organization)
                .append(". Thank you for your guidance and support.")
                .append("<br><br>");
        body.append("Please let me know if I can be of any help during the transition period. I wish you and ")
                .append(this.organization)
                .append(" all the best.")
                .append("<br><br>");
        body.append("Sincerely, ")
                .append(this.firstName).append(" ").append(this.lastName).append("<br>")
                .append(this.senderEmail).append("<br><br><br>");

        return new EmailGenerationResult(this.recipientEmail, subject, this.executionDate, body.toString());
    }

}
