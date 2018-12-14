package netflixApp;

import netflixApp.GUI.Interface;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Interface ui = new Interface();
        connector connector = new connector();
        connector.getCon();
        SwingUtilities.invokeLater(ui);
    }
}
