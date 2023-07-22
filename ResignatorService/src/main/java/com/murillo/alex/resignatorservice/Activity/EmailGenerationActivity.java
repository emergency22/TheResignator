package com.murillo.alex.resignatorservice.Activity;

import com.murillo.alex.resignatorservice.Activity.Requests.EmailGenerationRequest;
import com.murillo.alex.resignatorservice.Activity.Results.EmailGenerationResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class EmailGenerationActivity {

    private final EmailFormattingService emailFormattingService;
    private final Logger log = LogManager.getLogger();


    @Inject
    public EmailGenerationActivity(EmailFormattingService emailFormattingService) {
        this.emailFormattingService = emailFormattingService;
    }

    /**
     *Formats the data from the Request class (from the front end) and outputs formatted email data.
     */
    public EmailGenerationResult handleRequest(final EmailGenerationRequest emailGenerationRequest) {
        log.info("EmailGenerationLambda handleRequest method activated.");
        log.info("Sender Email: {}", emailGenerationRequest.getSenderEmail());
        log.info("First Name: {}", emailGenerationRequest.getFirstName());

        EmailGenerationResult emailData = emailFormattingService.formatData(emailGenerationRequest);

        System.out.println(emailData.toString());

        return emailData;
    }
}
