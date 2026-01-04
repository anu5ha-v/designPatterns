package org.learnSpring.FacadeDesignPattern;

import org.learnSpring.Prototype.Document;

public interface DocumentValidator {
    boolean validate(Document doc);
    String getValidationMessage();
}

