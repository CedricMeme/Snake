package clocks;

import actions.Collusion;
import actions.Main;
import game.Snake;
import static game.Snake.s;
import static game.Snake.savescore;


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
                    if(Snake.score >= Snake.bestscore) {
                        Main.Name();
                        Main.name2 = Main.name;
                        savescore();
                    }
                    Snake.tails.clear();
                    Snake.score = 0;
                    if (Snake.modus == 1){
                        Snake.s = 200;
                    }

                }
                if (Collusion.collideWall()){
                    if(Snake.score >= Snake.bestscore) {
                        Main.Name();
                        Main.name2 = Main.name;
                        savescore();
                    }
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
