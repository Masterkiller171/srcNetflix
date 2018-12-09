package netflixApp.GUI;

import netflixApp.GUI.GUIelements.GUI;

import javax.swing.*;
import java.awt.*;

public class Interface implements Runnable{
    private JFrame frame;


    @Override
    public void run() {
        frame = new JFrame("Netflix app");
        frame.setPreferredSize(new Dimension(800,800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createElements(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }


    private void createElements(Container contentPane) {
        GUI ui = new GUI(contentPane);
        contentPane = ui.getUi();
    }
}
