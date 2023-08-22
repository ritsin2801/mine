package com.nagarro.DesignPattern.factory;

import com.nagarro.DesignPattern.adapter.SMSChannelAdapter;

public class NotificationChannelFactory {

	 public static NotificationChannel createChannel(String channelType) {
	        if (channelType.equalsIgnoreCase("Email")) {
	            return new EmailChannel();
	        } else if (channelType.equalsIgnoreCase("SMS")) {
	            return new SMSChannelAdapter();
	        }
	        throw new IllegalArgumentException("Invalid channel type");
	    }
}
