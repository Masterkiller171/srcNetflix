package netflixApp.GUI.GUIelements.centerSector;

import netflixApp.GUI.EventListerners.Eventlisteners;
import netflixApp.GUI.GUIelements.textAttributes;
import netflixApp.GUI.Interface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class mainPage implements allPagesInterface{
    private Interface getWidth = new Interface();
    private String explainTxt;
    private ArrayList dataTxt;
    private int height;
    private int dataHeight;
    private Container cont;

    //Setting up the default settings for the text of the page
    public mainPage() {
        this.explainTxt = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed suscipit consectetur massa, sed congue nibh. In maximus orci ut mollis semper. Vestibulum quis mi tempor, blandit mauris a, sodales nisi.";
        this.height = 190;
        cont  = null;
        dataTxt = new ArrayList();
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
    public void setUpdataShowText(ArrayList listWithData, int height){
        this.dataTxt = listWithData;
        this.dataHeight = height;
    }

    @Override
    public void setContainer(Container container) {
        this.cont = container;
    }

    //Creating textfield to explain content on page
    @Override
      public JPanel getInfoText(){
        JPanel panel = new JPanel();

        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5);

        textAttributes attrs = new textAttributes(text);
        text = attrs.alignToCenterTextPane();

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(getWidth.getX() / 1.5),this.height));
        text.setText(this.explainTxt);
        text.setEditable(false);
        panel.add(text);

       // panel.add(createTable(new JPanel()));
        return panel;
    }


    //The tab for displaying the queried data from database
    private JPanel getDataText(){
        JPanel panel = new JPanel();
        GridLayout table;

        if (this.dataTxt != null) {
           table = new GridLayout(this.dataTxt.size(), 1);
        }else{
            table = new GridLayout(0, 1);
        }

        panel.setLayout(table);
        panel = createTable(panel);
        return panel;
    }

    //Create a table to show data base data in
    private JPanel createTable(JPanel panel){
        if (this.dataTxt != null) {
            for (int i = 0; i < this.dataTxt.size(); i++) {
                panel.add(createTableRow(new JTextPane(), i));
            }
        }
        return panel;
    }

    //Adds attributes to each JTextpane object based on it's row index
    private JTextPane createTableRow(JTextPane txt, int row){
        txt.setPreferredSize(new Dimension((int)(getWidth.getX() / 1.5),this.dataHeight / 10));
        txt.setText(this.dataTxt.get(row) + "");
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


        comboBox.addItemListener(e -> {
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    events.actionJComboxMain(e,cont);
                    holdLastClicked = item;
                }else{
                    holdLastClicked = item;
            }
        });

        comboBox.addItem("Choose an option");
        comboBox.addItem("show all different series");
        comboBox.addItem("show top 15 distinct titles of episodes");
        comboBox.addItem("show all languages");
        comboBox.addItem("show all genres");
        comboBox.addItem("show all ids who saw the sherlock serie");
        comboBox.addItem("show all ids who saw the breaking bad serie");
        comboBox.addItem("show all ids who saw the fargo serie");

        return comboBox;
    }
}
