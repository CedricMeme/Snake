package Gui;

import javax.swing.*;
import java.awt.*;

public class Gui {


    //JFrame menuFrame;
    public static JFrame menuFrame = new JFrame();
    public static JFrame gameFrame = new JFrame();
    JButton menuob;

    Draw d;
    Menu m;
    public static int width = 800, height = 600;
    public static int xoff = 130, yoff=20;
    /*JButton leicht = new JButton("Schwierigkeit: Leicht");
    JButton mittel = new JButton("Schwirigkeit: Mittel");
    JButton schwer = new JButton("Schwirigkeit: Schwer");
    JButton modus = new JButton("Modus");
    JButton menuob = new JButton("Menü");*/


    public void menu(){
        Buttons buttons = new Buttons();
        buttons.buttonspress();
        menuFrame.setSize(width,height);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setLayout(null);
        menuFrame.setResizable(false);
        m = new Menu();
        m.setBounds(0,0,width,height);
        m.setVisible(true);
        menuFrame.add(m);
        menuFrame.requestFocus();
        menuFrame.setVisible(true);

    }
    /*public void buttons(){
        leicht.setBounds(150,380,500,100);
        mittel.setBounds(150,260,500,100);
        schwer.setBounds(150,150,500,100);
        modus.setBounds(150,40,500,100);
        menuob.setBounds(655,125,50,10);
        menuFrame.add(leicht);
        menuFrame.add(mittel);
        menuFrame.add(schwer);
        menuFrame.add(modus);

        leicht.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Snake.load = "src/SaveFiles/SaveFile.txt";
                create();
                Snake.s = 200;
                gc.start();
                leicht.remove(leicht);
                menuFrame.dispose();


            }
        });
        mittel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Snake.load = "src/SaveFiles/SaveFile2.txt";
                create();
                Snake.s = 150;
                gc.start();
                menuFrame.dispose();


            }
        });
        schwer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Snake.load = "src/SaveFiles/SaveFile3.txt";
                create();
                Snake.s = 100;
                gc.start();
                menuFrame.dispose();

            }
        });
        modus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameClock gc = new GameClock();
                Snake.load = "src/SaveFiles/SaveFile4.txt";
                create();
                Snake.s = 200;
                Snake.modus = 1;
                gc.start();
                menuFrame.dispose();

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

    }*/

    public void create(){
        gameFrame.setSize(width,height);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setLayout(null);
        gameFrame.setResizable(false);
        gameFrame.add(menuob);

        d = new Draw();
        d.setBounds(0,0,width,height);
        d.setVisible(true);
        gameFrame.add(d);
        gameFrame.requestFocus();
        gameFrame.setVisible(true);
    }

}
