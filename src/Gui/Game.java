package Gui;

import clocks.GameClock;
import persistence.HighscoreData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private final Gui gui;
    private final JButton menuArea = new JButton("Menü");
    private final GameArea gameArea;
    private GameClock gameClock;

    public Game(Gui gui, GameClock gameClock) throws HeadlessException{
        super();
        HighscoreData highscoreData = gameClock.getHighscoreData();
        this.gui = gui;
        this.gameClock = gameClock;
        this.gameArea = new GameArea(gameClock, highscoreData);
        init();
        initButtons();
        initGameArea();
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
        menuArea.setBounds(655,125,50,10);
        this.add(menuArea);
        menuArea.addKeyListener(gameClock.getKeyHandler());
        menuArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.menuStart();
            }
        });
    }
    private void initGameArea(){
        gameArea.setBounds(0,0,800,600);
        gameArea.setVisible(true);
        this.add(gameArea);
    }
}

