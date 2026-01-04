package org.learnSpring.FacadeDesignPattern;

import org.learnSpring.Prototype.Document;

import java.util.HashMap;
import java.util.Map;

public class FacadeApplication {
    public static void main(String[] args) {
        DocumentServiceFacade facade = new DocumentServiceFacade();
        Map<String, String> metadata = new HashMap<>();
//       facade.validateDocument()
    }
}

