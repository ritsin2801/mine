package com.nagarro.DesignPattern.adapter;

import com.nagarro.DesignPattern.factory.EmailChannel;
import com.nagarro.DesignPattern.factory.NotificationChannel;

public class EmailChannelAdapter implements NotificationChannel {
    private EmailChannel emailChannel;

    public EmailChannelAdapter() {
        emailChannel = new EmailChannel();
    }

    @Override
    public void sendNotification(String subject, String messageBody) {
        // Adapt the method call to the email channel
        emailChannel.sendNotification(subject, messageBody);
    }
}