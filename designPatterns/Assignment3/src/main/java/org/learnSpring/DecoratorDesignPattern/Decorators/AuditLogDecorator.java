package org.learnSpring.DecoratorDesignPattern.Decorators;

import org.learnSpring.DecoratorDesignPattern.DocumentProcessor;
import org.learnSpring.FacadeDesignPattern.DocumentProcessorDecorator;
import org.learnSpring.Prototype.Document;

public class AuditLogDecorator extends DocumentProcessorDecorator {
    private boolean audit = true;

    public AuditLogDecorator(DocumentProcessor processor) {
        super(processor);
    }

    @Override
    public Document process(Document doc) {
        Document processed = processor.process(doc);
        processed.setContent(processed.getContent()+"audited");
        processed.getMetadata().put("audit", String.valueOf(audit));
        return processed;
    }
}

