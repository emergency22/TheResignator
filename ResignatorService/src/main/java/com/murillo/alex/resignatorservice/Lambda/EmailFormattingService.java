package com.murillo.alex.resignatorservice.Lambda;

import com.murillo.alex.resignatorservice.Lambda.Requests.EmailGenerationRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.murillo.alex.resignatorservice.Lambda.Entity.EmailData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailFormattingService {
    private final Logger log = LogManager.getLogger();

    private String formattedSenderEmail;
    private String formattedFirstName;
    private String formattedLastName;
    private String formattedPosition;
    private String formattedOrganization;
    private String formattedRecipientFirstName;
    private String formattedRecipientEmail;
    private Date formattedExecutionDate;
    private Date formattedLastDay;

    private EmailFinishingService emailFinishingService;

    public EmailFormattingService() {
    }

    public EmailData formatData(EmailGenerationRequest emailGenerationRequest) {
        log.info("EmailFormattingService formatData method activated.");

        formattedSenderEmail = emailGenerationRequest.getSenderEmail();
        formattedFirstName = formatName(emailGenerationRequest.getFirstName());
        formattedLastName = formatName(emailGenerationRequest.getLastName());
        formattedPosition = formatName(emailGenerationRequest.getPosition());
        formattedOrganization = formatName(emailGenerationRequest.getOrganization());
        formattedRecipientFirstName = formatName(emailGenerationRequest.getRecipientFirstName());
        formattedRecipientEmail = emailGenerationRequest.getRecipientEmail();
        formattedExecutionDate = parseDateFromString(emailGenerationRequest.getExecutionDate());
        formattedLastDay = parseDateFromString(emailGenerationRequest.getLastDay());

        this.emailFinishingService = new EmailFinishingService(formattedSenderEmail, formattedFirstName, formattedLastName, formattedPosition, formattedOrganization, formattedRecipientFirstName, formattedRecipientEmail, formattedExecutionDate, formattedLastDay);
        return emailFinishingService.formatEmail();
    }

    private String formatName(String recipientName) {
        String[] words = recipientName.split("\\s+");
        StringBuilder capitalizedFullName = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                String capitalizedWord = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
                capitalizedFullName.append(capitalizedWord).append(" ");
            }
        }
        return capitalizedFullName.toString().trim();
    }

    private String formatDate(SimpleDateFormat inputDate) {
        Date date = new Date(String.valueOf(inputDate));
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");
        String formattedDate = formatter.format(date);
        return formattedDate;
    }

    private Date parseDateFromString(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            log.error("Error parsing date from string: {}", dateString, e);
            return null;
        }
    }



}
