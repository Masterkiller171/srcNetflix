package netflixApp.GUI.EventListerners;

import netflixApp.GUI.GUIelements.Layout;
import netflixApp.GUI.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventlisteners implements ActionListener {
    private Container cont;

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

    private void newAcc() {
        Interface ui = new Interface();
        ui.setLayoutType(Layout.NEWACCOUNT);
        ui.createElements(cont);
    }

    //Will choose the layoutType 2 which is currently an empty center canvas
    private void resetPage(){
        Interface ui = new Interface();
        ui.setLayoutType(Layout.REMOVEACC);
        ui.createElements(cont);
    }

    //Will return the page to layoutType 1 which is the main page
    private void returnPage(){
        Interface ui = new Interface();
        ui.setLayoutType(Layout.MAIN);
        ui.createElements(cont);
    }

    private void pieCharts(){
        Interface ui = new Interface();
        ui.setLayoutType(Layout.PIECHART);
        ui.createElements(cont);
    }
}
