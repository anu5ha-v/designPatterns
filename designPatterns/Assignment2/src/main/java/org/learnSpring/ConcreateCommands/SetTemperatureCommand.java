package org.learnSpring.ConcreateCommands;

import org.learnSpring.Commands.Command;
import org.learnSpring.ConcreateDevices.SmartThermostat;


public class SetTemperatureCommand implements Command {
    private String temp;
    private SmartThermostat smartThermostat;

    public SetTemperatureCommand(SmartThermostat smartThermostat) {
        this.smartThermostat = smartThermostat;
    }

    @Override
    public void execute() {
        boolean status = smartThermostat.getStatus();
        System.out.println(status);
        this.temp = "23 celsius";
        System.out.println("The temp is set to: "+ temp);
    }
}
