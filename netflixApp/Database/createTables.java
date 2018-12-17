package netflixApp.Database;

import java.sql.Connection;
import java.sql.Statement;

public class createTables {
    private Connection conn;

    public createTables(Connection conn) {
        this.conn = conn;
    }

    public void constructDB(){
        try {
            Statement sta = conn.createStatement();
            createDB(sta);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Er is een fout opgelopen met het maken van de database");
        }
    }

    private void createDB(Statement state){
        String queryTableExist = "IF EXIST Table  THEN (INSERT INTO tableName VALUES (value1,value2)";
        String queryTableDoesNotExist = "ELSE CREATE tableName (INSERT INTO tableName VALUES (value1,value2))";

        try {
            state.executeQuery(queryTableExist + queryTableDoesNotExist);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Query kon niet uitgevoerd worden");
        }
    }

}
