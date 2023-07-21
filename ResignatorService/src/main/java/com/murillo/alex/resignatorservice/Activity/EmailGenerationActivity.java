package com.murillo.alex.resignatorservice.Activity;

import com.murillo.alex.resignatorservice.Activity.Requests.EmailGenerationRequest;
import com.murillo.alex.resignatorservice.Activity.Results.EmailGenerationResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Inject;

public class EmailGenerationActivity {

    private final EmailFormattingService emailFormattingService;
    private final Logger log = LogManager.getLogger();


    @Inject
    public EmailGenerationActivity(EmailFormattingService emailFormattingService) {
        this.emailFormattingService = emailFormattingService;
    }

    public EmailGenerationResult handleRequest(final EmailGenerationRequest emailGenerationRequest) {
        log.info("EmailGenerationLambda handleRequest method activated.");
        log.info("Sender Email: {}", emailGenerationRequest.getSenderEmail());
        log.info("First Name: {}", emailGenerationRequest.getFirstName());

        EmailGenerationResult emailData = emailFormattingService.formatData(emailGenerationRequest);

//        scheduleEmailSending(emailData);
        System.out.println(emailData.toString());

        return emailData;

    }

//    private void scheduleEmailSending(EmailGenerationResult emailData) {
//        try {
//            // Create a Quartz job detail
//            JobDetail jobDetail = JobBuilder.newJob(EmailSendingJob.class)
//                    .withIdentity("emailJob", "group1")
//                    .build();
//
//            // Set the emailData as a job data map so that it can be accessed in the job's execute method
//            jobDetail.getJobDataMap().put("emailData", emailData);
//
//            // Create a Quartz trigger that fires once at the specified executionDate
//            Trigger trigger = TriggerBuilder.newTrigger()
//                    .withIdentity("emailTrigger", "group1")
//                    .startAt(emailData.getExecutionDate())
//                    .build();
//
//            // Schedule the job with the Quartz Scheduler
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//            scheduler.scheduleJob(jobDetail, trigger);
//
//            // Start the Quartz Scheduler
//            scheduler.start();
//        } catch (SchedulerException e) {
//            // Handle any exceptions that might occur during the scheduling process
//            e.printStackTrace();
//        }
//    }
}
