package netflixApp.GUI.GUIelements;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;

import java.awt.*;

public class GUI {
    private Container container;



    public GUI(Container container) {
        this.container = container;
    }

    //Constructing the layout
    private void createLayout(){
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

        container.add(setNorth(), BorderLayout.NORTH); //Top sector
        container.add(setWest(), BorderLayout.WEST); //Left sector
        container.add(setEast(),BorderLayout.EAST);//Right sector
        container.add(setCenter(), BorderLayout.CENTER); //Center sector
        container.add(setSouth(), BorderLayout.SOUTH); //Bottom sector
    }



    //Setting up the North section
    private JPanel setNorth(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(2,3);
        panel.setLayout(grid);

        panel.add(new JTextArea("test"));

        return panel;
    }

    //Setting up the west section
    private JPanel setWest(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(3,3);
        panel.setLayout(grid);

        for (int x = 0; x< 2; x++){
            panel.add(new JLabel());
        }

        panel.add(new JLabel("text"));
        panel.add(new JLabel("text"));
        panel.add(new JLabel("text"));

        return panel;
    }

    //Setting up the east section
    private JPanel setEast(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(1,1);
        panel.setLayout(grid);

        JLabel testLabel = new JLabel();
        testLabel.setText("   ");

        panel.add(testLabel);


        return panel;
    }
    //Setting up the center section
    private JScrollPane setCenter(){
        JScrollPane panel = new JScrollPane();
        GridLayout grid = new GridLayout(10,10);
        
        JTextArea testLb = new JTextArea();
        testLb.setLineWrap(true);
        testLb.setWrapStyleWord(true);
        testLb.setEditable(false);

        testLb.setText("Donec congue, elit nec hendrerit scelerisque, lorem tellus egestas tortor, nec dictum lectus lorem eget quam. Curabitur at feugiat nunc. Aliquam odio nibh, convallis at lacus sit amet, " +
                "pulvinar aliquam dolor. Duis fringilla risus quis nisi luctus pellentesque. Maecenas imperdiet, justo vitae fermentum euismod, justo lorem tristique quam, id sollicitudin velit justo eu ante. " +
                "Sed cursus nibh id neque finibus bibendum. Morbi lacus augue, mollis id leo non, sagittis ultricies augue. Ut id pellentesque risus. Nam tincidunt tortor leo, quis aliquet lacus iaculis vel. " +
                "Phasellus sagittis mi eu sapien rhoncus, non sollicitudin enim iaculis. Aliquam ac lacus nec odio egestas fermentum. Curabitur a suscipit leo. " +
                " Ut tempus ante a leo molestie commodo. Sed vestibulum libero gravida, aliquet quam ac, feugiat nisi. Sed mollis sem nec volutpat vulputate. Nam consectetur pretium sagittis. ");



        JTextArea testLb2 = new JTextArea();
        testLb2.setLineWrap(true);
        testLb2.setWrapStyleWord(true);
        testLb2.setEditable(false);
        testLb2.setText("Donec congue, elit nec hendrerit scelerisque, lorem tellus egestas tortor, nec dictum lectus lorem eget quam. Curabitur at feugiat nunc. Aliquam odio nibh, convallis at lacus sit amet, " +
                "pulvinar aliquam dolor. Duis fringilla risus quis nisi luctus pellentesque. Maecenas imperdiet, justo vitae fermentum euismod, justo lorem tristique quam, id sollicitudin velit justo eu ante. " +
                "Sed cursus nibh id neque finibus bibendum. Morbi lacus augue, mollis id leo non, sagittis ultricies augue. Ut id pellentesque risus. Nam tincidunt tortor leo, quis aliquet lacus iaculis vel. " +
                "Phasellus sagittis mi eu sapien rhoncus, non sollicitudin enim iaculis. Aliquam ac lacus nec odio egestas fermentum. Curabitur a suscipit leo. " +
                " Ut tempus ante a leo molestie commodo. Sed vestibulum libero gravida, aliquet quam ac, feugiat nisi. Sed mollis sem nec volutpat vulputate. Nam consectetur pretium sagittis. ");
        panel.add(testLb2);
        return panel;
    }

    //Setting up the south section
    private JPanel setSouth(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(2,8);
        panel.setLayout(grid);

        //Adding empty Panels to align the JButton
        for (int x = 0; x < 2; x++) {
            panel.add(new JPanel());
        }

        //A button
        panel.add(new JButton("tester"));

        //Adding empty Panels to align the JButton
        for (int x = 0; x < 6; x++) {
            panel.add(new JPanel());
        }



        return panel;
    }



    //Returning the constructed layout to the interface class
    public Container getUi() {
        createLayout();

        return container;
    }

}
