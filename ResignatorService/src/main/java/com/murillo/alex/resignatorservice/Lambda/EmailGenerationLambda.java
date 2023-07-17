package com.murillo.alex.resignatorservice.Lambda;

import com.murillo.alex.resignatorservice.Lambda.Requests.EmailGenerationRequest;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.murillo.alex.resignatorservice.Lambda.Response.EmailGenerationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailGenerationLambda implements RequestHandler<EmailGenerationRequest, EmailGenerationResponse> {

    private final Logger log = LogManager.getLogger();
    private final EmailFormattingService emailFormattingService;

    public EmailGenerationLambda() {
        this.emailFormattingService = new EmailFormattingService();
    }

    @Override
    public EmailGenerationResponse handleRequest(EmailGenerationRequest emailGenerationRequest, Context context) {
        log.info("EmailGenerationLambda handleRequest method activated.");

        return emailFormattingService.formatData(emailGenerationRequest);
    }
}
