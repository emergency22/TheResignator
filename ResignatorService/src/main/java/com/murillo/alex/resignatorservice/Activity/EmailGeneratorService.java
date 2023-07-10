package com.murillo.alex.resignatorservice.Activity;

import com.murillo.alex.resignatorservice.Entity.Email;
import com.murillo.alex.resignatorservice.Activity.Requests.EmailGenerationRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailGeneratorService {

//    EmailFormatterService emailFormatterService;
//
//    public EmailGeneratorService(EmailFormatterService emailFormatterService) {
//        this.emailFormatterService = emailFormatterService;
//    }

    private Email generateEmail(EmailGenerationRequest emailGenerationRequest) {
        String recipientAddress = emailGenerationRequest.getRecipientAddress();
        String recipientName = emailGenerationRequest.getRecipientFirstName();
        String position = emailGenerationRequest.getPosition();
        String organization = emailGenerationRequest.getOrganization();
        String signature = emailGenerationRequest.getSenderFirstName();
        String senderAddress = emailGenerationRequest.getSenderAddress();
        String senderPhone = emailGenerationRequest.getSenderPhone();
        SimpleDateFormat executionDate = emailGenerationRequest.getExecutionDate();
        SimpleDateFormat lastDay = emailGenerationRequest.getLastDay();

        //service will perform all the formatting and generate an optimized email.
        String formattedRecipientName = formatName(recipientName);
        String formattedPosition = formatName(position);
        String formattedOrganization = formatName(organization);
        String formattedSignature = formatName(signature);
//        String formattedSenderPhone = formatPhone(senderPhone);
        String formattedExecutionDate = formatDate(executionDate);
        String formattedLastDay = formatDate(lastDay);

        return new Email(recipientAddress, formattedRecipientName, formattedPosition, formattedOrganization, formattedSignature, senderAddress, senderPhone, formattedExecutionDate, formattedLastDay);
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

//    private String formatPhone(String senderPhone) {
//
//    }

    private String formatDate(SimpleDateFormat inputDate) {
        Date date = new Date(String.valueOf(inputDate));
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");
        String formattedDate = formatter.format(date);
        return formattedDate;
    }

}
