package org.design.structural.adpater;

public class NoSQLDatabaseAdapter implements Database{

    private NoSQLDatabase noSQLDatabase;

    public NoSQLDatabaseAdapter(NoSQLDatabase noSQLDatabase) {
        this.noSQLDatabase = noSQLDatabase;
    }

    @Override
    public void save(Object data) {
        noSQLDatabase.insertDocument(data);
    }

    @Override
    public Object fetch(String query) {
        return noSQLDatabase.findDocument(query);
    }

    @Override
    public void delete(String query) {
        noSQLDatabase.removeDocument(query);
    }
}
