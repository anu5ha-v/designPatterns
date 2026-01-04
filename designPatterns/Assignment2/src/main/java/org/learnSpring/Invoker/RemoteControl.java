package org.learnSpring.Invoker;

import org.learnSpring.BuilderPattern.AutomationRule;
import org.learnSpring.Commands.Command;
import org.learnSpring.ConcreateCommands.SetTemperatureCommand;
import org.learnSpring.ConcreateCommands.TurnOffCommand;
import org.learnSpring.ConcreateCommands.TurnOnCommand;
import org.learnSpring.ConcreateDevices.SmartDoorLock;
import org.learnSpring.ConcreateDevices.SmartLight;
import org.learnSpring.ConcreateDevices.SmartThermostat;
import org.learnSpring.Observers.EmailNotifier;
import org.learnSpring.Observers.LoggingService;
import org.learnSpring.Observers.MobileAppNotifier;
import org.learnSpring.Subject.DeviceEventPublisherImpl;

public class RemoteControl {
    DeviceEventPublisherImpl publisher = new DeviceEventPublisherImpl();
    SmartThermostat smartThermostat;
    SmartDoorLock smartDoorLock;
    SmartLight smartLight;

    public RemoteControl() {

        publisher.registerObserver(new MobileAppNotifier());
        publisher.registerObserver(new EmailNotifier());
        publisher.registerObserver(new LoggingService());

        this.smartThermostat = new SmartThermostat(publisher);
        this.smartDoorLock = new SmartDoorLock(publisher);
        this.smartLight = new SmartLight(publisher);
    }

    public void executeCommand(Command command){
        System.out.println("Executing Command---->");
        command.execute();
    }

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

//        remoteControl.executeCommand(new SetTemperatureCommand(remoteControl.smartThermostat));
        remoteControl.executeCommand(new TurnOnCommand(remoteControl.smartLight));
        remoteControl.executeCommand(new TurnOffCommand(remoteControl.smartLight));
//
//        remoteControl.executeCommand(new TurnOnCommand(remoteControl.smartDoorLock));
//        remoteControl.executeCommand(new TurnOffCommand(remoteControl.smartDoorLock));
//
//        remoteControl.executeCommand(new TurnOnCommand(remoteControl.smartThermostat));
//        remoteControl.executeCommand(new TurnOffCommand(remoteControl.smartThermostat));

        AutomationRule eveningLightRule =
                new AutomationRule.Builder()
                        .ruleName("Switching On Lights")
                        .triggerDevice("Smart light")
                        .triggerCondition("Evening")
                        .actionCommand(new TurnOnCommand(remoteControl.smartLight))
                        .schedule("7pm")
                        .enabled(true)
                        .build();
        System.out.println("Builder Design--->"+eveningLightRule);

    }
}
