package org.learnSpring.FacadeDesignPattern;

import org.learnSpring.Prototype.Document;

public class BasicDocumentValidator implements DocumentValidator {
    private String validationMessage;

    @Override
    public boolean validate(Document doc) {
        if (doc == null) {
            validationMessage = "Document is null";
            return false;
        }

        if (doc.getTitle() == null || doc.getTitle().trim().isEmpty()) {
            validationMessage = "Document title is required";
            return false;
        }

        if (doc.getContent() == null || doc.getContent().trim().isEmpty()) {
            validationMessage = "Document content is required";
            return false;
        }

        validationMessage = "Document is valid";
        return true;
    }

    @Override
    public String getValidationMessage() {
        return validationMessage;
    }
}

