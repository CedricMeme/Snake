package Gui;

import actions.KeyHandler;
import actions.Main;
import clocks.GameClock;
import game.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    JFrame jf;
    JFrame jff;
    Draw d;
    menu m;
    public static int width = 800, height = 600;
    public static int xoff = 130, yoff=20;
    JButton button = new JButton("Schwierigkeit: Leicht");
    JButton button2 = new JButton("Schwirigkeit: Mittel");
    JButton button3 = new JButton("Schwirigkeit: Schwer");
    JButton button4 = new JButton("Modus");
    JButton button5 = new JButton("Menü");


    public void menu(){
        jf = new JFrame();
        jf.setSize(width,height);
        buttons();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setResizable(false);
        m = new menu();
        m.setBounds(0,0,width,height);
        m.setVisible(true);
        jf.add(m);

        jf.requestFocus();
        jf.setVisible(true);


    }
    public void buttons(){
        button.setBounds(150,380,500,100);
        button2.setBounds(150,260,500,100);
        button3.setBounds(150,150,500,100);
        button4.setBounds(150,40,500,100);
        button5.setBounds(655,125,50,10);
        jf.add(button);
        jf.add(button2);
        jf.add(button3);
        jf.add(button4);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Main.Name();
                create();
                Snake.s = 200;
                gc.start();


            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Main.Name();
                create();
                Snake.s = 150;
                gc.start();

            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Main.Name();
                create();
                Snake.s = 100;
                gc.start();

            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Main.Name();
                create();
                Snake.s = 200;
                Snake.modus = 1;
                gc.start();

            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                menu();

            }
        });


    }


    public void create(){
        jff = new JFrame();

        jff.setSize(width,height);
        jff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jff.setLocationRelativeTo(null);
        jff.setLayout(null);
        jff.setResizable(false);

        jff.addKeyListener(new KeyHandler());
        jff.add(button5);

        d = new Draw();
        d.setBounds(0,0,width,height);
        d.setVisible(true);
        jff.add(d);

        jff.requestFocus();
        jff.setVisible(true);
    }

}
