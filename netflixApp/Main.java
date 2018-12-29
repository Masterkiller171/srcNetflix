package netflixApp;

import netflixApp.GUI.GUIelements.Layout;
import netflixApp.GUI.Interface;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        Interface ui = new Interface();

        ui.setLayoutType(Layout.MAIN);
        SwingUtilities.invokeLater(ui);
    }


}
