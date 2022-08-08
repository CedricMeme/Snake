package clocks;

import actions.Collusion;
import game.Snake;

public class GameClock extends Thread{
    public static boolean running = true;
    int s =100;

    /*public void loadscore(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("SaveFile.txt"));
            Snake.bestscore = Integer.parseInt(br.readLine());
            br.close();
        }catch (Exception e) {
        }*/
    public void run(){
        Snake.loadscore();
        while(running){


            try {
                sleep(s);
                Snake.move();
                Snake.waitToMove = false;

                Collusion.collidePickUp();
                if(Collusion.collideSelf()) {
                    Snake.savescore();
                    Snake.tails.clear();
                    Snake.score = 0;
                }
                if (Collusion.collideWall()){
                    Snake.savescore();
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.score = 0;
                }





            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }



}
