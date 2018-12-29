package netflixApp.GUI.GUIelements.centerSector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class removeAccount implements allPagesInterface {
    private String explainText;
    private int explainTxtHeight;
    private String dataText;
    private int dataTxtHeight;
    private int width;

    public removeAccount() {
        this.explainText = "asdafafsa";
        this.dataText = "asfasf";
        this.explainTxtHeight = 190;
        this.dataTxtHeight = 190;
        this.width = Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    @Override
    public JPanel getCenterSector() {
        JPanel panel = new JPanel();

        panel.add(getInfoText());
        panel.add(getCombuButs());

        return panel;
    }

    @Override
    public void setUpExplainText(String text, int height) {
        this.explainText = text;
        this.explainTxtHeight = height;
    }

    @Override
    public void setUpdataShowText(ArrayList listWithData, int height) {
        this.dataTxtHeight = height;
    }

    @Override
    public void setContainer(Container container) {

    }

    @Override
    public JPanel getInfoText() {
        JPanel panel = new JPanel();
        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5); //Wrapper for text HTML style

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(width / 1.5),this.explainTxtHeight));
        text.setText(this.explainText);
        text.setEditable(false);
        panel.add(text);

        // panel.add(createTable(new JPanel()));
        return panel;
    }

    private JComboBox getCombuButs(){
        JComboBox comboBox = new JComboBox();
        comboBox.setPreferredSize(new Dimension((int)(width / 1.5),50));

        for (int i = 1; i <= 10; i++) {
            comboBox.addItem("test " + i);
        }
        return comboBox;
    }
}
