package org.learnSpring.ConcreateDevices;

import org.learnSpring.Receiver.SmartDevice;
import org.learnSpring.Subject.DeviceEventPublisher;

public class SmartThermostat implements SmartDevice {

    private boolean flag;
    private DeviceEventPublisher publisher;

    @Override
    public void turnOn() {
        publisher.deviceStateChanged("Smart Thermostat turned ON");
        System.out.println("Turning On the Smart Thermostat Lock");
        flag = true;
    }

    @Override
    public void turnOff() {
        publisher.deviceStateChanged("Smart Thermostat turned OFF");
        System.out.println("Turning Off the Smart Thermostat Lock");
        flag = false;
    }

    @Override
    public boolean getStatus() {
        publisher.deviceStateChanged("The state of the Thermostat is: "+flag);
        System.out.println("The flag of Smart Thermostat is: "+flag);
        return flag;
    }

    public SmartThermostat(DeviceEventPublisher publisher) {
        this.publisher = publisher;
    }
}
