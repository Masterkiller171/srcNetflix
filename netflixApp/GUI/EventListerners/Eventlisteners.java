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
        switch (e.getItem() + ""){
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
    //This is the method which controls the combobox on the piechart page
    public void actionJcomboboxPIE(ItemEvent e, Container container){
        data = new dataBaseData();
        this.cont = container;
        switch (e.getItem() + ""){
            case "show series":
                createShowSeries();
            break;

            case "show age distribution":
                createShowAgeDist();
            break;
        }
    }

    private void createShowAgeDist(){
        ArrayList<Integer> groupValue = new ArrayList<>();
        ArrayList<String> groupNames  = new ArrayList<>();

        groupValue.add(stripObjectToInt(data.getCount6Jaar()));
        groupValue.add(stripObjectToInt(data.getCount12Jaar()));
        groupValue.add(stripObjectToInt(data.getCount16Jaar()));
        groupValue.add(stripObjectToInt(data.getCount18Jaar()));

        groupNames.add("6 jaar en ouder");
        groupNames.add("12 jaar en ouder");
        groupNames.add("16 jaar en ouder");
        groupNames.add("18 jaar en ouder");

        actionComboxPIE(groupValue, groupNames);
    }

    private void createShowSeries(){
        ArrayList<Integer> groupValue = new ArrayList<>();
        ArrayList<String> groupNames  = new ArrayList<>();

        groupValue.add(stripObjectToInt(data.getCountOfIdsWhoSawBreakingBad()));
        groupValue.add(stripObjectToInt(data.getCountOfIdsWhoSawFargo()));
        groupValue.add(stripObjectToInt(data.getCountOfIdsWhoSawSherlock()));

        groupNames.add("Breaking Bad");
        groupNames.add("Fargo");
        groupNames.add("Sherlock");

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

}
