package netflixApp.GUI;

import netflixApp.GUI.GUIelements.GUI;

import javax.swing.*;
import java.awt.*;

public class Interface implements Runnable{
    private JFrame frame;
    private int x = 1000;
    private int y = 1000;

    //The layoutType is a variable which contains the page id
    //Default is 1 (main page)
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


    //Will determent which layoutType is chosen en adding the layout to the canvas
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
       throw  new IllegalArgumentException("Er is geen layoutType!");
    }

    //Will set the layoutType so that it won't reset to 0 each frame
    public void setLayoutType(int layoutType) {
        this.layoutType = layoutType;
    }

    //Getter for the x value of the frame so that the layout classes may take this value to calculate the max
    //size of the frame
    public int getX() {
        return x;
    }

}
