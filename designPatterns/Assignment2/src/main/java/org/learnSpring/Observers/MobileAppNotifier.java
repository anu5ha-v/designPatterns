package org.learnSpring.Observers;

public class MobileAppNotifier implements DeviceEventObserver {
    @Override
    public void update(String message) {
        System.out.println("Notification from mobile app" + message);
    }
}
