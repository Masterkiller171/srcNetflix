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

    @Override
    public void setUpExplainText(String text, int height) {
        this.explainHeight = height;
        this.explainText = text;
    }

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

    public void setPieValues(/*ArrayList<Integer> pieValues*/) {
        for (int i = 0; i < 20; i++) {
            this.pieValues.add((int)(Math.random() * 1000) + 1);
        }
    }

    public ArrayList<Integer> getPieValues(){
        return this.pieValues;
    }
}

