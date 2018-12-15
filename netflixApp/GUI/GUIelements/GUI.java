package netflixApp.GUI.GUIelements;

import netflixApp.GUI.EventListerners.Eventlisteners;
import netflixApp.GUI.GUIelements.sectors.centerSector;
import netflixApp.GUI.Interface;
import sun.font.FontManagerForSGE;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class GUI {
    private Container container;
    private Interface width = new Interface(); //Getting the width from the interface class to make the app more dynamic


    public GUI(Container container) {
        this.container = container;
    }

    //Constructing the layout
    private void createLayout(){
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

        container.add(setNorth(), BorderLayout.NORTH); //Top sector
        container.add(setWest(), BorderLayout.WEST); //Left sector
        container.add(setEast(),BorderLayout.EAST);//Right sector
        container.add(setCenter(), BorderLayout.CENTER); //Center sector
        container.add(setSouth(), BorderLayout.SOUTH); //Bottom sector
    }



    //Setting up the North section
    private JPanel setNorth(){
        JPanel panel = new JPanel();

        //Adding padding to the panel object
        panel.setBorder(new EmptyBorder(5,5,40,5));

        JTextPane textPane = new JTextPane();
        textPane.setBackground(Color.lightGray);
        textPane.setPreferredSize(new Dimension(width.getX() - 50,80));
        textPane.setEditable(false);
        textPane.setText("row 1 \n row 2\n row 3\n");

        panel.add(textPane);

        return panel;
    }

    //Setting up the west section
    private JPanel setWest(){
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,10,5,5));
        panel.setBackground(Color.lightGray);

        GridLayout grid = new GridLayout(10,1,5,10);
        panel.setLayout(grid);

        JButton firstBut = new JButton("test 1");
        firstBut.setPreferredSize(new Dimension(200,10));
        firstBut.setFont(new Font("Arial", Font.BOLD, 15));
        firstBut.setBackground(Color.WHITE);
        panel.add(firstBut);

        JButton secondBut = new JButton("test 2");
        secondBut.setPreferredSize(new Dimension(200,10));
        secondBut.setFont(new Font("Arial", Font.BOLD, 15));
        secondBut.setBackground(Color.WHITE);
        panel.add(secondBut);


        return panel;
    }

    //Setting up the east section
    private JPanel setEast(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(1,1);
        panel.setLayout(grid);

        JLabel testLabel = new JLabel();
        testLabel.setText("   ");

        panel.add(testLabel);


        return panel;
    }
    //Setting up the center section
    private JPanel setCenter(){
        centerSector centerSector = new centerSector();
        return centerSector.getCenterSector();
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
        JButton testBut = new JButton();
        Eventlisteners event = new Eventlisteners();
        testBut.addActionListener(event);
        testBut.setText("test button");
        panel.add(testBut);

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
