package org.learnSpring.DecoratorDesignPattern.Decorators;

import org.learnSpring.DecoratorDesignPattern.DocumentProcessor;
import org.learnSpring.FacadeDesignPattern.DocumentProcessorDecorator;
import org.learnSpring.Prototype.Document;

public class CompressionDecorator extends DocumentProcessorDecorator {
    private double compressionRatio;

    public CompressionDecorator(DocumentProcessor processor, double compressionRatio) {
        super(processor);
        this.compressionRatio = compressionRatio;
    }

    @Override
    public Document process(Document doc) {
        Document processed = processor.process(doc);
        int originalSize = processed.getContent().length();
        int compressedSize = (int) (originalSize * compressionRatio);
        processed.getMetadata().put("compressed", "true");
        processed.getMetadata().put("originalSize", String.valueOf(originalSize));
        processed.getMetadata().put("compressedSize", String.valueOf(compressedSize));
        processed.getMetadata().put("compressionRatio", String.valueOf(compressionRatio));
        return processed;
    }
}

