package Gui;

import javax.swing.*;
import static Gui.Buttons.menuOberfläche; // TODO zwischen einzelnen import statements keine Absätze

public class Gui {

    public static JFrame menuFrame = new JFrame();
    public static JFrame gameFrame = new JFrame(); // TODO kein Absatz
    /* TODO zu den Variablen gameStil und menuStil:
        lies dir mal bitte durch was "access modifier" bzw. "Sichtbarkeitsmodifizierer" in Java sind.
        Ich sage schon mal so viel, dass du für gameStil und menuStil keinen access modifier definiert hast.
        Informier dich mal, was in so einem Fall passiert :)
    */
    Draw gameStil;
    Menu menuStil;
    public static int width = 800, height = 600;
    public static int xoff = 130, yoff=20;

    public void createMenu(){
        Buttons buttons = new Buttons();
        /*TODO
        Hover mal mit deinem Mauszeiger über die Zeile 29 "buttons.buttonsPress();"
        IntelliJ zeigt dir dann einen Hinweis an, der ganz nützlich ist
        Finde bitte mal heraus, was mit dem Hinweis gemeint ist und ob er für dich von Bedeutung ist
        Es geht um statische bzw. nichtstatische Methoden (hatten wir schon mal angerissen)
        -> Hier kannst du dein theoretisches Wissen anwenden
         */
        buttons.buttonsPress();
        menuFrame.setSize(width,height);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setLayout(null);
        menuFrame.setResizable(false);
        menuStil = new Menu();
        menuStil.setBounds(0,0,width,height);
        menuStil.setVisible(true);
        menuFrame.add(menuStil);
        menuFrame.requestFocus();
        menuFrame.setVisible(true);
    }

    public void createGame(){
        gameFrame.setSize(width,height);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setLayout(null);
        gameFrame.setResizable(false);
        gameFrame.add(menuOberfläche);
        gameStil = new Draw();
        gameStil.setBounds(0,0,width,height);
        gameStil.setVisible(true);
        gameFrame.add(gameStil);
        gameFrame.requestFocus();
        gameFrame.setVisible(true);
    }
}
