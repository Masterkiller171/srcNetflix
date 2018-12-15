package netflixApp.GUI.GUIelements;

import netflixApp.GUI.GUIelements.sectors.centerSector;
import netflixApp.GUI.Interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
        textPane.setPreferredSize(new Dimension(width.getX() - 40,80));
        textPane.setEditable(false);

        //Aligning text to middle of pane
        alignToCenter(textPane);
        textPane.setMargin(new Insets(20,0,0,0));

        textPane.setText("Netflix Statistics");
        textPane.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));

        panel.add(textPane);

        return panel;
    }

    //Setting up the west section
    private JPanel setWest(){
        //The wrapper wraps around the panel so that it will have some distance between the frame border and the panels border
        JPanel wrapper = new JPanel();
        wrapper.setBorder(new EmptyBorder(5,5,5,5));

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));

        panel.setBackground(Color.lightGray);

        GridLayout grid = new GridLayout(10,1,5,10);
        panel.setLayout(grid);


        for (int i = 1; i <= 10; i++) {
            panel.add(addAttributes(new JButton(randomWordGen(10))));
        }
        wrapper.add(panel);

        return wrapper;
    }

    //Generates a random sequence of characters each time the method gets called and the parameter is the amount of characters
    //Only for testing purposes
    private String randomWordGen(int characters){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String randomWord= "";
        for (int i = 0; i < characters; i++) {
            randomWord += alpha.charAt((int) (Math.random() * 25) + 1);
        }
        return randomWord;
    }

    //All the attributes for the west sector button controls
    private JButton addAttributes(JButton button){
        button.setPreferredSize(new Dimension(200,50));
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(Color.WHITE);
        return button;
    }

    //Setting up the center section
    private JPanel setCenter(){
        centerSector centerSector = new centerSector();
        return centerSector.getCenterSector();
    }

    //Setting up the south section (footer)
    private JPanel setSouth(){
        JPanel wrapper = new JPanel();
        //The wrapper wraps around the panel so that it will have some distance between the frame border and the panels border
        wrapper.setBorder(new EmptyBorder(5,5,5,5));

        JPanel panel = new JPanel();
        JTextPane txtPane = new JTextPane();

        //Aligning text to center
        alignToCenter(txtPane);

        txtPane.setBackground(Color.lightGray);
        txtPane.setEditable(false);
        txtPane.setPreferredSize(new Dimension(width.getX() - 40,100));

        //Setting up font type and size
        txtPane.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        txtPane.setText("\nGemaakt door: Youri Bontekoe en Winson Ngoh");

        panel.add(txtPane);

        return panel;
    }

    private JTextPane alignToCenter(JTextPane pane){
        StyledDocument doc = pane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        return pane;
    }

    //Returning the constructed layout to the interface class
    public Container getUi() {
        createLayout();

        return container;
    }

}
