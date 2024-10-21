package org.design.structural.adpater;

public class SQLDatabaseAdapter implements Database{

    private SQLDatabase sqlDatabase;
    public SQLDatabaseAdapter(SQLDatabase sqlDatabase) {
        this.sqlDatabase = sqlDatabase;
    }

    @Override
    public void save(Object data) {
        sqlDatabase.insertSQL(data);
    }

    @Override
    public Object fetch(String query) {
        return sqlDatabase.querySQL(query);
    }

    @Override
    public void delete(String query) {
        sqlDatabase.deleteSQL(query);
    }
}
