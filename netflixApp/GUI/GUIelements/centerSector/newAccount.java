package netflixApp.GUI.GUIelements.centerSector;

import netflixApp.Database.dataBaseData;
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

    //Builds the center sector for this class and returns the JPanel which contains every component in this class
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
        //No data
    }

    @Override
    public void setContainer(Container container) {
        this.cont = container;
    }

    //Creates the the info text box which shows some data related to the shown data
    @Override
    public JPanel getInfoText(){
        JPanel panel = new JPanel();

        JTextPane text = new JTextPane();
        text.setBackground(Color.lightGray);
        Insets insets = new Insets(5,20,5,5);

        text.setMargin(insets);
        text.setPreferredSize(new Dimension((int)(sWidth / 1.5), this.explainHeight));
        text.setText(this.ExplainTxt);
        text.setEditable(false);
        panel.add(text);

        // panel.add(createTable(new JPanel()));
        return panel;
    }

    //--------------------------------------------------------------------
    //The getform is the method which constructs all of the JComboBox elements into a JPanel
    private Object holdLastClicked;
    private Eventlisteners events;
    private JPanel getForm(JPanel panol){
        GridLayout grid = new GridLayout(10,1,5,5);
        panol.setLayout(grid);
            events = new Eventlisteners();
            panol.add(getAgeBox());
            panol.add(getLangBox());
            panol.add(getGenreBox());
            panol.add(new JPanel());

            panol.add(getSerie());
            panol.add(getSeason());

            JLabel randoMessage = new JLabel();
            randoMessage.setText("'aflevering' And the title will be randomly choosen based on the chosen options");
            randoMessage.setHorizontalAlignment(SwingConstants.CENTER);
            randoMessage.setForeground(Color.red);
            panol.add(randoMessage);

            JButton finished = new JButton("finished!");
            finished.addActionListener(events);
            finished.setPreferredSize(new Dimension((int)(sWidth / 3.5), 30));

            panol.add(finished);
        return panol;
    }

    //--------------------------------------
    //Sets up the age Combo box
    private JComboBox getAgeBox(){
        JComboBox choiceBoxAge = new JComboBox();
        choiceBoxAge = getSizedCombobox(choiceBoxAge);

        choiceBoxAge.addItem("What is your age?");

        for (int i = 6; i < 18; i++) {
            choiceBoxAge.addItem(i + " year");
        }

        choiceBoxAge.addItem("18 years or older");

        choiceBoxAge.addItemListener(e -> {
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    holdLastClicked = item;
                    events.actionJcomboboxACCAge(e, cont);
                }else{
                    holdLastClicked = item;
                }
        });
        return choiceBoxAge;
    }

    //--------------------------------------
    //Sets up the language Combo box
    private JComboBox getLangBox(){
        JComboBox choiceBoxLang = new JComboBox();
        choiceBoxLang = getSizedCombobox(choiceBoxLang);

        choiceBoxLang.addItem("What is your preferred language?");
        choiceBoxLang.addItem("Mandarin");
        choiceBoxLang.addItem("Spanish");
        choiceBoxLang.addItem("English");
        choiceBoxLang.addItem("Dutch");
        choiceBoxLang.addItem("French");
        choiceBoxLang.addItem("German");


        choiceBoxLang.addItemListener(e ->  {
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    holdLastClicked = item;
                    events.actionJcomboboxACCLang(e, cont);
                }else{
                    holdLastClicked = item;
                }
        });
        return choiceBoxLang;
    }

    //--------------------------------------
    //Sets up the genre Combo box
    private JComboBox getGenreBox(){
        JComboBox choiceGenreLang = new JComboBox();
        choiceGenreLang = getSizedCombobox(choiceGenreLang);

        choiceGenreLang.addItem("What is your favourite genre?");
        choiceGenreLang.addItem("Spanning");
        choiceGenreLang.addItem("Detective");
        choiceGenreLang.addItem("Sci-fi");
        choiceGenreLang.addItem("Fantasy");
        choiceGenreLang.addItem("War");
        choiceGenreLang.addItem("Drama");


        choiceGenreLang.addItemListener(e -> {
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    holdLastClicked = item;
                    events.actionJcomboboxACCGenre(e, cont);
                }else{
                    holdLastClicked = item;
                }
        });
        return choiceGenreLang;
    }

    //-------------------------------------------------
    //Sets up the serie Combo box
    private JComboBox getSerie(){
        JComboBox choiceSerie = new JComboBox();
        choiceSerie = getSizedCombobox(choiceSerie);

        choiceSerie.addItem("What serie are you currently watching?");
        choiceSerie.addItem("Breaking Bad");
        choiceSerie.addItem("Fargo");
        choiceSerie.addItem("Sherlock");

        choiceSerie.addItemListener(e ->  {
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    holdLastClicked = item;
                    events.actionJcomboboxACCSerie(e, cont);
                }else{
                    holdLastClicked = item;
                }
        });

        return choiceSerie;
    }

    //--------------------------------------
    //Sets up the season Combo box
    private JComboBox getSeason(){
        JComboBox choiceSeason = new JComboBox();
        choiceSeason = getSizedCombobox(choiceSeason);

        choiceSeason.addItem("What season of are you currently watching?");

        for (int i = 1; i <= 2; i++) {
            choiceSeason.addItem("Season: " + i);
        }

        choiceSeason.addItem("Season: 3 (only aviable for the Sherlock serie)");

        choiceSeason.addItemListener(e ->{
                Object item = e.getItem();
                if (!item.equals(holdLastClicked)) {
                    holdLastClicked = item;
                    events.actionJcomboboxACCSeason(e, cont);
                }else{
                    holdLastClicked = item;
                }
        });

        return choiceSeason;
    }

    //--------------------------------------
    private JComboBox getSizedCombobox(JComboBox box){
        box.setPreferredSize(new Dimension((int)(sWidth / 3.5), 30));
        return box;
    }
}
