package netflixApp;

import java.sql.*;

public class connector {
    public connector() {
    }

    //Will return a connection object to connect to our database
    public Connection getCon() {

        //Database connectionURL
        String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Netflix;integratedSecurity=true;";
       //String connectionUrl = "jdbc:sqlserver://localhost\\SQLSERVER;databaseName=Netflix;integratedSecurity=true;";

        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("Gefeliciteerd de database is geconnect wil je nu een sticker");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Database is niet geconnect noob");
        }
        return con;
    }
}
