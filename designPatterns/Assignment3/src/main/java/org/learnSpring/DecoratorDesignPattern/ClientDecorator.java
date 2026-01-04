package org.learnSpring.DecoratorDesignPattern;

import org.learnSpring.DecoratorDesignPattern.Decorators.AuditLogDecorator;
import org.learnSpring.DecoratorDesignPattern.Decorators.CompressionDecorator;
import org.learnSpring.DecoratorDesignPattern.Decorators.EncryptionDecorator;
import org.learnSpring.DecoratorDesignPattern.Decorators.WatermarkDecorator;
import org.learnSpring.Prototype.CloneImpl.Invoice;
import org.learnSpring.Prototype.Document;

import java.util.HashMap;
import java.util.Map;

public class ClientDecorator {
    public static void main(String[] args) throws CloneNotSupportedException {

        Map<String, String> metadata = new HashMap<>();
        metadata.put("author", "System");
        Invoice originalDoc = new Invoice("Original Invoice", "Original content here", metadata);

        System.out.println("1. Original Document:");
        originalDoc.display();

        DocumentProcessor basicProcessor = new BasicDocumentProcessor();

        System.out.println("2. After Watermark Decorator:");
        DocumentProcessor watermarkProcessor = new WatermarkDecorator(basicProcessor, "CONFIDENTIAL");
        Document watermarked = watermarkProcessor.process(originalDoc.clone());
        watermarked.display();

        System.out.println("3. After Multiple Decorators (Audit -> Encryption -> Watermark):");
        DocumentProcessor chainedProcessor = new AuditLogDecorator(
                new EncryptionDecorator(
                        new WatermarkDecorator(
                                basicProcessor,
                                "CONFIDENTIAL"
                        ),
                        "secret"
                )
        );
        Document processed = chainedProcessor.process(originalDoc.clone());
        processed.display();

        System.out.println("4. After Compression Decorator:");
        DocumentProcessor compressionProcessor = new CompressionDecorator(basicProcessor, 0.6);
        Document compressed = compressionProcessor.process(originalDoc.clone());
        compressed.display();
    }
}
