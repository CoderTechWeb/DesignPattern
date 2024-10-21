package org.design.structural.adpater;

public class DatabaseService {

    public void performOperation(Database database) {
        database.save(new Object());
        database.fetch("SELECT * FROM users");
        database.delete("DELETE FROM users WHERE id = 1");
    }

    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();

        //Using SQL Database
        SQLDatabase sqlDatabase = new SQLDatabase();
        Database sqlDatabaseAdapter = new SQLDatabaseAdapter(sqlDatabase);
        databaseService.performOperation(sqlDatabaseAdapter);

        System.out.println("------------------");

        //Using NoSQL Database
        NoSQLDatabase noSQLDatabase = new NoSQLDatabase();
        NoSQLDatabaseAdapter noSQLDatabaseAdapter = new NoSQLDatabaseAdapter(noSQLDatabase);
        databaseService.performOperation(noSQLDatabaseAdapter);
    }
}
