package netflixApp.GUI.GUIelements.sectors;

import netflixApp.GUI.Interface;

import javax.swing.*;
import java.awt.*;

public class centerSector {
    private Interface getWidth = new Interface();

    public centerSector() {
    }

    public JPanel getCenterSector(){
        JPanel panelCent = new JPanel();
        for (int i = 0; i < 2; i++) {
            panelCent.add(getBigText());
        }

        GridLayout grid = new GridLayout(5,2,5,5);
        JPanel panol = new JPanel();
        panol.setLayout(grid);

        JComboBox comboBox = new JComboBox();
        comboBox.setPreferredSize(new Dimension((int)(getWidth.getX() / 1.5),50));

        for (int i = 1; i <= 10; i++) {
            comboBox.addItem("test " + i);
        }
        panol.add(comboBox);

        panelCent.add(panol);

        return panelCent;
    }

    //Creating textfield to explain content on page
    private JPanel getBigText(){
        JPanel panel = new JPanel();


        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5);

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(getWidth.getX() / 1.5),190));
        text.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce lobortis sit amet libero ac sagittis." +
                " Praesent lobortis dolor risus, at pellentesque ante pharetra eget. Fusce id rutrum metus. Mauris eu nibh lorem. " +
                "Donec faucibus tristique neque ut eleifend. Maecenas placerat eleifend gravida. Nam ac lectus justo. " +
                "Nunc imperdiet velit felis, tempus ultrices sem commodo ut. Donec dui turpis, tincidunt non nisi eget, consectetur facilisis augue. " +
                "Sed pellentesque dictum dui, non aliquet nibh auctor vel. Curabitur finibus leo id metus luctus, at sagittis ante viverra.");

        text.setEditable(false);
        panel.add(text);

        return panel;
    }
}
