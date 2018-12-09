package netflixApp.GUI.GUIelements;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;

import java.awt.*;

public class GUI {
    private Container container;



    public GUI(Container container) {
        this.container = container;
    }

    //Constructing the layout
    private void createLayout(){
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

        container.add(setNorth(), BorderLayout.NORTH);
        container.add(setWest(), BorderLayout.WEST);
        container.add(setCenter(), BorderLayout.CENTER);
        container.add(setSouth(), BorderLayout.SOUTH);
    }



    //Setting up the North section
    private JPanel setNorth(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(2,3);
        panel.setLayout(grid);

        panel.add(new JTextArea("test"));

        return panel;
    }

    //Setting up the west section
    private JPanel setWest(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(3,0);
        panel.setLayout(grid);

        panel.add(new JLabel("test"));
        panel.add(new JLabel("test"));
        panel.add(new JLabel("test"));

        return panel;
    }

    //Setting up the center section
    private JPanel setCenter(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(10,10);
        panel.setLayout(grid);

        panel.add(new JTextArea("testerdetesttest"));

        return panel;
    }

    //Setting up the south section
    private JPanel setSouth(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(2,8);
        panel.setLayout(grid);

        //Adding empty Panels to align the JButton
        for (int x = 0; x < 2; x++) {
            panel.add(new JPanel());
        }

        //A button
        panel.add(new JButton("tester"));

        //Adding empty Panels to align the JButton
        for (int x = 0; x < 6; x++) {
            panel.add(new JPanel());
        }



        return panel;
    }



    //Returning the constructed layout to the interface class
    public Container getUi() {
        createLayout();

        return container;
    }
}
