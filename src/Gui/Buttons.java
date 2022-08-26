package Gui;

import actions.KeyHandler;
import clocks.GameClock;
import game.Snake;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.Snake.SqlBedingung;
import static persistence.HighscoreDao.loadHighscoreFromDatabase;

public class Buttons {
    static JButton leicht = new JButton("Schwierigkeit: Leicht");
    static JButton mittel = new JButton("Schwierigkeit: Mittel");
    static JButton schwer = new JButton("Schwierigkeit: Schwer");
    static JButton modus = new JButton("Modus");
    public static JButton menuOberflaeche = new JButton("Menü");
    static GameClock gameClock = new GameClock();

    public static void buttonsPress(){
        leicht.setBounds(150,380,500,100);
        mittel.setBounds(150,260,500,100);
        schwer.setBounds(150,150,500,100);
        modus.setBounds(150,40,500,100);
        menuOberflaeche.setBounds(655,125,50,10);
        Gui.menuFrame.add(leicht);
        Gui.menuFrame.add(mittel);
        Gui.menuFrame.add(schwer);
        Gui.menuFrame.add(modus);

        leicht.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gui gui = new Gui();
                SqlBedingung = 1;
                if (Snake.startBedingung == 0){
                    gui.createGame();
                }else{
                    Gui.gameFrame.setVisible(true);
                    loadHighscoreFromDatabase();
                }
                Snake.speed = 200;
                if(Snake.startBedingung == 0){
                    gameClock.start();
                }
                Gui.menuFrame.setVisible(false);
            }
        });
        mittel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gui gui = new Gui();
                SqlBedingung = 2;
                if (Snake.startBedingung == 0){
                    gui.createGame();
                }else{
                    Gui.gameFrame.setVisible(true);
                    loadHighscoreFromDatabase();
                }
                Snake.speed = 150;
                if(Snake.startBedingung == 0){
                    gameClock.start();
                }
                Gui.menuFrame.setVisible(false);
            }
        });
        schwer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gui gui = new Gui();
                SqlBedingung = 3;
                if (Snake.startBedingung == 0){
                    gui.createGame();
                }else{
                    Gui.gameFrame.setVisible(true);
                    loadHighscoreFromDatabase();
                }
                Snake.speed = 100;
                if(Snake.startBedingung == 0){
                    gameClock.start();
                }
                Gui.menuFrame.setVisible(false);
            }
        });
        modus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gui gui = new Gui();
                SqlBedingung = 4;
                if (Snake.startBedingung == 0){
                    gui.createGame();
                }else{
                    Gui.gameFrame.setVisible(true);
                    loadHighscoreFromDatabase();
                }
                Snake.speed = 200;
                Snake.modus = 1;
                if(Snake.startBedingung == 0){
                    gameClock.start();
                }
                Gui.menuFrame.setVisible(false);
            }
        });
        menuOberflaeche.addKeyListener(new KeyHandler());
        menuOberflaeche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Snake.startBedingung = 1;
                Snake.oberflaecheBedingung = 1;
                Snake.modus = 0;
                Snake.load = null;
                Gui.gameFrame.setVisible(false);
                Gui.menuFrame.setVisible(true);
            }
        });
    }
}
