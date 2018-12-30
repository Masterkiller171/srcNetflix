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

        tables.constructDB();
        ui.setLayoutType(Layout.MAIN);
        SwingUtilities.invokeLater(ui);
    }


}
