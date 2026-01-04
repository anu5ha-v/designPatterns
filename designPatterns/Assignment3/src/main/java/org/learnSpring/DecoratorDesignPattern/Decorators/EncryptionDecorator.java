package org.learnSpring.DecoratorDesignPattern.Decorators;

import org.learnSpring.DecoratorDesignPattern.DocumentProcessor;
import org.learnSpring.FacadeDesignPattern.DocumentProcessorDecorator;
import org.learnSpring.Prototype.Document;

public class EncryptionDecorator extends DocumentProcessorDecorator {
    private String encryptionKey;

    public EncryptionDecorator(DocumentProcessor processor, String encryptionKey) {
        super(processor);
        this.encryptionKey = encryptionKey;
    }

    @Override
    public Document process(Document doc) {
        Document processed = processor.process(doc);
        processed.setContent(processed.getContent()+"encrpted");
        processed.getMetadata().put("encrypted", "true");
        processed.getMetadata().put("encryptionKey", encryptionKey);
        return processed;
    }

}

