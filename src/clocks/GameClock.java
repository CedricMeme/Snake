package clocks;

import Music.Music;
import actions.Collusion;
import actions.Main;
import static actions.Main.Name;
import static game.Snake.*;

public class GameClock extends Thread{
    public static boolean running = true;
    /*TODO
    Hover mal mit deinem Mauszeiger über die Zeile 17 "public void run(){"
    IntelliJ zeigt dir dann einen Hinweis an. Finde auch hier bitte mal heraus, was mit dem Hinweis gemeint ist
    Es geht um Vererbung, das haben wir noch nicht besprochen, also mach das ruhig erst ganz am Ende, das ist ein größeres Thema
     */
    public void run(){
        Music.music("stc/Music/music.mp3");
        loadScore();
        while(running){
            try {
                waitToMove = false;
                sleep(speed);
                if (move == 0){
                    move();
                }
                Collusion.collidePickUp();
                if(Collusion.collideSelf()) {
                    if(score >= bestscore) {
                        Name();
                        Main.nameHighscoretraeger = Main.nameSpieler;
                        saveScore();
                    }
                    tails.clear();
                    score = 0;
                    if (modus == 1){
                        speed = 200;
                    }
                }
                if (Collusion.collideWall()){
                    if(score >= bestscore) {
                        Name();
                        Main.nameHighscoretraeger = Main.nameSpieler;
                        saveScore();
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
