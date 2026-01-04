package org.learnSpring.Prototype.CloneImpl;

import org.learnSpring.Prototype.Document;

import java.util.Map;

public class Contract extends Document {

    public Contract(String title, String content, Map<String, String> metadata) {
        super(title, content, metadata);
    }

    @Override
    public void display() {
        System.out.println("Contract");
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Metadata: " + metadata);
    }
}
