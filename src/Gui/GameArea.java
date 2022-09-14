package Gui;

import actions.Collusion;
import clocks.GameClock;
import game.Pickup;
import game.Snake;
import persistence.HighscoreDao;
import javax.swing.*;
import java.awt.*;

public class GameArea extends JComponent {
    private Point point;
    private final Pickup pickup = new Pickup();
    private final HighscoreDao highscoreDao = new HighscoreDao();
    private final GameClock gameClock;
    private final Snake snake = new Snake();
    private final Collusion collusion = new Collusion();
    private String nameHighscoretraeger;

    public GameArea(GameClock gameClock, String nameHighscoretraeger){
        this.gameClock = gameClock;
        this.nameHighscoretraeger = nameHighscoretraeger;
    }

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
        for (int i = 0; i< snake.tails.size(); i++){
            point = snake.ptc(snake.tails.get(i).getX(),snake.tails.get(i).getY());
            g.fillRect(point.x, point.y,32,32);
        }

        //Draw Head
        g.setColor(Color.BLUE);
        point = snake.ptc(snake.head.getX(),snake.head.getY());
        g.fillRect(point.x, point.y,32,32);


        // Draw Pickup
        g.setColor(new Color(45,34,34));
        point = snake.ptc(pickup.getX(), pickup.getY());
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
        g.setFont(new Font("Arial", Font.BOLD,20));
        g.drawString("Score:  "+ collusion.score,5, 25);
        g.drawString("Best:  "+collusion.bestscore, 655, 25);
        g.drawString("Name: "+ nameHighscoretraeger,655,50);
        g.drawString("Speed:  "+ gameClock.speed,655,75);
    }
}
