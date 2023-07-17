package com.murillo.alex.resignatorservice.Lambda;

import com.murillo.alex.resignatorservice.Lambda.Entity.EmailData;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

public class EmailSendingJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Get the emailData from the JobExecutionContext
        EmailData emailData = (EmailData) context.getJobDetail().getJobDataMap().get("emailData");

        // Prepare the email content
        String recipientAddress = emailData.getRecipientAddress();
        String subject = emailData.getSubject();
        String body = emailData.getBody();

        // Send the email using AWS SES
        sendEmail(recipientAddress, subject, body);
    }

    private void sendEmail(String recipientAddress, String subject, String body) {
        SesClient sesClient = SesClient.builder().region(Region.US_EAST_1).build();

        try {
            // Specify the sender email address (must be verified in AWS SES)
            String senderAddress = "your_verified_sender@example.com";

            // Create the content for the email
            Content subjectContent = Content.builder().data(subject).build();
            Content bodyContent = Content.builder().data(body).build();
            Body emailBody = Body.builder().text(bodyContent).build();

            // Create the email message
            Message message = Message.builder()
                    .subject(subjectContent)
                    .body(emailBody)
                    .build();

            // Send the email
            SendEmailRequest emailRequest = SendEmailRequest.builder()
                    .destination(Destination.builder().toAddresses(recipientAddress).build())
                    .message(message)
                    .source(senderAddress)
                    .build();

            SendEmailResponse emailResponse = sesClient.sendEmail(emailRequest);

            System.out.println("Email sent! Message ID: " + emailResponse.messageId());
        } catch (SesException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        } finally {
            sesClient.close();
        }
    }
}
