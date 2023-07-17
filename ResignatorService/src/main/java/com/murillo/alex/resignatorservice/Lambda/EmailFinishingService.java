package com.murillo.alex.resignatorservice.Lambda;

import com.murillo.alex.resignatorservice.Lambda.Entity.EmailData;

import java.text.SimpleDateFormat;

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
    private final SimpleDateFormat executionDate;
    private final String lastDay;
    private final Logger log = LogManager.getLogger();


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

    public EmailData formatEmail() {
        log.info("EmailFinishingService formatEmail method activated.");

        String subject = "Formal Letter of Resignation";

        StringBuilder body = new StringBuilder();

        body.append("Formal Letter of Resignation").append("\n\n\n");
        body.append(this.executionDate.toString()).append("\n\n");
        body.append("Dear ").append(this.recipientFirstName).append("\n\n");
        body.append("Please accept this letter as my formal resignation from my position as ")
                .append(this.position)
                .append(" at ")
                .append(this.organization)
                .append(". My last day will be on ")
                .append(this.lastDay)
                .append("\n\n");
        body.append("I appreciate the opportunities for growth and development you have provided during my time at ")
                .append(this.organization)
                .append(". Thank you for your guidance and support.")
                .append("\n\n");
        body.append("Please let me know if I can be of any help during the transition period. I wish you and ")
                .append(this.organization)
                .append(" all the best.")
                .append("\n\n\n");
        body.append("Sincerely, ")
                .append(this.firstName).append(" ").append(this.lastName).append("\n")
                .append(this.senderEmail).append("\n");

        //for testing
        System.out.println(body);

        return new EmailData(this.recipientEmail, subject, this.executionDate, body.toString());
    }

}