package com.murillo.alex.resignatorservice.Activity;

import com.murillo.alex.resignatorservice.Activity.Requests.EmailGenerationRequest;

import com.murillo.alex.resignatorservice.Activity.Results.EmailGenerationResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class EmailFormattingService {
    private final Logger log = LogManager.getLogger();

    private String formattedSenderEmail;
    private String formattedFirstName;
    private String formattedLastName;
    private String formattedPosition;
    private String formattedOrganization;
    private String formattedRecipientFirstName;
    private String formattedRecipientEmail;
    private String formattedExecutionDate;
    private String formattedLastDay;

    private EmailFinishingService emailFinishingService;

    @Inject
    public EmailFormattingService() {
    }

    /**
     *
     */
    public EmailGenerationResult formatData(EmailGenerationRequest emailGenerationRequest) {
        log.info("EmailFormattingService formatData method activated.");

        formattedSenderEmail = emailGenerationRequest.getSenderEmail();
        formattedFirstName = formatName(emailGenerationRequest.getFirstName());
        formattedLastName = formatName(emailGenerationRequest.getLastName());
        formattedPosition = formatName(emailGenerationRequest.getPosition());
        formattedOrganization = formatName(emailGenerationRequest.getOrganization());
        formattedRecipientFirstName = formatName(emailGenerationRequest.getRecipientFirstName());
        formattedRecipientEmail = emailGenerationRequest.getRecipientEmail();
        formattedExecutionDate = emailGenerationRequest.getExecutionDate();
        formattedLastDay = emailGenerationRequest.getLastDay();

        this.emailFinishingService = new EmailFinishingService(formattedSenderEmail, formattedFirstName, formattedLastName, formattedPosition, formattedOrganization, formattedRecipientFirstName, formattedRecipientEmail, formattedExecutionDate, formattedLastDay);
        return emailFinishingService.formatEmail();
    }

    /**
     * Formats input strings such as names and capitalizes letters.
     */
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
}
