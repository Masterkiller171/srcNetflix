package netflixApp.GUI;

import netflixApp.GUI.GUIelements.GUI;
import netflixApp.GUI.GUIelements.sectors.centerSector;

import javax.swing.*;
import java.awt.*;

public class Interface implements Runnable{
    private JFrame frame;
    private int x = 1000;
    private int y = 1000;
    private int layoutType;
    @Override
    public void run() {
        frame = new JFrame("Netflix app");
        frame.setPreferredSize(new Dimension(x,y));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createElements(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }


    public Container createElements(Container contentPane) {
        if (layoutType <= 1) {
            contentPane.removeAll();
            GUI ui = new GUI(contentPane, 1);
            return ui.getUi();
        }else if (layoutType == 2){
            contentPane.removeAll();
            GUI ui = new GUI(contentPane, 2);
            return ui.getUi();
        }
       // ui.getUi().removeAll();
       throw  new IllegalArgumentException("Er is geen layoutType!");
    }

    public void setLayoutType(int layoutType) {
        this.layoutType = layoutType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
