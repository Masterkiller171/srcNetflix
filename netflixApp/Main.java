package netflixApp;

import netflixApp.Database.connector;
import netflixApp.Database.createTables;
import netflixApp.GUI.GUIelements.Layout;
import netflixApp.GUI.Interface;
import javax.swing.*;
import java.sql.Connection;


public class Main {

    public static void main(String[] args) {
        Interface ui = new Interface();
        Connection conn = new connector().getCon();
        createTables tables = new createTables(conn);

        //Checks whether the tables in the DB Netflix exists or not
        //IF NOT it will create the whole db containing all data
        //IF YES it will do nothing and the user may continue to use the application
        tables.constructDB();

        ui.setLayoutType(Layout.MAIN);
        SwingUtilities.invokeLater(ui);
    }


}
