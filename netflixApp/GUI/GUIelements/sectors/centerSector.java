package netflixApp.GUI.GUIelements.sectors;

import netflixApp.GUI.EventListerners.Eventlisteners;
import netflixApp.GUI.Interface;

import javax.swing.*;
import java.awt.*;

public class centerSector {
    public centerSector() {
    }

    public JPanel getCenterSector(){
        JPanel panel = new JPanel();
        panel.add(getBigText());

        GridLayout grid = new GridLayout(2,2,5,5);
        JPanel panol = new JPanel();

        panel.setLayout(grid);
        JButton testerBut = new JButton();
        testerBut.setText("teset but");

        Eventlisteners event = new Eventlisteners();
        testerBut.addActionListener(event);
        panol.add(testerBut);

        JButton testerBut2 = new JButton();
        testerBut2.setText("testbut 2");
        testerBut2.addActionListener(event);
        panol.add(testerBut2);
        panel.add(panol);

        return panel;
    }

    //Creating textfield to explain content on page
    private JPanel getBigText(){
        JPanel panel = new JPanel();

        Interface getWidth = new Interface();
        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5);

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(getWidth.getX() / 1.5),200));
        text.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce lobortis sit amet libero ac sagittis.\n" +
                " Praesent lobortis dolor risus, at pellentesque ante pharetra eget. Fusce id rutrum metus. Mauris eu nibh lorem. \n" +
                "Donec faucibus tristique neque ut eleifend. Maecenas placerat eleifend gravida. Nam ac lectus justo.\n " +
                "Nunc imperdiet velit felis, tempus ultrices sem commodo ut. Donec dui turpis, tincidunt non nisi eget, consectetur facilisis augue.\n " +
                "Sed pellentesque dictum dui, non aliquet nibh auctor vel. Curabitur finibus leo id metus luctus, at sagittis ante viverra.\n");

        text.setEditable(false);
        panel.add(text);

        return panel;
    }
}
