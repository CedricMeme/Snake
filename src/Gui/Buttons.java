package Gui;

import actions.KeyHandler;
import clocks.GameClock;
import game.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons {

    static JButton leicht = new JButton("Schwierigkeit: Leicht");
    static JButton mittel = new JButton("Schwierigkeit: Mittel");
    static JButton schwer = new JButton("Schwierigkeit: Schwer");
    static JButton modus = new JButton("Modus");
    public static JButton menuOberfläche = new JButton("Menü");

    public static void buttonsPress(){
        leicht.setBounds(150,380,500,100);
        mittel.setBounds(150,260,500,100);
        schwer.setBounds(150,150,500,100);
        modus.setBounds(150,40,500,100);
        menuOberfläche.setBounds(655,125,50,10);
        Gui.menuFrame.add(leicht);
        Gui.menuFrame.add(mittel);
        Gui.menuFrame.add(schwer);
        Gui.menuFrame.add(modus);

        leicht.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gameClock = new GameClock();
                Gui gui = new Gui();
                Snake.load = "src/SaveFiles/SaveFile.txt";
                gui.createGame();
                Snake.speed = 200;
                gameClock.start();
                Gui.menuFrame.dispose();
            }
        });
        mittel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Gui gui = new Gui();
                Snake.load = "src/SaveFiles/SaveFile2.txt";
                gui.createGame();
                Snake.speed = 150;
                gc.start();
                Gui.menuFrame.dispose();
            }
        });
        schwer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Gui gui = new Gui();
                Snake.load = "src/SaveFiles/SaveFile3.txt";
                gui.createGame();
                Snake.speed = 100;
                gc.start();
                Gui.menuFrame.dispose();
            }
        });
        modus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Gui gui = new Gui();
                Snake.load = "src/SaveFiles/SaveFile4.txt";
                gui.createGame();
                Snake.speed = 200;
                Snake.modus = 1;
                gc.start();
                Gui.menuFrame.dispose();
            }
        });
        menuOberfläche.addKeyListener(new KeyHandler());
        menuOberfläche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gui gui = new Gui();
                Gui.gameFrame.dispose();
                gui.createMenu();

            }
        });
    }
}
