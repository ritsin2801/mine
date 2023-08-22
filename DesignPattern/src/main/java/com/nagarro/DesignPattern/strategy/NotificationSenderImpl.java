package com.nagarro.DesignPattern.strategy;

import com.nagarro.DesignPattern.factory.NotificationChannel;

public class NotificationSenderImpl  implements NotificationSender{

	 private NotificationChannel channel;

	    public NotificationSenderImpl(NotificationChannel channel) {
	        this.channel = channel;
	    }

	    @Override
	    public void sendNotification(String subject, String messageBody) {
	        channel.sendNotification(subject, messageBody);
	    }
}
