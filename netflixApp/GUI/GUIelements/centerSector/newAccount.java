package netflixApp.GUI.GUIelements.centerSector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class newAccount implements allPagesInterface{
    private String ExplainTxt;
    private int explainHeight;
    private int sWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

    public newAccount() {
        this.explainHeight = 60;
        this.ExplainTxt = "test";
    }


    @Override
    public JPanel getCenterSector() {
        JPanel panel = new JPanel();

        panel.add(getInfoText());

        GridLayout grid = new GridLayout(10,1,5,5);
        JPanel panol = new JPanel();
        panol.setLayout(grid);

        for (int i = 0; i < 10; i++) {
            panol.add(getForm(new JPanel(), "Test " + (i + 1)));
        }


        panel.add(panol);
        return panel;
    }

    @Override
    public void setUpExplainText(String text, int height) {
        this.ExplainTxt = text;
        this.explainHeight = height;
    }

    @Override
    public void setUpdataShowText(ArrayList listWithData, int height) {

    }

    @Override
    public void setContainer(Container container) {

    }

    public JPanel getInfoText(){
        JPanel panel = new JPanel();

        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5);

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(sWidth / 1.5),this.explainHeight));
        text.setText(this.ExplainTxt);
        text.setEditable(false);
        panel.add(text);

        // panel.add(createTable(new JPanel()));
        return panel;
    }

    private JPanel getForm(JPanel panol, String labelNam){
            JLabel label = new JLabel(labelNam);
            panol.add(label);

            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(sWidth / 3, 30));
            panol.add(textField);

        return panol;
    }

}
