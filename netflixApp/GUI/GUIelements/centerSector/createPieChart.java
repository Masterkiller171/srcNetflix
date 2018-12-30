package netflixApp.GUI.GUIelements.centerSector;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Map;

public class createPieChart extends JPanel{
    //Getting all the values from the piechart class
    private ArrayList<Integer> pieVals;
    private Map<Integer,Color> colours;

    public createPieChart(ArrayList<Integer> pieVals, Map<Integer, Color> colours) {
        this.pieVals = pieVals;
        this.colours = colours;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //Creating the circle for the pie chart
        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);

        //Getting the screen size to align the piechart
        final int frameW = Toolkit.getDefaultToolkit().getScreenSize().width;
        arc.setFrame((int) (frameW / 30), 0, 180, 180);

        //The sum of all piechart values
        double sumOfPieVals = 0;

        if (pieVals != null) {
            for (Integer pieVal : pieVals) {
                sumOfPieVals += pieVal;
            }

            double holdStartAngle = 0;

            //Constructing the pie chart
            for (int i = 0; i < colours.size(); i++) {
                double calculate = (pieVals.get(i) / sumOfPieVals) * 360; //Calculating the thickness of the chart
                arc.setAngleStart(holdStartAngle); //The starting position of a chart
                arc.setAngleExtent(calculate);  //The end of an chart

                g2.draw(arc);   //Drawing the outlines of the chart

                g2.setColor(colours.get(i)); //Setting the random generated colour of the chart
                g2.fill(arc);   //Filling the chart with the random colour

                holdStartAngle += calculate;    //Repositioning the starters degrees of the next chart
            }
        }
    }
}
