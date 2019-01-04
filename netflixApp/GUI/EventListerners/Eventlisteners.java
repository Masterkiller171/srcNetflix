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
import java.util.HashMap;
import java.util.Map;

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
            case "finished!":
                insertDataintoDb();
                break;
        }
    }

    private void insertDataintoDb(){
        System.out.println("shoving that good shit into the database");
        if (!this.age.isEmpty() && !this.language.isEmpty() && !this.genre.isEmpty()){
            data.uploadAccToDatabase(age,language,genre, serie, season);
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
    //Rule for optimization: every method may only request data from database once
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

            case "show different letters in series":
                createShowDifferentCharacters();
            break;
        }
    }

    private void createGenreDistribution(){
        this.groupValue = new ArrayList<>();
        this.groupNames = new ArrayList<>();
        ArrayList<Object> genres = data.getGenres();

        Map<String, Integer> genreVal = new HashMap<>();
        for (Object dataGenre : genres) {
            if (!genreVal.keySet().contains(dataGenre.toString())) {
                genreVal.put(dataGenre.toString(), 0);
                groupNames.add(dataGenre.toString());
            }
        }

        for (Object o : genres) {
            for (int i = 0; i < genreVal.size(); i++) {
                if (groupNames.get(i).equals(o.toString())){
                    genreVal.replace(groupNames.get(i), (genreVal.get(groupNames.get(i)) + 1));
                }
            }
        }

        for (int i = 0; i < genreVal.size(); i++) {
            groupValue.add(genreVal.get(groupNames.get(i)));
        }

        actionComboxPIE(groupValue, groupNames);
    }


    private void createShowSimilar(){
        this.groupValue = new ArrayList<>();
        this.groupNames  = new ArrayList<>();

        int sumFargo = 0;
        int sumBad = 0;
        for (Object o : data.getLijktOp()) {
            if (o.toString().equals("Fargo")){
                sumFargo++;
            }else if (o.toString().equals("Breaking Bad")){
                sumBad++;
            }
        }

        this.groupValue.add(sumFargo);
        this.groupValue.add(sumBad);
        this.groupNames.add("Series lijken op Fargo: ");
        this.groupNames.add("Series lijken op Breaking Bad: ");

        actionComboxPIE(groupValue, groupNames);
    }

    private void createShowAgeDist(){
        this.groupValue = new ArrayList<>();
        this.groupNames  = new ArrayList<>();
        ArrayList<Object> datas = data.getAgeYears();

        Map<String, Integer> ageYear = new HashMap<>();
        for (Object year : datas) {
            if (!ageYear.containsKey(year.toString())){
                ageYear.put(year.toString(), 0);
                groupNames.add(year.toString());
            }
        }

        for (int i = 0; i < datas.size(); i++) {
            ageYear.replace(datas.get(i).toString(), (ageYear.get(datas.get(i).toString()) + 1));
        }

        for (int i = 0; i < ageYear.size(); i++) {
            groupValue.add(ageYear.get(groupNames.get(i)));
        }

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

    //This method generates a string with 10 random unique characters
    //And Checks every title of each episode in the database and then counts them up if they match
    //Finally it will return de map with 10 randomly chosen characters and the corresponding sums of how many times the
    //Character has been counted
    private void createShowDifferentCharacters(){
        this.groupValue = new ArrayList<>();
        this.groupNames  = new ArrayList<>();
        String allChars = "abcdefghiklmnopqrstuvwxyz";

        StringBuilder customCombo = new StringBuilder();
        Map<Character,Integer> datlet = new HashMap<>();
        for (int i = 0; i < 10; i++) {
             int rando = (int)(Math.random() * 25);
                 while (true) {
                     if (!customCombo.toString().contains(allChars.charAt(rando) + "")) {
                         customCombo.append(allChars.charAt(rando));
                         datlet.put(allChars.charAt(rando), 0);
                         break;
                     }else{
                         rando = (int)(Math.random() * 25);
                     }
                 }
             }


        for (Object o : data.getLettersFromSerie()) {
            for (int i = 0; i < o.toString().length(); i++) {
                for (int j = 0; j < customCombo.toString().length(); j++) {
                    if (o.toString().charAt(i) == customCombo.toString().charAt(j)){
                        datlet.replace(customCombo.toString().charAt(j), (datlet.get(customCombo.toString().charAt(j)) + 1));
                    }
                }
            }
        }

        for (int i = 0; i < datlet.size(); i++) {
            groupNames.add(customCombo.toString().charAt(i) + "");
            groupValue.add(datlet.get(customCombo.toString().charAt(i)));
        }
        actionComboxPIE(groupValue, groupNames);
    }
    //--------------------------------------------
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
    private String age;
    private String language;
    private String genre;
    private String serie;
    private int season;

    public void actionJcomboboxACCAge(ItemEvent e, Container container){
        data = new dataBaseData();
        this.cont = container;
        try {
            int age = Integer.parseInt(String.valueOf(e.getItem()).replaceAll("\\D+", ""));

            if (age < 12) {
                System.out.println("6 jaar of ouder");
                this.age = "6 jaar en ouder";
            } else if (age >= 12 && age < 16) {
                System.out.println("12 jaar of ouder");
                this.age = "12 jaar en ouder";
            } else if (age >= 16 && age < 18) {
                System.out.println("16 jaar of ouder");
                this.age = "16 jaar en ouder";
            } else {
                System.out.println("18 jaar of ouder");
                this.age = "18 jaar en ouder";
            }
        }catch (NumberFormatException event){
            event.getCause();
        }
    }

    //-----------------------------------------------
    public void actionJcomboboxACCLang(ItemEvent e, Container container) {
        this.cont = container;
        this.language = String.valueOf(e.getItem());
    }

    //-----------------------------------------------
    public void actionJcomboboxACCGenre(ItemEvent e, Container container) {
        this.cont = container;
        this.genre = String.valueOf(e.getItem());
    }

    //-----------------------------------------------
    public void actionJcomboboxACCSerie(ItemEvent e, Container container) {
        this.cont = container;
        this.serie = String.valueOf(e.getItem());
    }

    //-----------------------------------------------
    public void actionJcomboboxACCSeason(ItemEvent e, Container container) {
        this.cont = container;
        String str = String.valueOf(e.getItem());
        str = str.replaceAll("\\D+","");
        try {
            this.season = Integer.parseInt(str);
        }catch (NumberFormatException event){
            event.getCause();
        }

    }
    //----------------------------------------------------------------------------------------------------------------------
}
