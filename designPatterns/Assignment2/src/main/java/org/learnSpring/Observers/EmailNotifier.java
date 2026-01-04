package org.learnSpring.Observers;

public class EmailNotifier implements DeviceEventObserver {
    @Override
    public void update(String message) {
        System.out.println("Notification from Email Notifier" + message);
    }
}
