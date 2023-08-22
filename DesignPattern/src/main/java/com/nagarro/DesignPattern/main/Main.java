package com.nagarro.DesignPattern.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nagarro.DesignPattern.factory.NotificationChannel;
import com.nagarro.DesignPattern.factory.NotificationChannelFactory;
import com.nagarro.DesignPattern.observer.NotificationService;
import com.nagarro.DesignPattern.observer.User;
import com.nagarro.DesignPattern.strategy.NotificationSender;
import com.nagarro.DesignPattern.strategy.NotificationSenderImpl;


public class Main {
    public static void main(String[] args) {
        // Create users and subscribe them to notifications
        User user1 = new User("User1");
        User user2 = new User("User2");

        NotificationService notificationService = NotificationService.getInstance();
        notificationService.addObserver(user1);
        notificationService.addObserver(user2);

        // Set up BufferedReader to take user input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter channel type: ");
            String channelType = reader.readLine();

            System.out.print("Enter subject: ");
            String subject = reader.readLine();

            System.out.print("Enter message body: ");
            String messageBody = reader.readLine();

            System.out.print("Enter recipient: ");
            String recipient = reader.readLine();

            // Create appropriate channel using the factory pattern
            NotificationChannel channel = NotificationChannelFactory.createChannel(channelType);

            // Create notification sender using the strategy pattern
            NotificationSender sender = new NotificationSenderImpl(channel);

            // Send notification
            sender.sendNotification(subject, messageBody);

            // Notify observers (users)
            notificationService.notifyObservers("New notification: " + subject);

            // Simulate sending notification to the specified recipient
            System.out.println("Sending notification to recipient: " + recipient);

            // Close the BufferedReader
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
