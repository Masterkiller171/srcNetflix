package netflixApp.GUI.EventListerners;

import netflixApp.Database.dataBaseData;
import netflixApp.GUI.GUIelements.Layout;
import netflixApp.GUI.Interface;
import org.omg.CORBA.INTERNAL;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class Eventlisteners implements ActionListener {
    private Container cont;
    private Interface ui;
    private dataBaseData data;

    //Constructor will receive the container object from the GUI class
    public Eventlisteners(Container cont) {
        this.cont = cont;
    }

    //Overloading the constructor so it doesn't need a parameter each time
    public Eventlisteners() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Checks for button names and assigning them to an action
        //Only for the west sector buttons
        switch (e.getActionCommand()){
            case "Remove Account":
                resetPage();
                break;
            case "Home":
                returnPage();
                break;
            case "pie charts":
                pieCharts();
                break;
            case "create new account":
                newAcc();
                break;
        }
    }

    //This method will show the new account page
    private void newAcc() {
        ui = new Interface();
        ui.setLayoutType(Layout.NEWACCOUNT);
        ui.createElements(cont,null,null);
    }

    //Will choose the layoutType 2 which is currently an empty center canvas
    private void resetPage(){
        ui = new Interface();
        ui.setLayoutType(Layout.REMOVEACC);
        ui.createElements(cont,null,null);
    }

    //Will return the page to layoutType 1 which is the main page
    private void returnPage(){
        ui = new Interface();
        ui.setLayoutType(Layout.MAIN);
        ui.createElements(cont,null,null);
    }

    private void pieCharts(){
        ui = new Interface();
        ui.setLayoutType(Layout.PIECHART);
        ui.createElements(cont,null,null);
    }

    //---------------------------------------------------------------------------------------------------
    //This is the method which controls the combobox on the mainpage
    public void actionJComboxMain(ItemEvent e, Container container){
        data = new dataBaseData();
        this.cont = container;
        switch (String.valueOf(e.getItem())){
            case "show all different series":
                actionCombox(data.getDistinctSeriesTitle());
            break;

            case "show top 15 distinct titles of episodes":
                actionCombox(data.getTop15EpisodesTitle());
            break;

            case "show all languages":
                actionCombox(data.getAllDistinctLanguages());
            break;

            case "show all genres":
                actionCombox(data.getAllDistinctGenres());
            break;

            case "show all ids who saw the sherlock serie":
                actionCombox(data.getAllIdsWhoSawSherlock());
            break;

            case "show all ids who saw the breaking bad serie":
                actionCombox(data.getAllIdsWhoSawBreakingBad());
            break;

            case "show all ids who saw the fargo serie":
                actionCombox(data.getAllIdsWhoSawFargo());
            break;
        }
    }

    private void actionCombox(ArrayList<Object> data){
        ui = new Interface();
        ui.setLayoutType(Layout.MAIN);
        ui.createElements(this.cont, data,null);
    }

    //--------------------------------------------------------------------------------------------------------------
    private ArrayList<Integer> groupValue;
    private ArrayList<String> groupNames;

    //This is the method which controls the combobox on the piechart page
    public void actionJcomboboxPIE(ItemEvent e, Container container){
        data = new dataBaseData();
        this.cont = container;
        switch (String.valueOf(e.getItem())){
            case "show series":
                createShowSeries();
            break;

            case "show age distribution":
                createShowAgeDist();
            break;

            case "show series that are similar":
                createShowSimilar();
            break;

            case "show genre distribution":
                createGenreDistribution();
            break;
        }
    }

    private void createGenreDistribution(){
        this.groupValue = new ArrayList<>();
        this.groupNames = new ArrayList<>();

        this.groupValue.add(stripObjectToInt(data.getCountGenresDetective()));
        this.groupValue.add(stripObjectToInt(data.getCountGenresSpanning()));

        this.groupNames.add("Series met genre detective bevatten: ");
        this.groupNames.add("Series met genre spanning bevatten: ");

        actionComboxPIE(groupValue, groupNames);
    }

    private void createShowSimilar(){
        this.groupValue = new ArrayList<>();
        this.groupNames  = new ArrayList<>();

        this.groupValue.add(stripObjectToInt(data.getCountLijktOpFargo()));
        this.groupValue.add(stripObjectToInt(data.getCountLijktOpBreakingBad()));

        this.groupNames.add("Series lijken op Fargo: ");
        this.groupNames.add("Series lijken op Breaking Bad: ");

        actionComboxPIE(groupValue, groupNames);
    }

    private void createShowAgeDist(){
        this.groupValue = new ArrayList<>();
        this.groupNames  = new ArrayList<>();

        this.groupValue.add(stripObjectToInt(data.getCount6Jaar()));
        this.groupValue.add(stripObjectToInt(data.getCount12Jaar()));
        this.groupValue.add(stripObjectToInt(data.getCount16Jaar()));
        this.groupValue.add(stripObjectToInt(data.getCount18Jaar()));

        this.groupNames.add("6 jaar en ouder");
        this.groupNames.add("12 jaar en ouder");
        this.groupNames.add("16 jaar en ouder");
        this.groupNames.add("18 jaar en ouder");

        actionComboxPIE(groupValue, groupNames);
    }

    private void createShowSeries(){
        this.groupValue = new ArrayList<>();
        this.groupNames  = new ArrayList<>();

        this.groupValue.add(stripObjectToInt(data.getCountOfIdsWhoSawBreakingBad()));
        this.groupValue.add(stripObjectToInt(data.getCountOfIdsWhoSawFargo()));
        this.groupValue.add(stripObjectToInt(data.getCountOfIdsWhoSawSherlock()));

        this.groupNames.add("Breaking Bad");
        this.groupNames.add("Fargo");
        this.groupNames.add("Sherlock");

        actionComboxPIE(groupValue, groupNames);
    }

    //Takes an object as parameter and converts it into an int
    private int stripObjectToInt(Object obj){
        String str = String.valueOf(obj);
        str = str.replaceAll("\\[", "");
        str = str.replaceAll("]","");
        return Integer.parseInt(str);
    }


    private void actionComboxPIE(ArrayList<Integer> data, ArrayList<String> groupNames){
        ui = new Interface();
        ui.setLayoutType(Layout.PIECHART);
        ui.createElements(this.cont, data,groupNames);
    }

    //----------------------------------------------------------------------------------------------------------------------
    //This is the method which controls the age combobox on the new account page
    public void actionJcomboboxACCAge(ItemEvent e, Container container){
        data = new dataBaseData();
        this.cont = container;
        int age = Integer.parseInt(String.valueOf(e.getItem()).replaceAll("\\D+", ""));

        if (age < 12){
            System.out.println("6 jaar of ouder");
        }else if(age >= 12 && age < 16){
            System.out.println("12 jaar of ouder");
        }else if (age >= 16 && age < 18){
            System.out.println("16 jaar of ouder");
        }else{
            System.out.println("18 jaar of ouder");
        }
    }

    //-----------------------------------------------
    public void actionJcomboboxACCLang(ItemEvent e, Container container) {
        data = new dataBaseData();
        this.cont = container;

        switch (String.valueOf(e.getItem())){
            case "Mandarin":
                System.out.println("rice");
            break;

            case "Spanish":
                System.out.println("burrito");
            break;

            case "English":
                System.out.println("tea");
            break;

            case "Dutch":
                System.out.println("cheese");
            break;

            case "French":
                System.out.println("baguette");
            break;

            case "German":
                System.out.println("beer");
            break;
        }
    }

    //-----------------------------------------------
    public void actionJcomboboxACCGenre(ItemEvent e, Container container) {
        data = new dataBaseData();
        this.cont = container;

        switch (String.valueOf(e.getItem())) {
            case "Spanning":
                System.out.println("Dat is spannend man");
            break;

            case "Detective":
                System.out.println("lekker geheimpjes oplossen");
            break;

            case "Sci-fi":
                System.out.println("FUUUUUUTTTUUUUUUUUUURRRRRRRREEEE");
            break;

            case "Fantasy":
                System.out.println("eenhoorn");
            break;

            case "War":
                System.out.println("this is so sad");
            break;

            case "Drama":
                System.out.println("niet leuk saai asf");
            break;
            }
        }
}
