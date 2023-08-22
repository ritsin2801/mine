package com.nagarro.DesignPattern.factory;

public class SMSChannel implements NotificationChannel {
    @Override
    public void sendNotification(String subject, String messageBody) {
        // Actual SMS sending logic here
        System.out.println("Sending SMS: Subject - " + subject + ", Body - " + messageBody);
    }
}
