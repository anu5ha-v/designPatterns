package org.learnSpring.ConcreateDevices;

import org.learnSpring.Receiver.SmartDevice;
import org.learnSpring.Subject.DeviceEventPublisher;

public class SmartLight implements SmartDevice {

    private boolean flag;
    private DeviceEventPublisher publisher;
    @Override
    public void turnOn() {
        System.out.println("Turning On the Smart Light");
        publisher.deviceStateChanged("Smart Light turned ON");
        flag = true;
    }

    @Override
    public void turnOff() {
        System.out.println("Turning Off the Smart Light");
        publisher.deviceStateChanged("Smart Light turned OFF");
        flag = false;
    }

    @Override
    public boolean getStatus() {
        publisher.deviceStateChanged("The state of SmartLight is: "+flag);
        System.out.println("The flag of Smart Light is: "+flag);
        return flag;
    }

    public SmartLight(DeviceEventPublisher publisher) {
        this.publisher = publisher;
    }

}