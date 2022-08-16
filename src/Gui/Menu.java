package Gui;

import javax.swing.*;
import java.awt.*;

public class Menu extends JLabel {




    protected void paintComponent(Graphics m) {
        super.paintComponent(m);
        Graphics2D g2d = (Graphics2D) m;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw Background
        m.setColor(Color.LIGHT_GRAY);
        m.fillRect(0,0,Gui.width,Gui.height);
    }


}


