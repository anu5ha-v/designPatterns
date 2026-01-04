package org.learnSpring.DecoratorDesignPattern;

import org.learnSpring.DecoratorDesignPattern.DocumentProcessor;
import org.learnSpring.Prototype.Document;

public class BasicDocumentProcessor implements DocumentProcessor {
    @Override
    public Document process(Document doc) {
        System.out.println("Basic Doc Processer");
        return doc;
    }
}

