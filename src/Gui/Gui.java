package Gui;

import actions.KeyHandler;
import clocks.GameClock;
import game.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    JFrame mo;
    JFrame go;
    Draw d;
    menu m;
    public static int width = 800, height = 600;
    public static int xoff = 130, yoff=20;
    JButton leicht = new JButton("Schwierigkeit: Leicht");
    JButton mittel = new JButton("Schwirigkeit: Mittel");
    JButton schwer = new JButton("Schwirigkeit: Schwer");
    JButton modus = new JButton("Modus");
    JButton menuob = new JButton("Menü");


    public void menu(){
        mo = new JFrame();
        mo.setSize(width,height);
        buttons();
        mo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mo.setLocationRelativeTo(null);
        mo.setLayout(null);
        mo.setResizable(false);
        m = new menu();
        m.setBounds(0,0,width,height);
        m.setVisible(true);
        mo.add(m);
        mo.requestFocus();
        mo.setVisible(true);

    }
    public void buttons(){
        leicht.setBounds(150,380,500,100);
        mittel.setBounds(150,260,500,100);
        schwer.setBounds(150,150,500,100);
        modus.setBounds(150,40,500,100);
        menuob.setBounds(655,125,50,10);
        mo.add(leicht);
        mo.add(mittel);
        mo.add(schwer);
        mo.add(modus);

        leicht.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Snake.load = "src/game/SaveFile.txt";
                create();
                Snake.s = 200;
                gc.start();
                mo.dispose();

            }
        });
        mittel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Snake.load = "src/game/SaveFile2.txt";
                create();
                Snake.s = 150;
                gc.start();
                mo.dispose();


            }
        });
        schwer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Snake.load = "src/game/SaveFile3.txt";
                create();
                Snake.s = 100;
                gc.start();
                mo.dispose();

            }
        });
        modus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Snake.load = "src/gameSaveFile4.txt";
                create();
                Snake.s = 200;
                Snake.modus = 1;
                gc.start();
                mo.dispose();

            }
        });
        menuob.addKeyListener(new KeyHandler());
        menuob.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                //Snake.s = 0;
                //gc.stop();
                go.dispose();
                menu();


            }
        });

    }

    public void create(){
        go = new JFrame();
        go.setSize(width,height);
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setLocationRelativeTo(null);
        go.setLayout(null);
        go.setResizable(false);
        //jff.addKeyListener(new KeyHandler());
        go.add(menuob);

        d = new Draw();
        d.setBounds(0,0,width,height);
        d.setVisible(true);
        go.add(d);
        go.requestFocus();
        go.setVisible(true);
    }

}
