package com.nagarro.DesignPattern.adapter;

import com.nagarro.DesignPattern.factory.NotificationChannel;
import com.nagarro.DesignPattern.factory.SMSChannel;

public class SMSChannelAdapter implements NotificationChannel {
	
	private SMSChannel smsChannel;

    public SMSChannelAdapter() {
        smsChannel = new SMSChannel();
    }

    @Override
    public void sendNotification(String subject, String messageBody) {
        // Adapt the method call to the SMS channel
        smsChannel.sendNotification(subject, messageBody);
    }
}
