package org.learnSpring.FacadeDesignPattern;

import org.learnSpring.Prototype.Document;

public interface DocumentStorage {
    void save(Document doc, String id);
    Document retrieve(String id);
}

