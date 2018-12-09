package netflixApp;

import netflixApp.GUI.Interface;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Interface ui = new Interface();

        SwingUtilities.invokeLater(ui);
    }
}
