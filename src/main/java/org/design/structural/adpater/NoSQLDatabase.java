package org.design.structural.adpater;

// Adaptee (NoSQLDatabase)
public class NoSQLDatabase {
    public void insertDocument(Object Document) {
        System.out.println("Saving Document in NOSQL Database.");
    }

    public Object findDocument(String query) {
        System.out.println("Fetching Document from NOSQL Database.");
        return new Object();
    }

    public void removeDocument(String query) {
        System.out.println("Removing Document from NOSQL Database.");
    }
}
