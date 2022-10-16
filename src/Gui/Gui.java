package Gui;

import clocks.GameClock;

public class Gui {
    public Menu menuFrame;
    public Game gameFrame;
    public Settings settingFrame;
    public GameClock gameClock;

    public void menuStart(){
            menuFrame = new Menu(this);
            if(gameFrame != null) {
                gameFrame.dispose();
                gameFrame = null;
            }
    }

    public void gameStart(int spielModus){
        gameClock = new GameClock(spielModus);
        if (gameFrame==null) {
            gameFrame = new Game(this, gameClock);
        }
        gameClock.start();
        gameFrame.setVisible(true);
    }
    public void settingStart(){
        settingFrame = new Settings(this);
    }
}
