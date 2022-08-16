package Gui;

import actions.KeyHandler;
import clocks.GameClock;
import game.Snake;
import Gui.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons {

    static JButton leicht = new JButton("Schwierigkeit: Leicht");
    static JButton mittel = new JButton("Schwirigkeit: Mittel");
    static JButton schwer = new JButton("Schwirigkeit: Schwer");
    static JButton modus = new JButton("Modus");
    static JButton menuob = new JButton("Menü");






    public static void buttonspress(){
        leicht.setBounds(150,380,500,100);
        mittel.setBounds(150,260,500,100);
        schwer.setBounds(150,150,500,100);
        modus.setBounds(150,40,500,100);
        menuob.setBounds(655,125,50,10);
        Gui.menuFrame.add(leicht);
        Gui.menuFrame.add(mittel);
        Gui.menuFrame.add(schwer);
        Gui.menuFrame.add(modus);


        leicht.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Gui gui = new Gui();
                Snake.load = "src/SaveFiles/SaveFile.txt";
                gui.create();
                Snake.s = 200;
                gc.start();
                Gui.menuFrame.dispose();


            }
        });
        mittel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Gui gui = new Gui();
                Snake.load = "src/SaveFiles/SaveFile2.txt";
                gui.create();
                Snake.s = 150;
                gc.start();
                Gui.menuFrame.dispose();


            }
        });
        schwer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Gui gui = new Gui();
                Snake.load = "src/SaveFiles/SaveFile3.txt";
                gui.create();
                Snake.s = 100;
                gc.start();
                Gui.menuFrame.dispose();

            }
        });
        modus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Gui gui = new Gui();
                Snake.load = "src/SaveFiles/SaveFile4.txt";
                gui.create();
                Snake.s = 200;
                Snake.modus = 1;
                gc.start();
                Gui.menuFrame.dispose();

            }
        });
        menuob.addKeyListener(new KeyHandler());
        menuob.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Gui gui = new Gui();
                Gui.gameFrame.dispose();

                gui.menu();


            }
        });

    }
}
