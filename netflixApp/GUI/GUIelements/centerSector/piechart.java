package netflixApp.GUI.GUIelements.centerSector;

import netflixApp.GUI.EventListerners.Eventlisteners;
import netflixApp.GUI.GUIelements.centerSector.centerUtils.createPieChart;
import netflixApp.GUI.GUIelements.textAttributes;
import netflixApp.GUI.Interface;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class piechart implements allPagesInterface {
    private String explainText;
    private String dataText;
    private int explainHeight;
    private int dataHeight;

    private ArrayList<Integer> pieValues;
    private Map<Integer, Color> colourAndPos;
    private int width = new Interface().getX();
    private ArrayList<String> groupNames;

    private Container container;

    public piechart() {
        this.explainHeight = 190;
        this.explainText = "blank page";
        colourAndPos = new HashMap<>();
        container = null;
    }

    //Generated the piechart Jpanel
    @Override
    public JPanel getCenterSector() {
        JPanel panel = new JPanel();
        panel.add(getInfoText());
        panel.add(createLegend());
        panel.add(comboBoxPie());

        return panel;
    }

    //Sets up text for piechart (explaintext)
    @Override
    public void setUpExplainText(String text, int height) {
        this.explainHeight = height;
        this.explainText = text;
    }

    //Sets up text for piechart (data)
    @Override
    public void setUpdataShowText(ArrayList listWithData, int height) {
        this.dataHeight = height;
    }

    @Override
    public void setContainer(Container container) {
        this.container = container;
    }

    private Object holdLastClicked;
    private Eventlisteners events;
    private JComboBox comboBoxPie(){
      JComboBox comboBox = new JComboBox();
      events = new Eventlisteners();
      comboBox.setPreferredSize(new Dimension((int)(width / 1.5),50));

      comboBox.addItemListener(e -> {
              Object item = e.getItem();
              if (!item.equals(holdLastClicked)) {
                  holdLastClicked = item;
                  events.actionJcomboboxPIE(e, container);
              }else{
                  holdLastClicked = item;
              }
      });

      comboBox.addItem("Choose an option");
      comboBox.addItem("show series");
      comboBox.addItem("show age distribution");
      comboBox.addItem("show series that are similar");
      comboBox.addItem("show genre distribution");
      comboBox.addItem("show different letters in series");

      return comboBox;
    }

    //Creating textfield to explain content on page
    public JPanel getInfoText(){
        JPanel panel = new JPanel();
        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5); //Wrapper for text HTML style

        textAttributes attrs = new textAttributes(text);
        text = attrs.alignToCenterTextPane();

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(width / 1.5),this.explainHeight));
        text.setText(this.explainText);
        text.setEditable(false);
        panel.add(text);

        // panel.add(createTable(new JPanel()));
        return panel;
    }

    //Creates the legend of the pie chart and the pie chart it self
    private JPanel createLegend(){
        JPanel panel = new JPanel();
        createPieChart pie = new createPieChart(this.pieValues, this.colourAndPos);
        GridLayout grid = new GridLayout(1,2);
        panel.setLayout(grid);
        panel.setPreferredSize(new Dimension((width / 3), 200));

        JPanel legend = new JPanel();
        GridLayout gridL = new GridLayout(10,1);
        legend.setLayout(gridL);

        if (this.pieValues != null) {
            DecimalFormat nf = new DecimalFormat("##.#"); //Formatting the percentage so it will only show 1 decimal digit

            float sumOfAllVals = 0;
            for (Integer value : this.pieValues) {
                sumOfAllVals += value;
            }

            for (int i = 0; i < this.pieValues.size(); i++) {
                JTextPane newLb = new JTextPane();
                newLb.setBackground(colourAndPos.get(i));
                newLb.setText(this.groupNames.get(i) + ":  " + this.pieValues.get(i) + ", perc: " + nf.format(((float)this.pieValues.get(i) / sumOfAllVals) * 100) + " %");

                addLegendAttributes(newLb);
                legend.add(newLb);
            }
        }else{
            System.out.println("empty array");
        }
        panel.add(legend);
        panel.add(pie);

        return panel;
    }

    //Adding attributes to the legend sector
    private JTextPane addLegendAttributes(JTextPane txt){
        txt.setFont(new Font("Arial", Font.BOLD, 15));
        txt.setEditable(false);
        return txt;
    }

    //Sets the piechart values (currently it's random but this can be changed to a normal array)
    public void setPieValues(ArrayList<Integer> pieValues) {
        this.pieValues = new ArrayList<>();
        int pos = 0;

        if (pieValues != null) {
            for (int i = 0; i < pieValues.size(); i++) {
                this.pieValues.add(pieValues.get(i));
                colourAndPos.put(pos, getColour(pos));
                pos++;
            }
        }
    }

    public void setGroupNames(ArrayList<String> groupNames) {
        this.groupNames = groupNames;
    }

    //Generating a new colour for each chart 10 possibilities
    private Color getColour(int pos){
        Color colour = null;
        switch (pos){
            case 0: colour = new Color(109, 255, 243); break;
            case 1: colour = new Color(220, 147, 141); break;
            case 2: colour = new Color(243, 168, 255); break;
            case 3: colour = Color.GREEN; break;
            case 4: colour = new Color(165, 171, 255); break;
            case 5: colour = new Color(255, 239, 117); break;
            case 6: colour = Color.MAGENTA; break;
            case 7: colour = Color.YELLOW; break;
            case 8: colour = Color.CYAN; break;
            case 9: colour = new Color(192,192,192); break;
        }

        if (pos >= 10){
            colour = new Color((int) (Math.random() * 255) + 1,(int) (Math.random() * 255) + 1,(int) (Math.random() * 255) + 1);
        }

        return colour;
    }
}

