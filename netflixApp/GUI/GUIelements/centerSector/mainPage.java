package netflixApp.GUI.GUIelements.centerSector;

import netflixApp.GUI.Interface;

import javax.swing.*;
import java.awt.*;

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
    public JPanel getCenterSector(){
        JPanel panelCent = new JPanel();

        panelCent.add(getBigText(this.explainTxt,this.height));
        panelCent.add(getBigText(this.dataTxt,this.dataHeight));

        GridLayout grid = new GridLayout(5,2,5,5);
        JPanel panol = new JPanel();
        panol.setLayout(grid);

        panol.add(getCombuButs());

        panelCent.add(panol);

        return panelCent;
    }

    //Setting up all the text attributes
    public void setUpExplainText(String text, int height){
        this.explainTxt = text;
        this.height = height;
    }

    //Setting up all the data show text
    public void setUpdataShowText(String data, int height){
        this.dataTxt = data;
        this.dataHeight = height;
    }

    //Creating textfield to explain content on page
      private JPanel getBigText(String txt, int height){
        JPanel panel = new JPanel();

        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5);

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(getWidth.getX() / 1.5),height));
        text.setText(txt);
        text.setEditable(false);
        panel.add(text);

        return panel;
    }

    //Setting up the combobox buttons
    private JComboBox getCombuButs(){
        JComboBox comboBox = new JComboBox();
        comboBox.setPreferredSize(new Dimension((int)(getWidth.getX() / 1.5),50));

        for (int i = 1; i <= 10; i++) {
            comboBox.addItem("test " + i);
        }
        return comboBox;
    }
}
