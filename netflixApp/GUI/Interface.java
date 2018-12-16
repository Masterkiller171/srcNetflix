package netflixApp.GUI;

import netflixApp.GUI.GUIelements.GUI;

import javax.swing.*;
import java.awt.*;

public class Interface implements Runnable{
    private JFrame frame;
    private int x = 1000;
    private int y = 1000;

    @Override
    public void run() {
        frame = new JFrame("Netflix app");
        frame.setPreferredSize(new Dimension(x,y));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createElements(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }


    private void createElements(Container contentPane) {
        GUI ui = new GUI(contentPane);
        ui.getUi();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
