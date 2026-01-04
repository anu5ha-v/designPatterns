package org.learnSpring.Observers;

public class LoggingService implements DeviceEventObserver {
    @Override
    public void update(String message) {
        System.out.println("Event got logged" + message);
    }
}
