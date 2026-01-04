package com.gdn.patterns.behavioral.command;

// Receiver - Text Document
class TextDocument {
    private StringBuilder content = new StringBuilder();
    
    public void insertText(int position, String text) {
        content.insert(position, text);
        System.out.println("  Inserted: '" + text + "' at position " + position);
    }
    
    public void deleteText(int position, int length) {
        String deleted = content.substring(position, position + length);
        content.delete(position, position + length);
        System.out.println("  Deleted: '" + deleted + "' from position " + position);
    }

    public String getContent() {
        return content.toString();
    }
    
    public void display() {
        System.out.println("Document: [" + content.toString() + "]");
    }
}

