package netflixApp;

import netflixApp.Database.connector;
import netflixApp.GUI.GUIelements.Layout;
import netflixApp.GUI.Interface;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Interface ui = new Interface();
        connector connector = new connector();
//        Connection conn = connector.getCon();

        ui.setLayoutType(Layout.MAIN);
        SwingUtilities.invokeLater(ui);
    }


}
