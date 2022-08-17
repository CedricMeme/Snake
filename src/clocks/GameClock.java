package clocks;

import actions.Collusion;
import actions.Main;
import game.Snake;
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
        Snake.loadScore();
        while(running){
            try {
                /*TODO
                Hover mal mit deinem Mauszeiger über die Zeilen 26, 35, 39, 47 und 53
                IntelliJ zeigt dir dann einen Hinweis an, bei dem es um statische bzw. nichtstatische Variablen geht
                Was ist gemeint? Solltest du etwas anders machen?
                 */
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
                // TODO überflüssige Absätze entfernen




            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }



}
