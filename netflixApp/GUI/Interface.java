package netflixApp.GUI;

import netflixApp.GUI.GUIelements.GUI;
import netflixApp.GUI.GUIelements.Layout;
import netflixApp.GUI.GUIelements.centerSector.createPieChart;

import javax.swing.*;
import java.awt.*;

public class Interface implements Runnable{
    private JFrame frame;
    private final int x = Toolkit.getDefaultToolkit().getScreenSize().width; //Getting the horizontal screen size

    //The layoutType is a variable which contains the page id
    //Default is 1 (main page)
    private Layout layoutType;
    @Override
    public void run() {
        frame = new JFrame("Netflix app -Youri Bontekoe en Winson Ngoh");
        //frame.setPreferredSize(new Dimension(x,y));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createElements(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }


    //Will determent which layoutType is chosen en adding the layout to the canvas
    public Container createElements(Container contentPane) {
            switch (this.layoutType) {
                case MAIN:
                    contentPane.removeAll();
                    GUI ui = new GUI(contentPane, Layout.MAIN);
                    return ui.getUi();

                case RESET:
                    contentPane.removeAll();
                    ui = new GUI(contentPane, Layout.RESET);
                    return ui.getUi();

                case PIECHART:
                   contentPane.removeAll();
                   ui = new GUI(contentPane, Layout.PIECHART);
                   return ui.getUi();
            }
        //When there is no valid layoutType it will throw this Exception
       throw  new IllegalArgumentException("Er is geen layoutType!");
    }

    //Will set the layoutType so that it won't reset to 0 each frame
    public void setLayoutType(Layout layoutType) {
        this.layoutType = layoutType;
    }

    //Getter for the x value of the frame so that the layout classes may take this value to calculate the max
    //size of the frame
    public int getX() {
        return x;
    }

}
