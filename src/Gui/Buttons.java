package Gui;

import actions.KeyHandler;
import clocks.GameClock;
import game.Snake;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static game.Snake.*;
import static persistence.HighscoreDao.loadHighscoreFromDatabase;

public class Buttons {
    Gui gui = new Gui();
    static JButton leicht = new JButton("Schwierigkeit: Leicht");
    static JButton mittel = new JButton("Schwierigkeit: Mittel");
    static JButton schwer = new JButton("Schwierigkeit: Schwer");
    static JButton modus = new JButton("Modus");
    public static JButton settings = new JButton("Settings");
    public static JButton menuOberflaeche = new JButton("Menü");


    public static  JButton saveSettings = new JButton("Save");
    //static GameClock gameClock = new GameClock();

    /*public static void buttonsPress(){
        leicht.setBounds(150,310,500,100);
        mittel.setBounds(150,210,500,100);
        schwer.setBounds(150,110,500,100);
        modus.setBounds(150,10,500,100);
        menuOberflaeche.setBounds(655,125,50,10);
        settings.setBounds(150,410,500,100);
        gui.menuFrame.add(leicht);
        Gui.menuFrame.add(mittel);
        Gui.menuFrame.add(schwer);
        Gui.menuFrame.add(modus);
        Gui.menuFrame.add(settings);

        leicht.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spielModus = 1;
                if (Snake.startBedingung == 0){
                    gui.createGame();
                    loadHighscoreFromDatabase();
                }else{
                    Gui.gameFrame.setVisible(true);
                    loadHighscoreFromDatabase();
                }
                Snake.speed = 200;
                if(Snake.startBedingung == 0){
                    gameClock.start();
                    Snake.startBedingung = 1;
                }
                Gui.menuFrame.setVisible(false);
            }
        });
        mittel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spielModus = 2;
                if (Snake.startBedingung == 0){
                    gui.createGame();
                    loadHighscoreFromDatabase();
                }else{
                    Gui.gameFrame.setVisible(true);
                    loadHighscoreFromDatabase();
                }
                Snake.speed = 150;
                if(Snake.startBedingung == 0){
                    gameClock.start();
                    Snake.startBedingung = 1;
                }
                Gui.menuFrame.setVisible(false);
                menuOberflaeche.setVisible(true);
            }
        });
        schwer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gui gui = new Gui();
                spielModus = 3;
                if (Snake.startBedingung == 0){
                    gui.createGame();
                    loadHighscoreFromDatabase();
                }else{
                    Gui.gameFrame.setVisible(true);
                    loadHighscoreFromDatabase();
                }
                Snake.speed = 100;
                if(Snake.startBedingung == 0){
                    gameClock.start();
                    Snake.startBedingung = 1;
                }
                Gui.menuFrame.setVisible(false);
            }
        });
        modus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spielModus = 4;
                if (Snake.startBedingung == 0){
                    gui.createGame();
                    loadHighscoreFromDatabase();
                }else{
                    Gui.gameFrame.setVisible(true);
                    loadHighscoreFromDatabase();
                }
                Snake.speed = 200;
                Snake.modus = 1;
                if(Snake.startBedingung == 0){
                    gameClock.start();
                    Snake.startBedingung = 1;
                }
                Gui.menuFrame.setVisible(false);
            }
        });
        menuOberflaeche.addKeyListener(new KeyHandler());
        menuOberflaeche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Snake.oberflaecheBedingung = 1;
                Snake.modus = 0;
                Snake.load = null;
                Gui.gameFrame.setVisible(false);
                Gui.settingFrame.setVisible(false);
                Gui.menuFrame.setVisible(true);
            }
        });
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Gui.menuFrame.setVisible(false);
              if (settingStartbedingung ==0){
                  gui.createSettings();
                  settingStartbedingung = 1;
              }else{
                  Gui.settingFrame.setVisible(true);
              }
            }
        });
        saveSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }*/
}
