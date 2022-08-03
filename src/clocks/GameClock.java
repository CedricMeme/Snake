package clocks;

import actions.Collusion;
import game.Snake;

public class GameClock extends Thread{
    public static boolean running = true;

    public void run(){
        while(running){
            try {
                sleep(200);
                Snake.move();
                Snake.waitToMove = false;

                Collusion.collidePickUp();
                if(Collusion.collideSelf()) {
                    Snake.tails.clear();
                }
                if (Collusion.collideWall()){
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                }



            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
