package com.nagarro.DesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private static NotificationService instance;

    private List<Observer> observers;

    private NotificationService() {
        observers = new ArrayList<>();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
