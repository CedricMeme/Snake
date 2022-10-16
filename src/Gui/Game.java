package Gui;

import actions.KeyHandler;
import clocks.GameClock;
import persistence.HighscoreData;
import persistence.HighscoreDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private final Gui gui;
    private final JButton menuOberflaeche = new JButton("Menü");
    private final GameArea gameArea;
    private GameClock gameClock;

    public Game(Gui gui, GameClock gameClock) throws HeadlessException{
        super();
        HighscoreData highscoreData = gameClock.getHighscoreData(); // = HighscoreDao.loadHighscoreFromDatabase(gameClock.getMenu().spielModus);
        this.gui = gui;
        this.gameClock = gameClock;
        this.gameArea = new GameArea(gameClock, highscoreData);

        init();
        initButtons();
        initGameArea(gameClock);

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
        menuOberflaeche.setBounds(655,125,50,10);
        this.add(menuOberflaeche);
        menuOberflaeche.addKeyListener(gameClock.getKeyHandler());
        menuOberflaeche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.menuStart();
            }
        });
    }
    private void initGameArea(GameClock gameClock){
        gameArea.setBounds(0,0,800,600);
        gameArea.setVisible(true);
        this.add(gameArea);
    }
}

