package org.learnSpring.Subject;

import org.learnSpring.Observers.DeviceEventObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class DeviceEventPublisherImpl implements DeviceEventPublisher{
    private List<DeviceEventObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(DeviceEventObserver observer) {
        observers.add(observer);
        System.out.println("Registering an observer");
    }

    @Override
    public void removeObserver(DeviceEventObserver observer) {
        observers.remove(observer);
        System.out.println("Removing an observer");
    }

    @Override
    public void notifyObservers(String message) {
        System.out.println("Onserver size is: "+observers.size());
        for(DeviceEventObserver observer: observers){
            observer.update(message+" "+observer.getClass().getName());
        }
    }

    @Override
    public void deviceStateChanged(String eventMessage) {
        System.out.println("Event sent is this-->"+eventMessage);
        notifyObservers("Event sent to Observer");
    }
}
