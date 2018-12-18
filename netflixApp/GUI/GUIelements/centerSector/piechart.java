package netflixApp.GUI.GUIelements.centerSector;

import javafx.scene.chart.PieChart;
import netflixApp.GUI.Interface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class piechart implements allPagesInterface {
    private String explainText;
    private String dataText;
    private int explainHeight;
    private int dataHeight;

    private ArrayList<Integer> pieValues;

    private int width = new Interface().getX();
    public piechart() {
        this.explainHeight = 190;
        this.explainText = "blank page";
        pieValues = new ArrayList<>();
        setPieValues();
    }

    //Generated the piechart Jpanel
    @Override
    public JPanel getCenterSector() {
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(3,1);
        panel.setLayout(grid);

        createPieChart pieChart = new createPieChart();
        panel.add(getInfoText());
        panel.add(pieChart);
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
    public void setUpdataShowText(String data, int height) {
        this.dataText = data;
        this.dataHeight = height;
    }

    //Creating textfield to explain content on page
    private JPanel getInfoText(){
        JPanel panel = new JPanel();
        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5);

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(width / 1.5),this.explainHeight));
        text.setText(this.explainText);
        text.setEditable(false);
        panel.add(text);

        // panel.add(createTable(new JPanel()));
        return panel;
    }

    //Sets the piechart values (currently it's random but this can be changed to a normal array)
    public void setPieValues(/*ArrayList<Integer> pieValues*/) {
        for (int i = 0; i < 20; i++) {
            this.pieValues.add((int)(Math.random() * 1000) + 1);
        }
    }

    //Getter for the createpiechart class
    public ArrayList<Integer> getPieValues(){
        return this.pieValues;
    }
}

