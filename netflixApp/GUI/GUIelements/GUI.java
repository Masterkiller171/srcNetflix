package netflixApp.GUI.GUIelements;

import netflixApp.GUI.EventListerners.Eventlisteners;
import netflixApp.GUI.GUIelements.centerSector.mainPage;
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
    private int layoutType;

    public GUI(Container container, int layoutType) {
        this.container = container;
        this.layoutType = layoutType;
    }

    //Constructing the layout of the whole visible part of the application
    private Container createLayout(int layoutType){
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

        container.add(setNorth(), BorderLayout.NORTH); //Top sector
        container.add(setWest(), BorderLayout.WEST); //Left sector
        container.add(setCenter(layoutType), BorderLayout.CENTER); //Center sector
        container.add(setSouth(), BorderLayout.SOUTH); //Bottom sector

        return container;
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

        //Main panel for all controls
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));

        panel.setBackground(Color.lightGray);

        //Grid layout so the buttons aligns vertically
        GridLayout grid = new GridLayout(10,1,5,10);
        panel.setLayout(grid);

        //First dummy button to reset the page
        JButton clearPage = new JButton("reset page");
        Eventlisteners e = new Eventlisteners(this.container);
        clearPage.addActionListener(e);
        panel.add(addAttributes(clearPage));

        //Second dummy button which returns the default center layout
        JButton returnPage = new JButton("return page");
        Eventlisteners event = new Eventlisteners(this.container);
        returnPage.addActionListener(event);
        panel.add(addAttributes(returnPage));

        for (int i = 0; i < 8; i++) {
            panel.add(addAttributes(new JButton(randomWordGen(10))));
        }
        wrapper.add(panel);

        return wrapper;
    }

    //Generates a random sequence of characters each time the method gets called and the parameter is the amount of characters
    //Only for testing purposes
    private String randomWordGen(int characters){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomWord = new StringBuilder();

        for (int i = 0; i < characters; i++) {
            randomWord.append(alpha.charAt((int) (Math.random() * 25) + 1));
        }
        return randomWord.toString();
    }

    //All the attributes for the west sector button controls
    private JButton addAttributes(JButton button){
        button.setPreferredSize(new Dimension(200,50));
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(Color.WHITE);
        return button;
    }

    //Setting up the center section
    private JPanel setCenter(int idPage){
        mainPage page = new mainPage();
        JPanel middlePanel = null;

        //Choosing the layout for the center borderLayout which is based on the parameter input
        switch (idPage){
            case 1:
            page.setUpExplainText("Here comes the information regarding the data shown below",190);
            page.setUpdataShowText("Here comes the sql data", 190);
            middlePanel = page.getCenterSector();
            middlePanel.setVisible(true);
            break;

            case 2:
            middlePanel = page.getCenterSector();
            middlePanel.removeAll();
            break;
        }
        return middlePanel;
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

    //Aligns the object JtextPane to the center of the X-Axis of the frame
    private JTextPane alignToCenter(JTextPane pane){
        StyledDocument doc = pane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        return pane;
    }

    public int getLayoutType() {
        return layoutType;
    }

    //Returning the constructed layout to the interface class
    public Container getUi() {
        return createLayout(layoutType);
    }

}
