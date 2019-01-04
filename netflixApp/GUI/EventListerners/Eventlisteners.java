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
    private String infoText;

    //Constructor will receive the container object from the GUI class
    public Eventlisteners(Container cont) {
        this.cont = cont;
        this.infoText = "test";
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
                removeAccountPage();
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
            data.uploadAccToDatabase(age,language,genre, serie, similar, season);
        }
    }

    //This method will show the new account page
    private void newAcc() {
        ui = new Interface();
        ui.setLayoutType(Layout.NEWACCOUNT);
        this.infoText = "On this page you may create an account which then will be uploaded to the database.";
        ui.createElements(cont,null,null,infoText);
    }

    //Will choose the layoutType 2 which is currently an empty center canvas
    private void removeAccountPage(){
        ui = new Interface();
        ui.setLayoutType(Layout.REMOVEACC);
        this.infoText = "On this page you may remove an account which then will be uploaded to the database.";
        ui.createElements(cont,null,null,infoText);
    }

    //Will return the page to layoutType 1 which is the main page
    private void returnPage(){
        ui = new Interface();
        ui.setLayoutType(Layout.MAIN);
        this.infoText = "Welcome to our application!";
        ui.createElements(cont,null,null,infoText);
    }

    private void pieCharts(){
        ui = new Interface();
        ui.setLayoutType(Layout.PIECHART);
        this.infoText = "On this page you may see a piechart which will show different groups, their values and the percentage of the total sum.";
        ui.createElements(cont,null,null,infoText);
    }

    //---------------------------------------------------------------------------------------------------
    //This is the method which controls the combobox on the mainpage
    public void actionJComboxMain(ItemEvent e, Container container){
        data = new dataBaseData();
        this.cont = container;
        switch (String.valueOf(e.getItem())){
            case "show all different series":
                this.infoText = "All of the distinct series are shown below.";
                actionCombox(data.getDistinctSeriesTitle());
            break;

            case "show top 15 distinct titles of episodes":
                this.infoText = "The top 15 of all titles from episodes are shown below.";
                actionCombox(data.getTop15EpisodesTitle());
            break;

            case "show all languages":
                this.infoText = "All the distinct languages are shown below.";
                actionCombox(data.getAllDistinctLanguages());
            break;

            case "show all genres":
                this.infoText = "All the distinct genres are shown below.";
                actionCombox(data.getAllDistinctGenres());
            break;

            case "show all ids who saw the sherlock serie":
                this.infoText = "All of the ids who have seen the Sherlock serie are shown below.";
                actionCombox(data.getAllIdsWhoSawSherlock());
            break;

            case "show all ids who saw the breaking bad serie":
                this.infoText = "All of the ids who have seen the Breaking Bad serie are shown below.";
                actionCombox(data.getAllIdsWhoSawBreakingBad());
            break;

            case "show all ids who saw the fargo serie":
                this.infoText = "All of the ids who have seen the Fargo serie are shown below.";
                actionCombox(data.getAllIdsWhoSawFargo());
            break;
        }
    }

    private void actionCombox(ArrayList<Object> data){
        ui = new Interface();
        ui.setLayoutType(Layout.MAIN);
        ui.createElements(this.cont, data,null, infoText);
    }

    //--------------------------------------------------------------------------------------------------------------
    //Rule for optimization: every method may only request data from database once (done)
    private ArrayList<Integer> groupValue;
    private ArrayList<String> groupNames;

    //This is the method which controls the combobox on the piechart page
    public void actionJcomboboxPIE(ItemEvent e, Container container){
        data = new dataBaseData();
        this.cont = container;
        switch (String.valueOf(e.getItem())){
            case "show series":
                this.infoText = "All the series and their amount of viewers are shown in the piechart and in the legend.";
                createShowSeries();
            break;

            case "show age distribution":
                this.infoText = "All the ages and the amount of people who have selected that age are shown in the piechart and in the legend.";
                createShowAgeDist();
            break;

            case "show series that are similar":
                this.infoText = "All the series who are similar to another serie are shown in the piechart and in the legend.";
                createShowSimilar();
            break;

            case "show genre distribution":
                this.infoText = "All the genres and amount of series which have those genres are shown in the piechart and in the legend.";
                createGenreDistribution();
            break;

            case "show different letters in series":
                this.infoText = "20 randomly chosen letters chosen from the alphabet are shown below and how many times they show up in all of the titles of all episodes in the database.";
                createShowDifferentCharacters();
            break;

            case "show language distribution":
                this.infoText = "Shows all distinct languages and the amount of people who choose that language.";
                createShowLangDist();
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
        int nullSum = 0;

        try {
            for (Object o : data.getLijktOp()) {
                if (o.toString().equals("Fargo")) {
                    sumFargo++;
                } else if (o.toString().equals("Breaking Bad")) {
                    sumBad++;
                } else if (o.toString().toUpperCase().equals("NULL")) {
                    nullSum++;
                }
            }
        }catch (NullPointerException e){
            e.getCause();
        }

        this.groupValue.add(sumFargo);
        this.groupValue.add(sumBad);
        this.groupValue.add(nullSum);
        this.groupNames.add("Series similar to  Fargo: ");
        this.groupNames.add("Series similar to Breaking Bad: ");
        this.groupNames.add("Series similar to Nothing: ");

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
        ArrayList<Object> datas = data.getCountOfIdsWhoSawSeries();

        this.groupNames.add("Breaking Bad");
        this.groupNames.add("Fargo");
        this.groupNames.add("Sherlock");

        int sumBad = 0;
        int sumFargo = 0;
        int sumSher = 0;

        for (Object o : datas) {
            if (o.toString().equals(groupNames.get(0))){
                sumBad++;
            }else if (o.toString().equals(groupNames.get(1))){
                sumFargo++;
            }else if (o.toString().equals(groupNames.get(2))){
                sumSher++;
            }
        }

        this.groupValue.add(sumBad);
        this.groupValue.add(sumFargo);
        this.groupValue.add(sumSher);

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
        for (int i = 0; i < 20; i++) {
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

    private void createShowLangDist(){
        this.groupValue = new ArrayList<>();
        this.groupNames  = new ArrayList<>();
        ArrayList<Object> datas = data.getAlllanguages();
        Map<String, Integer> lanDat = new HashMap<>();

        for (Object o : datas) {
            if (!lanDat.containsKey(o.toString())){
                lanDat.put(o.toString(), 1);
                groupNames.add(o.toString());
            }else{
                lanDat.replace(o.toString(), (lanDat.get(o.toString()) + 1));
            }
        }

        for (int i = 0; i < groupNames.size(); i++) {
            groupValue.add(lanDat.get(groupNames.get(i)));
        }

        actionComboxPIE(groupValue, groupNames);
    }
    //--------------------------------------------
    private void actionComboxPIE(ArrayList<Integer> data, ArrayList<String> groupNames){
        ui = new Interface();
        ui.setLayoutType(Layout.PIECHART);
        ui.createElements(this.cont, data,groupNames, infoText);
    }

    //----------------------------------------------------------------------------------------------------------------------
    //This is the method which controls the age combobox on the new account page
    private String age;
    private String language;
    private String genre;
    private String serie;
    private String similar;
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
        switch (String.valueOf(e.getItem())){
            case "Sherlock":
                similar = "Fargo";
            break;

            case "Fargo":
                similar = "Breaking Bad";
            break;
        }
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
