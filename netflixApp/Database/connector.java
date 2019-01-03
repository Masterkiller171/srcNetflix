package netflixApp.Database;

import java.sql.*;

public class connector {
    public connector() {
    }

    //Will return a connection object to connect to our database
    public Connection getCon() {

        //Database connectionURL
        String connectionUrl = "jdbc:sqlserver://den1.mssql8.gear.host;databaseName=Netflixx;username = netflixx; password= Lv942-l1D6-I;";
        //String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;database=Netflix;integratedSecurity=true;";

        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("A connection has been established between the client and the database. Alexa THIS is EPIC!");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("The client couldn't connect to the database. I'm sorry, please don't spank me.");
        }
        return con;
    }
}
