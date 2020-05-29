package ui.panels;

import ui.components.GameButton;

import javax.swing.*;
import java.awt.*;

public class WinPanel extends FinalPanel {

    public WinPanel(){
        setUp();
        this.label.setText("Congratulations you won! Press the \"Play again\" button to start over!");
    }

}
