package Gui;

import clocks.GameClock;
import game.Snake;
import persistence.HighscoreDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
     private Gui gui;
     private JButton leicht = new JButton("Schwierigkeit: Leicht");
     private JButton mittel = new JButton("Schwierigkeit: Mittel");
     private JButton schwer = new JButton("Schwierigkeit: Schwer");
     private JButton modus = new JButton("Modus");
     private JButton settings = new JButton("Settings");

    public Menu(Gui gui) throws HeadlessException {
        super();
        this.gui = gui;
        init();
        initButtons();
    }
    private void init(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    private void initButtons(){
        leicht.setBounds(150,310,500,100);
        mittel.setBounds(150,210,500,100);
        schwer.setBounds(150,110,500,100);
        modus.setBounds(150,10,500,100);
        settings.setBounds(150,410,500,100);
        this.add(leicht);
        this.add(mittel);
        this.add(schwer);
        this.add(modus);
        this.add(settings);

        leicht.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Snake.speed = 200;
                Snake.spielModus = 1;

                gui.gameStart();
                gui.menuFrame.dispose();
            }
        });
        mittel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Snake.speed = 150;
                Snake.spielModus = 2;
                GameClock gameClock = new GameClock();
                gameClock.running = true;

                gui.gameStart();
                gui.menuFrame.dispose();
            }
        });
        schwer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Snake.speed = 100;
                Snake.spielModus = 3;

                gui.gameStart();
                gui.menuFrame.dispose();
            }
        });
        modus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Snake.speed = 200;
                Snake.spielModus = 4;
                Snake.move = 0;

                gui.gameStart();
                gui.menuFrame.dispose();
            }
        });
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.settingStart();
                gui.menuFrame.dispose();
            }
        });
    }
}


