package com.murillo.alex.resignatorservice.Lambda.Requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.text.SimpleDateFormat;

@JsonDeserialize(builder = EmailGenerationRequest.Builder.class)
public class EmailGenerationRequest {
    private final String senderEmail;
    private final String firstName;
    private final String lastName;
    private final String position;
    private final String organization;
    private final String recipientFirstName;
    private final String recipientEmail;
    private final SimpleDateFormat executionDate;
    private final SimpleDateFormat lastDay;

    public EmailGenerationRequest(String senderEmail, String firstName, String lastName, String position, String organization, String recipientFirstName, String recipientEmail, SimpleDateFormat executionDate, SimpleDateFormat lastDay) {
        this.senderEmail = senderEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.organization = organization;
        this.recipientFirstName = recipientFirstName;
        this.recipientEmail = recipientEmail;
        this.executionDate = executionDate;
        this.lastDay = lastDay;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getOrganization() {
        return organization;
    }

    public String getRecipientFirstName() {
        return recipientFirstName;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public SimpleDateFormat getExecutionDate() {
        return executionDate;
    }

    public SimpleDateFormat getLastDay() {
        return lastDay;
    }

    @Override
    public String toString() {
        return "EmailGenerationRequest{" +
                "senderEmail='" + senderEmail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", organization='" + organization + '\'' +
                ", recipientFirstName='" + recipientFirstName + '\'' +
                ", recipientEmail='" + recipientEmail + '\'' +
                ", executionDate=" + executionDate +
                ", lastDay=" + lastDay +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String senderEmail;
        private String firstName;
        private String lastName;
        private String position;
        private String organization;
        private String recipientFirstName;
        private String recipientEmail;
        private SimpleDateFormat executionDate;
        private SimpleDateFormat lastDay;

        public Builder withSenderEmail(String senderEmail) {
            this.senderEmail = senderEmail;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder withOrganization(String organization) {
            this.organization = organization;
            return this;
        }

        public Builder withRecipientFirstName(String recipientFirstName) {
            this.recipientFirstName = recipientFirstName;
            return this;
        }

        public Builder withRecipientEmail(String recipientEmail) {
            this.recipientEmail = recipientEmail;
            return this;
        }

        public Builder withExecutionDate(SimpleDateFormat executionDate) {
            this.executionDate = executionDate;
            return this;
        }

        public Builder withLastDay(SimpleDateFormat lastDay) {
            this.lastDay = lastDay;
            return this;
        }

        public EmailGenerationRequest build() {
            return new EmailGenerationRequest(senderEmail, firstName, lastName, position, organization, recipientFirstName, recipientEmail, executionDate, lastDay);
        }

    }

}
