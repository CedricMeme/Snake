package clocks;

import actions.Collusion;
import game.Snake;
import persistence.HighscoreDao;
import static game.Snake.*;
import static persistence.HighscoreDao.*;

public class GameClock extends Thread{
    public boolean running = true;
    private Collusion collusion = new Collusion();
    private HighscoreDao namePlayer = new HighscoreDao();
    private Snake move = new Snake();
    public void run(){
        while(running == true){
            try {
                waitToMove = false;
                sleep(speed);
                if (move.move == 0){
                    move.move();
                }
                collusion.collidePickUp();
                if(collusion.collideSelf()) {
                    if(score >= bestscore && score != 0) {
                        namePlayer.namePlayer();
                        namePlayer.deleteHighscoreFromDatabase();
                        namePlayer.saveHighscoreToDatabase();
                    }
                    tails.clear();
                    score = 0;
                    if (spielModus == 4){
                        speed = 200;
                    }
                }
                if (collusion.collideWall()){
                    if(score >= bestscore && score != 0) {
                        namePlayer.namePlayer();
                        namePlayer.deleteHighscoreFromDatabase();
                        namePlayer.saveHighscoreToDatabase();
                    }
                    tails.clear();
                    head.setX(7);
                    head.setY(7);
                    score = 0;
                    if (spielModus == 4){
                        speed = 200;
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
