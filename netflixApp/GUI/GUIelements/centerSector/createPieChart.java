package netflixApp.GUI.GUIelements.centerSector;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

public class createPieChart extends JPanel{
        private ArrayList<Integer> pieVals = new piechart().getPieValues();
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;

            Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
            int frameW = Toolkit.getDefaultToolkit().getScreenSize().width;
            arc.setFrame((int)(frameW / 2.7),0,250,250);

            double sumOfPieVals = 0;
            for (Integer pieVal : pieVals) {
                sumOfPieVals += pieVal;
            }

            double holdStartAngle = 0;

            for (int i = 0; i < pieVals.size(); i++) {
                double calculate = pieVals.get(i) / sumOfPieVals * 360;

                    arc.setAngleStart(holdStartAngle);
                    arc.setAngleExtent(calculate);
                    g2.setColor(Color.gray);
                    g2.draw(arc);
                    g2.setColor(getRandomColour());
                    g2.fill(arc);
                    holdStartAngle += calculate;
            }

        }

        private Color getRandomColour(){
            return new Color((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255));
        }
}
