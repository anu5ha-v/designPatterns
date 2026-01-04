package org.learnSpring.ConcreateDevices;

import org.learnSpring.Receiver.SmartDevice;
import org.learnSpring.Subject.DeviceEventPublisher;

public class SmartDoorLock implements SmartDevice {

    private boolean flag;
    private DeviceEventPublisher publisher;
    @Override
    public void turnOn() {
        publisher.deviceStateChanged("SmartDoor lock turned ON");
        System.out.println("Turning On the Smart Door Lock");
        flag = true;
    }

    @Override
    public void turnOff() {
        publisher.deviceStateChanged("SmartDoor lock turned OFF");
        System.out.println("Turning Off the Smart Door Lock");
        flag = false;
    }

    @Override
    public boolean getStatus() {
        publisher.deviceStateChanged("The status of smart Door lock is: "+flag);
        System.out.println("The flag of Smart Door is: "+flag);
        return flag;
    }

    public SmartDoorLock(DeviceEventPublisher publisher) {
        this.publisher = publisher;
    }
}
