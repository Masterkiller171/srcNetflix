package netflixApp.GUI.EventListerners;

import netflixApp.Database.dataBaseData;
import netflixApp.GUI.GUIelements.Layout;
import netflixApp.GUI.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class Eventlisteners implements ActionListener {
    private Container cont;
    private Interface ui;

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

    //This is the method which controls the combobox on the mainpage
    public void actionJComboxMain(ItemEvent e, Container container){
        dataBaseData data = new dataBaseData();
        this.cont = container;
        switch (e.getItem() + ""){
            case "test1":

                ui = new Interface();
                ui.setLayoutType(Layout.MAIN);
                ui.createElements(this.cont,data.getDistinctSeriesTitle());
            break;
        }
    }
    
    //This method will show the new account page
    private void newAcc() {
        ui = new Interface();
        ui.setLayoutType(Layout.NEWACCOUNT);
        ui.createElements(cont,null);
    }

    //Will choose the layoutType 2 which is currently an empty center canvas
    private void resetPage(){
        ui = new Interface();
        ui.setLayoutType(Layout.REMOVEACC);
        ui.createElements(cont,null);
    }

    //Will return the page to layoutType 1 which is the main page
    private void returnPage(){
        ui = new Interface();
        ui.setLayoutType(Layout.MAIN);
        ui.createElements(cont,null);
    }

    private void pieCharts(){
        ui = new Interface();
        ui.setLayoutType(Layout.PIECHART);
        ui.createElements(cont,null);
    }
}
