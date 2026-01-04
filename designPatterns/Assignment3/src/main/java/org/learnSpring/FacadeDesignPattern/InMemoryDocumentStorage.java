package org.learnSpring.FacadeDesignPattern;

import org.learnSpring.Prototype.Document;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDocumentStorage implements DocumentStorage {
    private Map<String, Document> storage;

    public InMemoryDocumentStorage() {
        this.storage = new HashMap<>();
    }

    @Override
    public void save(Document doc, String id) {
        storage.put(id, doc);
    }

    @Override
    public Document retrieve(String id) {
        return storage.get(id);
    }
}

