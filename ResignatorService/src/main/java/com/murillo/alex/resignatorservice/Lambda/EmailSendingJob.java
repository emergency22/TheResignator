package com.murillo.alex.resignatorservice.Lambda;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EmailSendingJob implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //logic to send the email using the data from EmailGenerationResponse object
        //The required data can be extracted from the JobExecutionContext
    }
}
