package netflixApp.GUI.GUIelements.centerSector;

import netflixApp.Database.dataBaseData;
import netflixApp.GUI.EventListerners.Eventlisteners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class removeAccount implements allPagesInterface {
    private String explainText;
    private int explainTxtHeight;
    private String dataText;
    private int dataTxtHeight;
    private int width;

    private Container container;

    public removeAccount() {
        this.explainText = "asdafafsa";
        this.dataText = "asfasf";
        this.explainTxtHeight = 190;
        this.dataTxtHeight = 190;
        this.width = Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    @Override
    public JPanel getCenterSector() {
        JPanel panel = new JPanel();


        panel.add(getInfoText());

        JPanel panel1 = new JPanel();
        GridLayout grid = new GridLayout(2,1,10,10);
        panel1.setLayout(grid);

        panel1.add(getCombuButs());
        panel1.add(getChooseBut());

        panel.add(panel1);
        return panel;
    }

    @Override
    public void setUpExplainText(String text, int height) {
        this.explainText = text;
        this.explainTxtHeight = height;
    }

    @Override
    public void setUpdataShowText(ArrayList listWithData, int height) {
        this.dataTxtHeight = height;
    }

    @Override
    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public JPanel getInfoText() {
        JPanel panel = new JPanel();
        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5); //Wrapper for text HTML style

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(width / 1.5),this.explainTxtHeight));
        text.setText(this.explainText);
        text.setEditable(false);
        panel.add(text);

        // panel.add(createTable(new JPanel()));
        return panel;
    }

    //-------------------------------------------------------------------------------
    private Object holdLastClicked;

    private JComboBox getCombuButs(){
        JComboBox comboBox = new JComboBox();
        comboBox.setPreferredSize(new Dimension((int)(width / 3.5),50));
        comboBox.addItem("Choose an id");
        dataBaseData data = new dataBaseData();
        for (Object allId : data.getAllIds()) {
            comboBox.addItem(allId);
        }


        comboBox.addItemListener(e -> {
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    holdLastClicked = item;
                }else{
                    holdLastClicked = item;
            }
        });


        return comboBox;
    }

    private JButton getChooseBut(){
        JButton but = new JButton();
        dataBaseData d = new dataBaseData();
        but.setPreferredSize(new Dimension((int)(width / 3.5),50));

        but.setText("Choose this id to be removed!");
        but.addActionListener(e -> d.removeIdFromDB(Float.parseFloat(String.valueOf(holdLastClicked))));
        return but;
    }
}
