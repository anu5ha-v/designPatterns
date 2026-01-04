package org.learnSpring.FacadeDesignPattern;

import org.learnSpring.Prototype.Document;

import java.util.UUID;

public class DocumentServiceFacade {
    private DocumentValidator validator;
    private DocumentStorage storage;

    public DocumentServiceFacade() {
        this.validator = new BasicDocumentValidator();
        this.storage = new InMemoryDocumentStorage();
    }

    public Document saveDocument(Document doc) {
        System.out.println("saving Document");
        return doc;
    }

    public Document retrieveDocument(String id) {
        return storage.retrieve(id);
    }

    public boolean validateDocument(Document doc) {
        return validator.validate(doc);
    }
}

