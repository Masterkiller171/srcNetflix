package netflixApp;

import java.sql.*;

public class connector {
    public connector() {
    }

    //Will return a connection object to connect to our database
    public Connection getCon() {

        //Database connectionURL
        String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Bibliotheek;integratedSecurity=true;";

        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
