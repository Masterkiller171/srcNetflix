package netflixApp.GUI.GUIelements;

import netflixApp.GUI.EventListerners.Eventlisteners;
import netflixApp.GUI.GUIelements.centerSector.mainPage;
import netflixApp.GUI.GUIelements.centerSector.newAccount;
import netflixApp.GUI.GUIelements.centerSector.piechart;
import netflixApp.GUI.GUIelements.centerSector.removeAccount;
import netflixApp.GUI.Interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.util.ArrayList;

public class GUI {
    private Container container;
    private Interface width = new Interface(); //Getting the width from the interface class to make the app more dynamic
    private Layout layoutType;
    private ArrayList listWithData;
    private ArrayList<Integer> pieValues;
    private ArrayList<String> groupNames;

    public GUI(Container container, Layout layoutType) {
        this.container = container;
        this.layoutType = layoutType;
        listWithData = new ArrayList();
        groupNames = new ArrayList<>();
    }

    //Constructing the layout of the whole visible part of the application
    private Container createLayout(Layout layoutType){
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

        container.add(setNorth(), BorderLayout.NORTH); //Top sector
        container.add(setWest(), BorderLayout.WEST); //Left sector
        container.add(setCenter(layoutType), BorderLayout.CENTER); //Center sector
        container.add(setSouth(), BorderLayout.SOUTH); //Bottom sector

        return container;
    }


    //---------------------------------------------------------------------------------------------
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
        GridLayout grid = new GridLayout(4,1,5,10);
        panel.setLayout(grid);

        //First dummy button which returns the default center layout
        JButton returnPage = new JButton("Home");
        Eventlisteners event = new Eventlisteners(this.container);
        returnPage.addActionListener(event);
        panel.add(addAttributes(returnPage));

        //Second dummy button to reset the page
        JButton clearPage = new JButton("Remove Account");
        Eventlisteners e = new Eventlisteners(this.container);
        clearPage.addActionListener(e);
        panel.add(addAttributes(clearPage));

        //Second dummy button which returns the default center layout
        JButton piePage = new JButton("pie charts");
        Eventlisteners pieEvent = new Eventlisteners(this.container);
        piePage.addActionListener(pieEvent);
        panel.add(addAttributes(piePage));


        //Second dummy button which returns the default center layout
        JButton newAcc = new JButton("create new account");
        Eventlisteners accEvent = new Eventlisteners(this.container);
        newAcc.addActionListener(accEvent);
        panel.add(addAttributes(newAcc));

//        for (int i = 0; i < 6; i++) {
//            panel.add(addAttributes(new JButton(randomWordGen(10))));
//        }

        wrapper.add(panel);

        return wrapper;
    }

    //Generates a random sequence of characters each time the method gets called and the parameter is the amount of characters
    //Only for testing purposes
    private String randomWordGen(int characters){
        String alpha = "abcdefghijklmnopqrstuvwxyz, ";
        StringBuilder randomWord = new StringBuilder();

        for (int i = 0; i < characters; i++) {
            int rando = (int) (Math.random() * 27) + 1;
            if (alpha.charAt(rando) == ','){
                randomWord.append(alpha.charAt(rando) + " ");
            }else{
                randomWord.append(alpha.charAt(rando));
            }
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
    private JPanel setCenter(Layout lay){
        mainPage page = new mainPage();
        JPanel middlePanel = null;

        //Choosing the layout for the center borderLayout which is based on the parameter input
        switch (lay){
            case MAIN:
            page.setUpExplainText("Here comes the information regarding the data shown below\n\n" + randomWordGen(200),190);
            page.setUpdataShowText(this.listWithData, 190);
            page.setContainer(this.container);
            middlePanel = page.getCenterSector();
            middlePanel.setVisible(true);
            break;

            case REMOVEACC:
            removeAccount acc = new removeAccount();
            middlePanel = acc.getCenterSector();
            middlePanel.setVisible(true);
            break;

            case PIECHART:
            piechart piechart = new piechart();
            piechart.setUpExplainText(randomWordGen(200), 190);
            piechart.setContainer(this.container);
            piechart.setPieValues(this.pieValues);
            piechart.setGroupNames(this.groupNames);
            middlePanel = piechart.getCenterSector();
            middlePanel.setVisible(true);
            break;

            case NEWACCOUNT:
                newAccount newacc = new newAccount();
                newacc.setUpExplainText(randomWordGen(300),40);
                middlePanel = newacc.getCenterSector();
                middlePanel.setVisible(true);
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

    //---------------------------------------------------------------------------------------------------------
    //Aligns the object JtextPane to the center of the X-Axis of the frame
    private JTextPane alignToCenter(JTextPane pane){
        StyledDocument doc = pane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        return pane;
    }

    public Layout getLayoutType() {
        return layoutType;
    }

    //Returning the constructed layout to the interface class
    public Container getUi() {
        return createLayout(layoutType);
    }

    //Setting up the list with the database data
    public void setArrayWithData(ArrayList list){
        this.listWithData = list;
    }

    public void setPieValues(ArrayList pieValues) {
        this.pieValues = new ArrayList<>();
        if (pieValues != null) {
            for (Object pieValue : pieValues) {
                this.pieValues.add((int) pieValue);
            }
        }
    }

    public void setGroupNames(ArrayList<String> groupNames) {
        this.groupNames = groupNames;
    }
}
