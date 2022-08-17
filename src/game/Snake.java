package game;

// TODO Hier sind die import statements gut organisiert :)
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import Gui.Gui;
import actions.Main;

public class Snake extends Component {

    // TODO Absätze zwischen den Variablen entfernen
    public static int score = 0, bestscore = 0, speed = 100, modus = 0, move = 0;
    public static String load = null;

    public static boolean waitToMove = false;

    public static Head head = new Head(7,-7);
    public static ArrayList<Tail> tails = new ArrayList<>();

    public static Pickup pickup = new Pickup();

    public static void addTail(){
        if(tails.size() <1){
            tails.add(new Tail(head.getX(),head.getY()));
        }else{
            tails.add(new Tail(tails.get(tails.size()-1).x, tails.get(tails.size()-1).y));
        }
    }

    public static void move(){
        if(tails.size() >=2) {
            for (int i = tails.size() - 1; i >= 1; i--) {
                if (tails.get(i).isWait()) {
                    tails.get(i).setWait(false);
                } else{
                tails.get(i).setX(tails.get(i - 1).getX());
                tails.get(i).setY(tails.get(i - 1).getY());
                }
            }
        }

        if (tails.size() >=1){
            if (tails.get(0).isWait()){
                tails.get(0).setWait(false);
            }else{
                tails.get(0).setX(head.getX());
                tails.get(0).setY(head.getY());
            }
        }

        /* TODO Hier sieht alles gut aus! Stell dir aber mal vor, dass du dein Snake-Programm verkaufen möchtest und dass der Käufer sich wünscht,
        dass Nutzer eine Fehlermeldung angezeigt bekommen, wenn sie eine andere Taste als die Pfeiltasten drücken.
        Zum Beispiel etwas wie "Du hast die Taste <Hier Taste ausgeben> gedrückt. Du kannst die Schlange nur über die Pfeiltasten steuern."
        Wie könnte man das machen? Tipp: google "java switch default"
         */
        switch (head.getDir()){
            case RIGHT:
                head.setX(head.getX()+1);
                break;
            case DOWN:
                head.setY(head.getY()+1);
                break;
            case LEFT:
                head.setX(head.getX()-1);
                break;
            case UP:
                head.setY(head.getY()-1);
                break;
        }

    }

    // TODO wie nennt man so eine Methode?
    public static Point ptc(int x, int y){
        Point p = new Point(0,0);
        p.x = x*32 + Gui.xoff;
        p.y = y * 32 + Gui.yoff;
        return p;
    }

    public static void loadScore(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(load));
            bestscore = Integer.parseInt(br.readLine());
            Main.name2 = br.readLine();
            br.close();
        }catch (Exception e) {
        }
    }

    public static void saveScore(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(load));
            bw.write(""+bestscore);
            bw.newLine();
            bw.write(Main.name);
            bw.close();
        }catch(Exception e){
        }
    }
}
