package Gui;

import clocks.GameClock;

public class Gui {
    private Menu menuFrame;
    private Game gameFrame;
    private Settings settingFrame;
    private GameClock gameClock;

    public void menuStart(){
            this.menuFrame = new Menu(this);
            if(gameFrame != null) {
                gameFrame.dispose();
                gameFrame = null;
            }
    }

    public void gameStart(int gameMode){
        gameClock = new GameClock(gameMode);
        if (gameFrame==null) {
            gameFrame = new Game(this, gameClock);
        }
        gameClock.start();
        gameFrame.setVisible(true);
    }
    public void settingStart(){
        settingFrame = new Settings(this);
    }

    public Menu getMenuFrame() {
        return menuFrame;
    }

    public void setMenuFrame(Menu menuFrame) {
        this.menuFrame = menuFrame;
    }

    public Settings getSettingFrame() {
        return settingFrame;
    }

    public void setSettingFrame() {
        this.settingFrame = settingFrame;
    }

    public Game getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(Game gameFrame) {
        this.gameFrame = gameFrame;
    }

}
