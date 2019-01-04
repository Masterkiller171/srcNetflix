package netflixApp.GUI.GUIelements;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class textAttributes {
    private JTextPane pane;
    private JButton buts;

    public textAttributes(JTextPane pane) {
        this.pane = pane;
    }

    public textAttributes(JButton buts) {
        this.buts = buts;
    }

    //Aligns the object JtextPane to the center of the X-Axis of the frame
    public JTextPane alignToCenterTextPane(){
        StyledDocument doc = pane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        return pane;
    }

    //All the attributes for the west sector button controls
    public JButton addAttributesButton(){
        buts.setPreferredSize(new Dimension(200,50));
        buts.setFont(new Font("Arial", Font.BOLD, 15));
        buts.setBackground(Color.WHITE);
        return buts;
    }

    //Sets the current button when a new button needs those spicy attributes
    public void setButs(JButton buts) {
        this.buts = buts;
    }
}
