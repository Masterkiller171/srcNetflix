package netflixApp.GUI.GUIelements;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private Container container;
    private BorderLayout layout;

    public GUI(Container container) {
        this.container = container;
    }

    private void createLayout(){
        layout = new BorderLayout();
        container.setLayout(layout);

        container.add(setSouth(), BorderLayout.SOUTH);
    }
    private JPanel setSouth(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(4,8);
        panel.setLayout(grid);

        panel.add(new JButton("test"));

        return panel;
    }

    public Container getUi() {
        createLayout();

        return container;
    }
}
