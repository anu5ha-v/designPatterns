package com.gdn.patterns.behavioral.command;

// Command Interface with undo support
interface Command {
    void execute();
    void undo();
    String getDescription();
}

