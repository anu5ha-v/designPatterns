package com.gdn.patterns.behavioral.command;

// Concrete Commands
class InsertTextCommand implements Command {
    private TextDocument document;
    private String text;
    private int position;
    
    public InsertTextCommand(TextDocument doc, int position, String text) {
        this.document = doc;
        this.position = position;
        this.text = text;
    }
    
    @Override
    public void execute() {
        document.insertText(position, text);
    }

    @Override
    public void undo() {
        // Undo insert by deleting what was inserted
        document.deleteText(position, text.length());
    }
    
    @Override
    public String getDescription() {
        return "Insert '" + text + "'";
    }
}

