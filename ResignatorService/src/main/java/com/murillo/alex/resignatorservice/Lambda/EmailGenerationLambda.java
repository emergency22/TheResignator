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
            JobDetail jobDetail = JobBuilder.newJob(EmailSendingJob.class)
                    .withIdentity("emailJob", "group1")
                    .build();

            jobDetail.getJobDataMap().put("emailData", emailData);

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("emailTrigger", "group1")
                    .startAt(emailData.getExecutionDate())
                    .build();

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail, trigger);

            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
