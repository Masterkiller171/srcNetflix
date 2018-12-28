package netflixApp.GUI.GUIelements.centerSector;

import netflixApp.GUI.EventListerners.Eventlisteners;
import netflixApp.GUI.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class mainPage implements allPagesInterface{
    private Interface getWidth = new Interface();
    private String explainTxt;
    private String dataTxt;
    private int height;
    private int dataHeight;

    //Setting up the default settings for the text of the page
    public mainPage() {
        this.explainTxt = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed suscipit consectetur massa, sed congue nibh. In maximus orci ut mollis semper. Vestibulum quis mi tempor, blandit mauris a, sodales nisi.";
        this.height = 190;
    }

    //Constructing the whole center section into a Jpanel
    @Override
    public JPanel getCenterSector(){
        JPanel panelCent = new JPanel();

        panelCent.add(getInfoText());
        panelCent.add(getDataText());

        GridLayout grid = new GridLayout(15,1,5,5);
        JPanel panol = new JPanel();
        panol.setLayout(grid);

        panol.add(getCombuButs());

        panelCent.add(panol);

        return panelCent;
    }

    //Setting up all the text attributes
    @Override
    public void setUpExplainText(String text, int height){
        this.explainTxt = text;
        this.height = height;
    }

    //Setting up all the data show text
    @Override
    public void setUpdataShowText(String data, int height){
        this.dataTxt = data;
        this.dataHeight = height;
    }

    //Creating textfield to explain content on page
      public JPanel getInfoText(){
        JPanel panel = new JPanel();

        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5);

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(getWidth.getX() / 1.5),this.height));
        text.setText(this.explainTxt);
        text.setEditable(false);
        panel.add(text);

       // panel.add(createTable(new JPanel()));
        return panel;
    }

    private int rows = 15;
    //The tab for displaying the queried data from database
    private JPanel getDataText(){
        JPanel panel = new JPanel();
        GridLayout table = new GridLayout(this.rows,1);
        panel.setLayout(table);
        panel = createTable(panel);
        return panel;
    }

    //Create a table to show data base data in
    private JPanel createTable(JPanel panel){
        for (int i = 0; i < this.rows; i++) {
            panel.add(createTableRow(new JTextPane(), i));
        }
        return panel;
    }

    //Adds attributes to each JTextpane object based on it's row index
    private JTextPane createTableRow(JTextPane txt, int row){
        txt.setPreferredSize(new Dimension((int)(getWidth.getX() / 1.5),this.dataHeight / 10));
        txt.setText(this.dataTxt);
        txt.setEditable(false);

        if (row % 2 == 1){
            txt.setBackground(Color.white);
        }else{
            txt.setBackground(Color.lightGray);
        }
        return txt;
    }

    private Object holdLastClicked;
    private Eventlisteners events;

    //Setting up the combobox buttons
    private JComboBox getCombuButs(){
        JComboBox comboBox = new JComboBox();
        events = new Eventlisteners();
        comboBox.setPreferredSize(new Dimension((int)(getWidth.getX() / 1.5),50));


        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    events.actionJComboxMain(e);
                    holdLastClicked = item;
                }else{
                    holdLastClicked = item;
                }
            }
        });

        comboBox.addItem("Choose an option");
        comboBox.addItem("test1");

        return comboBox;
    }
}
