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
        // Gameclock angepasst für laden des scores
        gameClock = new GameClock(spielModus, menuFrame);
        gameClock.start();

        if (gameFrame==null) {
            gameFrame = new Game(this, gameClock);
        }
    }
    public void settingStart(){
        settingFrame = new Settings(this);
    }
}
