package com.murillo.alex.resignatorservice.Lambda;

import com.murillo.alex.resignatorservice.Lambda.Requests.EmailGenerationRequest;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.murillo.alex.resignatorservice.Lambda.Entity.EmailData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class EmailGenerationLambda implements RequestHandler<EmailGenerationRequest, EmailData> {

    private final Logger log = LogManager.getLogger();
    private final EmailFormattingService emailFormattingService;

    public EmailGenerationLambda() {
        this.emailFormattingService = new EmailFormattingService();
    }

    @Override
    public EmailData handleRequest(EmailGenerationRequest emailGenerationRequest, Context context) {
        log.info("EmailGenerationLambda handleRequest method activated.");

        EmailData emailData = emailFormattingService.formatData(emailGenerationRequest);

        scheduleEmailSending(emailData);

        return emailData;

    }

    private void scheduleEmailSending(EmailData emailData) {
        try {
            // Create a Quartz job detail
            JobDetail jobDetail = JobBuilder.newJob(EmailSendingJob.class)
                    .withIdentity("emailJob", "group1")
                    .build();

            // Set the emailData as a job data map so that it can be accessed in the job's execute method
            jobDetail.getJobDataMap().put("emailData", emailData);

            // Create a Quartz trigger that fires once at the specified executionDate
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("emailTrigger", "group1")
                    .startAt(emailData.getExecutionDate())
                    .build();

            // Schedule the job with the Quartz Scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail, trigger);

            // Start the Quartz Scheduler
            scheduler.start();
        } catch (SchedulerException e) {
            // Handle any exceptions that might occur during the scheduling process
            e.printStackTrace();
        }

    }
}
