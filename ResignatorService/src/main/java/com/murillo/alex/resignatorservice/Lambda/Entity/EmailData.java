package com.murillo.alex.resignatorservice.Lambda.Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailData {

    private final String recipientAddress;
    private final String subject;
    private final Date executionDate;
    private final String body;

    public EmailData(String recipientAddress, String subject, String executionDateString, String body) {
        this.recipientAddress = recipientAddress;
        this.subject = subject;
        this.executionDate = parseExecutionDate(executionDateString);
        this.body = body;
    }

    private Date parseExecutionDate(String executionDateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(executionDateString);
        } catch (ParseException e) {
            e.printStackTrace(); // or throw an exception based on your use case
            return null;
        }
    }

    public Date getExecutionDate() {
        return executionDate;
    }
}
