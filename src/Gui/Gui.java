package Gui;

import clocks.GameClock;

import javax.swing.*;

public class Gui {
    public Menu menuFrame;
    public Game gameFrame;
    public Settings settingFrame;
    public JLabel paintComponent = new JLabel();


    public void menuStart(){
        menuFrame = new Menu(this);
    }

    public void gameStart(){
        gameFrame = new Game(this);
        GameClock gameClock = new GameClock();
        gameClock.start();

    }
    public void settingStart(){
        settingFrame = new Settings(this);
    }
}
