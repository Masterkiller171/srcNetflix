package netflixApp.GUI.EventListerners;

import netflixApp.GUI.GUIelements.GUI;
import netflixApp.GUI.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventlisteners implements ActionListener {
    private Container cont;

    public Eventlisteners(Container cont) {
        this.cont = cont;
    }

    //Overloading the constructor so it doesn't need a parameter each time
    public Eventlisteners() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Checks for button names and assigning them to an action
        switch (e.getActionCommand()){
            case "reset page":
                resetPage();
                break;
            case "return page":
                returnPage();
                break;
        }
    }

    private void resetPage(){
        Interface ui = new Interface();
        ui.setLayoutType(2);
        ui.createElements(cont);
    }

    private void returnPage(){
        Interface ui = new Interface();
        ui.setLayoutType(1);
        ui.createElements(cont);
    }
}
