package org.learnSpring.DecoratorDesignPattern.Decorators;

import org.learnSpring.DecoratorDesignPattern.DocumentProcessor;
import org.learnSpring.FacadeDesignPattern.DocumentProcessorDecorator;
import org.learnSpring.Prototype.Document;

public class WatermarkDecorator extends DocumentProcessorDecorator {
    private String watermark;

    public WatermarkDecorator(DocumentProcessor processor, String watermark) {
        super(processor);
        this.watermark = watermark;
    }

    @Override
    public Document process(Document doc) {
        Document processed = processor.process(doc);
        processed.getMetadata().put("watermark", watermark);
        processed.setContent(processed.getContent() + "[Watermark: " + watermark + "]");
        return processed;
    }
}

