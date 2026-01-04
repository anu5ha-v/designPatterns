package org.learnSpring.ConcreateCommands;

import org.learnSpring.Commands.Command;
import org.learnSpring.Receiver.SmartDevice;

public class TurnOnCommand implements Command {

    private final SmartDevice device;

    public TurnOnCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
