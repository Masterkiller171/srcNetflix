package netflixApp.GUI.GUIelements.centerSector;

import netflixApp.GUI.Interface;

import javax.swing.*;
import java.awt.*;
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

    public piechart() {
        this.explainHeight = 190;
        this.explainText = "blank page";
        pieValues = new ArrayList<>();
        colourAndPos = new HashMap<>();
        setPieValues();
    }

    //Generated the piechart Jpanel
    @Override
    public JPanel getCenterSector() {
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(3,1);
        panel.setLayout(grid);

        panel.add(getInfoText());
        panel.add(createLegend());

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

    }

    //Creating textfield to explain content on page
    public JPanel getInfoText(){
        JPanel panel = new JPanel();
        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5); //Wrapper for text HTML style

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(width / 1.5),this.explainHeight));
        text.setText(this.explainText);
        text.setEditable(false);
        panel.add(text);

        // panel.add(createTable(new JPanel()));
        return panel;
    }

    private JPanel createLegend(){
        JPanel panel = new JPanel();
        createPieChart pie = new createPieChart();
        GridLayout grid = new GridLayout(1,2);
        panel.setLayout(grid);

        JPanel legend = new JPanel();
        GridLayout gridL = new GridLayout(10,6);
        legend.setLayout(gridL);

        for (int i = 0; i < this.pieValues.size(); i++) {
            for (int j = 0; j < 5; j++) {
                legend.add(new JLabel());
            }

                JTextPane newLb = new JTextPane();
                newLb.setEditable(false);
                newLb.setBackground(colourAndPos.get(i));
                newLb.setText(i + 1 + ".  " + this.pieValues.get(i));
                legend.add(newLb);
        }

        panel.add(legend);
        panel.add(pie);

        return panel;
    }

    //Sets the piechart values (currently it's random but this can be changed to a normal array)
   public void setPieValues(/*ArrayList<Integer> pieValues*/) {
        int pos = 0;
        for (int i = 0; i < 100; i++) {
            this.pieValues.add((i + 1) * 22);
            colourAndPos.put(pos, getColour(pos));
            pos++;
        }
    }

    //Generating a new colour for each chart 10 possibilities
    private Color getColour(int pos){
        Color colour = null;
        switch (pos){
            case 0: colour = Color.blue; break;
            case 1: colour = Color.red; break;
            case 2: colour = new Color(128,0,128); break;
            case 3: colour = Color.GREEN; break;
            case 4: colour = Color.PINK; break;
            case 5: colour = Color.BLACK; break;
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

    Map<Integer, Color> getColourAndPos() {
        return this.colourAndPos;
    }

    //Getter for the createpiechart class
    ArrayList<Integer> getPieValues(){
        return this.pieValues;
    }

}

