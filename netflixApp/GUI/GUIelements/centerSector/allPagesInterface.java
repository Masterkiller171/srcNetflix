package netflixApp.GUI.GUIelements.centerSector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface allPagesInterface {
    JPanel getCenterSector();
    void setUpExplainText(String text, int height);
    void setUpdataShowText(ArrayList listWithData, int height);
    void setContainer(Container container);
    JPanel getInfoText();
}
