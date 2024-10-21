package org.design.structural.adpater;

// Adaptee (SQLDatabase)
public class SQLDatabase {
    public void insertSQL(Object data) {
        System.out.println("Saving data in SQL Database.");
    }

    public Object querySQL(String query) {
        System.out.println("Fetching data from SQL Database.");
        return new Object();
    }

    public void deleteSQL(String query) {
        System.out.println("Deleting data from SQL Database.");
    }
}
