package clocks;

import actions.Collusion;
import actions.Main;
import game.Snake;
import static actions.Main.Name;
import static game.Snake.*;

public class GameClock extends Thread{
    public static boolean running = true;

    public void run(){
        Snake.loadScore();
        while(running){
            try {
                Snake.waitToMove = false;
                sleep(speed);
                if (move == 0){
                    Snake.move();
                }
                Collusion.collidePickUp();
                if(Collusion.collideSelf()) {
                    if(Snake.score >= Snake.bestscore) {
                        Name();
                        Main.name2 = Main.name;
                        saveScore();
                    }
                    Snake.tails.clear();
                    Snake.score = 0;
                    if (Snake.modus == 1){
                        Snake.speed = 200;
                    }
                }
                if (Collusion.collideWall()){
                    if(Snake.score >= Snake.bestscore) {
                        Name();
                        Main.name2 = Main.name;
                        saveScore();
                    }
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.score = 0;
                    if (Snake.modus == 1){
                        Snake.speed = 200;
                    }
                }





            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }



}
