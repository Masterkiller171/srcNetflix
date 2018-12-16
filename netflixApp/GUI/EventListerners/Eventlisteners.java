package netflixApp.GUI.EventListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventlisteners implements ActionListener {
    public Eventlisteners() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Checks for button names and assigning them to an action
        switch (e.getActionCommand()){
            case "teset but":
                System.out.println("button 1");
                break;
            case "test button":
                System.out.println("button 2");
                break;
            case "testbut 2":
                System.out.println("testbut 2");
                break;
        }
    }

}
