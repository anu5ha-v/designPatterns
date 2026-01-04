package org.learnSpring.FacadeDesignPattern;

import org.learnSpring.DecoratorDesignPattern.DocumentProcessor;
import org.learnSpring.Prototype.Document;

public abstract class DocumentProcessorDecorator implements DocumentProcessor {
    protected DocumentProcessor processor;

    public DocumentProcessorDecorator(DocumentProcessor processor) {
        this.processor = processor;
    }

    @Override
    public Document process(Document doc) {
        return processor.process(doc);
    }
}

