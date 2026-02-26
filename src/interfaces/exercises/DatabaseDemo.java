package interfaces.exercises;
/*
    We have different databases, Postgres, MySql, SQL Server, MongoDB
    They all fetch data
    Create a client(main method) for databases
    But the databases can be interchangable.
 */

import java.util.Date;

public class DatabaseDemo {
    private Database database;
    DatabaseDemo(Database database){
        this.database = database;

    }


    public static void main(String[] args) {
        DatabaseDemo myMongoDb = new DatabaseDemo(new MongoDB());
        myMongoDb.database.fetch();
        DatabaseDemo mySQl = new DatabaseDemo(new SQLServer());
        mySQl.database.fetch();
    }
}




interface Database{
    void fetch();
}

class Postgres implements Database{
    @Override
    public void fetch() {
        System.out.println("Postgres database is fetching");
    }
}

class MySql implements Database{
    @Override
    public void fetch() {
        System.out.println("MySql database is fetching");
    }
}

class SQLServer implements Database{
    @Override
    public void fetch() {
        System.out.println("SQL Server database is fetching");
    }
}

class MongoDB implements Database{
    @Override
    public void fetch() {
        System.out.println("MongoDB database is fetching");
    }
}
