package clocks;

import actions.Collusion;
import game.Snake;
import static game.Snake.s;


public class GameClock extends Thread{
    public static boolean running = true;



    public void run(){

        Snake.loadscore();
        while(running){


            try {
                Snake.waitToMove = false;
                sleep(s);
                Snake.move();
                Collusion.collidePickUp();
                if(Collusion.collideSelf()) {
                    Snake.tails.clear();
                    Snake.score = 0;
                    if (Snake.modus == 1){
                        Snake.s = 200;
                    }
                }
                if (Collusion.collideWall()){
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.score = 0;
                    if (Snake.modus == 1){
                        Snake.s = 200;
                    }
                }





            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }



}
