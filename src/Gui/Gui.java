package Gui;

import clocks.GameClock;

import javax.swing.*;

public class Gui {
    public Menu menuFrame;
    public Game gameFrame;
    public Settings settingFrame;
    public GameClock gameClock;
    public void menuStart(){
            menuFrame = new Menu(this);
            gameFrame.dispose();
            gameFrame = null;
    }

    public void gameStart(){
        if (gameClock==null) {
            gameClock = new GameClock();
            gameClock.start();
        }
        if (gameFrame==null) {
            gameFrame = new Game(this);
        }
    }
    public void settingStart(){
        settingFrame = new Settings(this);
    }
}
