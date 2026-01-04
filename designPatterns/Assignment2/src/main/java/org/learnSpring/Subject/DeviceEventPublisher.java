package org.learnSpring.Subject;

import org.learnSpring.Observers.DeviceEventObserver;

public interface DeviceEventPublisher {
    void registerObserver(DeviceEventObserver observer);
    void removeObserver(DeviceEventObserver observer);
    void notifyObservers(String message);
    void deviceStateChanged(String eventMessage);
}
