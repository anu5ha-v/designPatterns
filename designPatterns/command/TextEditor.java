package com.gdn.patterns.behavioral.command;

import java.util.Stack;

// Invoker - Command Manager with Undo/Redo
public class TextEditor {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();
    public TextDocument document;
    
    public TextEditor() {
        this.document = new TextDocument();
    }
    
    public void executeCommand(Command command) {
        System.out.println("\nExecuting: " + command.getDescription());
        command.execute();
        undoStack.push(command);
        redoStack.clear(); // Clear redo stack on new command
        document.display();
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("\nNothing to undo!");
            return;
        }
        
        Command command = undoStack.pop();
        System.out.println("\nUndo: " + command.getDescription());
        command.undo();
        redoStack.push(command);
        document.display();
    }
    
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("\nNothing to redo!");
            return;
        }
        
        Command command = redoStack.pop();
        System.out.println("\nRedo: " + command.getDescription());
        command.execute();
        undoStack.push(command);
        document.display();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        
        System.out.println("========== Text Editor Demo ==========");
        
        // Type some text
        editor.executeCommand(new InsertTextCommand(editor.document, 0, "Hello"));
        editor.executeCommand(new InsertTextCommand(editor.document, 5, " World"));
        editor.executeCommand(new InsertTextCommand(editor.document, 11, "!"));
        
        // Undo last operation
        editor.undo(); // Remove "!"
        
        // Redo
        editor.redo(); // Add "!" back
        
        // Delete some text
        editor.executeCommand(new DeleteTextCommand(editor.document, 5, 6));
        
        System.out.println("\n✓ All operations are encapsulated as commands!");
        System.out.println("✓ Full undo/redo support!");
    }
}

