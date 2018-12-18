package netflixApp.GUI.GUIelements.centerSector;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

public class createPieChart extends JPanel{
        //Getting all the values from the piechart class
        private ArrayList<Integer> pieVals = new piechart().getPieValues();

        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;

            //Creating the circle for the pie chart
            Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);

            //Getting the screen size to align the piechart
            int frameW = Toolkit.getDefaultToolkit().getScreenSize().width;
            arc.setFrame((int)(frameW / 2.7),0,250,250);

            //The sum of all piechart values
            double sumOfPieVals = 0;
            for (Integer pieVal : pieVals) {
                sumOfPieVals += pieVal;
            }

            double holdStartAngle = 0;

            //Constructing the pie chart
            for (int i = 0; i < pieVals.size(); i++) {
                double calculate = pieVals.get(i) / sumOfPieVals * 360; //Calculating the thickness of the chart
                    arc.setAngleStart(holdStartAngle); //The starting position of a chart
                    arc.setAngleExtent(calculate);  //The end of an chart
                    g2.setColor(Color.gray);    //The lines between 2 charts
                    g2.draw(arc);   //Drawing the outlines of the chart
                    g2.setColor(getRandomColour()); //Setting the random generated colour of the chart
                    g2.fill(arc);   //Filling the chart with the random colour
                    holdStartAngle += calculate;    //Repositioning the starters degrees of the next chart
            }

        }

        //Generating a new colour for each chart (16.7 million possibilities)
        private Color getRandomColour(){
            return new Color((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255));
        }
}
