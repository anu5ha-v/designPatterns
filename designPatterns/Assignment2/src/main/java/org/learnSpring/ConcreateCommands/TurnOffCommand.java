package org.learnSpring.ConcreateCommands;

import org.learnSpring.Commands.Command;
import org.learnSpring.Receiver.SmartDevice;

public class TurnOffCommand implements Command {

    private final SmartDevice device;

    public TurnOffCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}
