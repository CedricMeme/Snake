package Gui;

import actions.Main;
import game.Snake;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class Draw extends JLabel {

    // TODO gleiche Aufgabe wie in Gui, Head und Pickup
    Point p;

    /*TODO
    Auch hier kannst du mal mit dem Mauszeiger über die Zeile 21 "protected void paintComponent(Graphics g) {" hovern
    IntelliJ zeigt dir dann einen Hinweis an. Was ist mit dem Hinweis gemeint?
    Auch hier geht es um Vererbung, d.h. ruhig als letztes rangehen
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw Background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,Gui.width,Gui.height);

        //Snake
        g.setColor(new Color(34,56,13));
        for (int i = 0; i< Snake.tails.size();i++){
            p = Snake.ptc(Snake.tails.get(i).getX(),Snake.tails.get(i).getY());
            g.fillRect(p.x,p.y,32,32);

        }

        //Draw Head
        g.setColor(BLUE);
        p = Snake.ptc(Snake.head.getX(),Snake.head.getY());
        g.fillRect(p.x,p.y,32,32);


        // Draw Pickup
        g.setColor(new Color(45,34,34));
        p = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
        g.fillRect(p.x,p.y, 32,32);

        //DRaw Grid
        g.setColor(Color.GRAY);
        for(int i=0; i<16; i++){
            for(int j = 0; j<16; j++){
                g.drawRect(i*32+Gui.xoff,j*32+Gui.yoff,32,32);
            }
        }
        //JFrame


        //Draw Border
        g.setColor(Color.BLACK);
        g.drawRect(Gui.xoff,Gui.yoff,512,512);
        repaint();

        //Draw Score
        g.setFont(new Font("Arial", Font.BOLD,20));
        g.drawString("Score:  "+Snake.score,5, 25);
        g.drawString("Best:  "+Snake.bestscore, 655, 25);
        g.drawString("Name: "+ Main.name2,655,50);
        g.drawString("Speed:  "+Snake.speed,655,75);
    }
}
