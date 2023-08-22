package com.nagarro.DesignPattern.factory;

public class EmailChannel implements NotificationChannel {
    @Override
    public void sendNotification(String subject, String messageBody) {
        // Actual email sending logic here
        System.out.println("Sending email: Subject - " + subject + ", Body - " + messageBody);
    }
}