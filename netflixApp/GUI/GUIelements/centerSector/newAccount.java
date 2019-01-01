package netflixApp.GUI.GUIelements.centerSector;

import netflixApp.GUI.EventListerners.Eventlisteners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class newAccount implements allPagesInterface{
    private String ExplainTxt;
    private int explainHeight;
    private int sWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private Container cont;

    public newAccount() {
        this.explainHeight = 60;
        this.ExplainTxt = "test";
    }


    @Override
    public JPanel getCenterSector() {
        JPanel panel = new JPanel();

        panel.add(getInfoText());
        panel.add(getForm(new JPanel()));

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
        this.cont = container;
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

    //--------------------------------------------------------------------
    private Object holdLastClicked;
    private Eventlisteners events;
    private JPanel getForm(JPanel panol){
        GridLayout grid = new GridLayout(10,1,5,5);
        panol.setLayout(grid);
            events = new Eventlisteners();
            panol.add(getAgeBox());
            panol.add(getLangBox());
            panol.add(getGenreBox());

            JButton finished = new JButton("finished!");
            finished.addActionListener(events);
            finished.setPreferredSize(new Dimension((int)(sWidth / 3.5), 30));


            panol.add(finished);
        return panol;
    }

    //--------------------------------------
    private JComboBox getAgeBox(){
        JComboBox choiceBoxAge = new JComboBox();
        choiceBoxAge.setPreferredSize(new Dimension((int)(sWidth / 3.5), 30));

        choiceBoxAge.addItem("What is your age?");

        for (int i = 6; i < 18; i++) {
            choiceBoxAge.addItem(i + " year");
        }

        choiceBoxAge.addItem("18 years or older");

        choiceBoxAge.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    holdLastClicked = item;
                    events.actionJcomboboxACCAge(e, cont);
                }else{
                    holdLastClicked = item;
                }
            }
        });
        return choiceBoxAge;
    }

    //--------------------------------------
    private JComboBox getLangBox(){
        JComboBox choiceBoxLang = new JComboBox();
        choiceBoxLang.setPreferredSize(new Dimension((int)(sWidth / 3.5), 30));

        choiceBoxLang.addItem("What is your preferred language?");
        choiceBoxLang.addItem("Mandarin");
        choiceBoxLang.addItem("Spanish");
        choiceBoxLang.addItem("English");
        choiceBoxLang.addItem("Dutch");
        choiceBoxLang.addItem("French");
        choiceBoxLang.addItem("German");


        choiceBoxLang.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    holdLastClicked = item;
                    events.actionJcomboboxACCLang(e, cont);
                }else{
                    holdLastClicked = item;
                }
            }
        });
        return choiceBoxLang;
    }

    //--------------------------------------
    private JComboBox getGenreBox(){
        JComboBox choiceGenreLang = new JComboBox();
        choiceGenreLang.setPreferredSize(new Dimension((int)(sWidth / 3.5), 30));

        choiceGenreLang.addItem("What is your favourite genre?");
        choiceGenreLang.addItem("Spanning");
        choiceGenreLang.addItem("Detective");
        choiceGenreLang.addItem("Sci-fi");
        choiceGenreLang.addItem("Fantasy");
        choiceGenreLang.addItem("War");
        choiceGenreLang.addItem("Drama");


        choiceGenreLang.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    holdLastClicked = item;
                    events.actionJcomboboxACCGenre(e, cont);
                }else{
                    holdLastClicked = item;
                }
            }
        });
        return choiceGenreLang;
    }

}
