package clocks;

import Music.Music;
import actions.Collusion;
import actions.Main;
import persistence.HighscoreDao;

import static actions.Main.Name;
import static game.Snake.*;
import static persistence.HighscoreDao.*;

public class GameClock extends Thread{
    public static boolean running = true;
    public void run(){
        Music.music("stc/Music/music.mp3");
        while(running){
            try {
                waitToMove = false;
                sleep(speed);
                if (move == 0){
                    move();
                }
                Collusion.collidePickUp();
                if(Collusion.collideSelf()) {
                    if(score >= bestscore && score != 0) {
                        Name();
                        Main.nameHighscoretraeger = Main.nameSpieler;
                        deleteHighscoreFromDatabase();
                        saveHighscoreToDatabase();
                    }
                    tails.clear();
                    score = 0;
                    if (modus == 1){
                        speed = 200;
                    }
                }
                if (Collusion.collideWall()){
                    if(score >= bestscore && score != 0) {
                        Name();
                        Main.nameHighscoretraeger = Main.nameSpieler;
                        deleteHighscoreFromDatabase();
                        saveHighscoreToDatabase();

                    }
                    tails.clear();
                    head.setX(7);
                    head.setY(7);
                    score = 0;
                    if (modus == 1){
                        speed = 200;
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }



}
