package org.learnSpring.BuilderPattern;

import org.learnSpring.Commands.Command;

public class AutomationRule {

    private final String ruleName;
    private final String triggerDevice;
    private final String triggerCondition;
    private final Command actionCommand;
    private final String schedule;
    private final boolean enabled;

    private AutomationRule(Builder builder) {
        this.ruleName = builder.ruleName;
        this.triggerDevice = builder.triggerDevice;
        this.triggerCondition = builder.triggerCondition;
        this.actionCommand = builder.actionCommand;
        this.schedule = builder.schedule;
        this.enabled = builder.enabled;
    }

    public static class Builder {
        private String ruleName;
        private String triggerDevice;
        private String triggerCondition;
        private Command actionCommand;
        private String schedule;
        private boolean enabled = true; // default

        public Builder ruleName(String ruleName) {
            this.ruleName = ruleName;
            return this;
        }

        public Builder triggerDevice(String triggerDevice) {
            this.triggerDevice = triggerDevice;
            return this;
        }

        public Builder triggerCondition(String triggerCondition) {
            this.triggerCondition = triggerCondition;
            return this;
        }

        public Builder actionCommand(Command actionCommand) {
            this.actionCommand = actionCommand;
            return this;
        }

        public Builder schedule(String schedule) {
            this.schedule = schedule;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public AutomationRule build() {
            return new AutomationRule(this);
        }
    }

    @Override
    public String toString() {
        return "AutomationRule{" +
                "ruleName='" + ruleName + '\'' +
                ", triggerDevice='" + triggerDevice + '\'' +
                ", triggerCondition='" + triggerCondition + '\'' +
                ", actionCommand=" + actionCommand +
                ", schedule='" + schedule + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}

