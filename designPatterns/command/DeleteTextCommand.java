package com.gdn.patterns.behavioral.command;

class DeleteTextCommand implements Command {
    private TextDocument document;
    private int position;
    private int length;
    private String deletedText; // Store for undo
    
    public DeleteTextCommand(TextDocument doc, int position, int length) {
        this.document = doc;
        this.position = position;
        this.length = length;
    }

    @Override
    public void execute() {
        // Save text before deleting (for undo)
        deletedText = document.getContent().substring(position, position + length);
        document.deleteText(position, length);
    }
    
    @Override
    public void undo() {
        // Restore deleted text
        document.insertText(position, deletedText);
    }
    
    @Override
    public String getDescription() {
        return "Delete " + length + " chars";
    }
}

