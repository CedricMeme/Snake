package Gui;

import clocks.GameClock;
import game.Pickup;
import game.Snake;
import persistence.HighscoreDao;
import javax.swing.*;
import java.awt.*;

public class GameArea extends JComponent {
    private Point point;
    Pickup pickup = new Pickup();
    HighscoreDao highscoreDao = new HighscoreDao();
    private GameClock speed = new GameClock();
    private Snake ptc = new Snake();
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw Background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,800,600);

        //Snake
        g.setColor(new Color(34,56,13));
        for (int i = 0; i< Snake.tails.size(); i++){
            point = ptc.ptc(Snake.tails.get(i).getX(),Snake.tails.get(i).getY());
            g.fillRect(point.x, point.y,32,32);

        }

        //Draw Head
        g.setColor(Color.BLUE);
        point = ptc.ptc(Snake.head.getX(),Snake.head.getY());
        g.fillRect(point.x, point.y,32,32);


        // Draw Pickup
        g.setColor(new Color(45,34,34));
        point = ptc.ptc(pickup.getX(), pickup.getY());
        g.fillRect(point.x, point.y, 32,32);

        //Draw Grid
        g.setColor(Color.GRAY);
        for(int i=0; i<16; i++){
            for(int j = 0; j<16; j++){
                g.drawRect(i*32+120,j*32+20,32,32);
            }
        }

        //Draw Border
        g.setColor(Color.BLACK);
        g.drawRect(120,20,512,512);//120, 20
        repaint();

        //Draw Score
        highscoreDao.loadHighscoreFromDatabase();
        g.setFont(new Font("Arial", Font.BOLD,20));
        g.drawString("Score:  "+Snake.score,5, 25);
        g.drawString("Best:  "+Snake.bestscore, 655, 25);
        g.drawString("Name: "+ highscoreDao.nameHighscoretraeger,655,50);
        g.drawString("Speed:  "+ speed,655,75);
    }
}
