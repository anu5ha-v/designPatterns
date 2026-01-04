package org.learnSpring.Prototype;

import org.learnSpring.Prototype.CloneImpl.Contract;
import org.learnSpring.Prototype.CloneImpl.Invoice;
import org.learnSpring.Prototype.Document;

import java.util.HashMap;
import java.util.Map;

public class DocumentRegistry {
    private Map<String, Document> templates;

    public DocumentRegistry() {
        this.templates = new HashMap<>();
    }

    public void registerTemplate(String key, Document template) {
        templates.put(key, template);
    }

    public Document getDocument(String key) throws CloneNotSupportedException {
        return templates.get(key).clone();
    }

    public static void main(String[] args) {
        DocumentRegistry registry = new DocumentRegistry();

        Map<String, String> invoiceMetadata = new HashMap<>();
        invoiceMetadata.put("type", "invoice");
        invoiceMetadata.put("template", "standard");
        Invoice invoiceTemplate = new Invoice("Invoice Template", "Base invoice content", invoiceMetadata);
        registry.registerTemplate("invoice", invoiceTemplate);

        Map<String, String> contractMetadata = new HashMap<>();
        contractMetadata.put("type", "contract");
        contractMetadata.put("template", "standard");
        Contract contractTemplate = new Contract("Contract Template", "Base contract content", contractMetadata);
        registry.registerTemplate("contract", contractTemplate);

        System.out.println("\n1. Creating documents from templates:");
        try {
            Document invoice1 = registry.getDocument("invoice");
            invoice1.setTitle("Invoice 1");
            invoice1.setContent("Payment for services rendered");
            invoice1.getMetadata().put("amount", "1000.00");
            invoice1.getMetadata().put("customer", "John Doe");

            Document invoice2 = registry.getDocument("invoice");
            invoice2.setTitle("Invoice 2");
            invoice2.setContent("Payment for products");
            invoice2.getMetadata().put("amount", "2500.00");
            invoice2.getMetadata().put("customer", "Jane Smith");

            System.out.println("--->Invoice 1:");
            invoice1.display();

            System.out.println("Invoice 2 cloned one---->");
            invoice2.display();

            Document contract = registry.getDocument("contract");
            contract.setTitle("Agreement");
            contract.setContent("Terms and conditions");
            contract.getMetadata().put("parties", "Company A & Company B");
            contract.getMetadata().put("duration", "2 years");

            System.out.println("Contract cloned one---->");
            contract.display();

        } catch (CloneNotSupportedException e) {
            System.err.println("Clone error: " + e.getMessage());
        }
    }
}

