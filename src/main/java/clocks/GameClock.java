package clocks;

import actions.Collusion;
import actions.KeyHandler;
import game.Snake;
import persistence.HighscoreDao;
import persistence.HighscoreData;
import actions.Main;

public class GameClock extends Thread{
    private boolean running = true;
    private final Collusion collusion;
    private HighscoreDao namePlayer = new HighscoreDao();
    private final Snake snake = new Snake();
    private final KeyHandler keyHandler;
    private HighscoreData highscoreData;

    private int gameModus;
    private int speed = 0;
    private int moveDir = 0;
    private int highscore = 0;
    private String highscoreName;

    public GameClock(int gameModus){
        this.gameModus = gameModus;
        

            this.highscoreData = HighscoreDao.loadHighscoreFromDatabase(gameModus);

        this.collusion = new Collusion(this);
        this.keyHandler = new KeyHandler(this);
        if (gameModus == 1){
            this.speed = 200;
        }else if(gameModus == 2){
            this.speed = 150;
        }else if(gameModus == 3){
            this.speed = 100;
        }else if(gameModus == 4){
            this.speed = 200;
        }
    }

    public void run(){
        while(running){
            try {
                keyHandler.setWaitToMove(false);
                sleep(speed);
                if (highscoreData == null & highscore == 0){
                    highscore = 0;
                } else if(highscoreData != null){
                    highscore = highscoreData.getScore();
                }
                if (moveDir == 0){
                    snake.move();
                }
                collusion.collidePickUp();
                if(collusion.collideSelf() || (collusion.collideWall())) {
                    if ((highscoreData == null) & (collusion.getScore() != 0) & (collusion.getScore() > highscore)){
                        namePlayer.namePlayer(gameModus,collusion.getScore());
                        highscore = collusion.getScore();
                        highscoreName = namePlayer.getNameHighscoretraeger();
                    } else if (collusion.getScore() >= highscore && collusion.getScore() != 0) {
                        HighscoreDao.deleteHighscoreFromDatabase(highscoreData.getScore(), gameModus);
                        namePlayer.namePlayer(gameModus,collusion.getScore());
                        highscore = collusion.getScore();
                        highscoreName = namePlayer.getNameHighscoretraeger();
                    }
                    snake.tails.clear();
                    snake.head.setX(7);
                    snake.head.setY(7);
                    collusion.setScore(0);
                    if (gameModus == 4){
                        speed = 200;
                    }
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Collusion getCollusion() {
        return collusion;
    }

    public HighscoreDao getNamePlayer() {
        return namePlayer;
    }

    public Snake getSnake() {
        return snake;
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int i) {
        this.speed = speed;
    }

    public int getMoveDir() {
        return moveDir;
    }

    public void setMoveDir(int moveDir) {
        this.moveDir = moveDir;
    }

    public HighscoreData getHighscoreData() {
        return highscoreData;
    }

    public void setHighscoreData(HighscoreData highscoreData) {
        this.highscoreData = highscoreData;
    }

    public int getGameModus() {
        return gameModus;
    }

    public void setGameModus(int gameModus) {
        this.gameModus = gameModus;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public void setNamePlayer(HighscoreDao namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getHighscoreName() {
        return highscoreName;
    }

    public void setHighscoreName(String highscoreName) {
        this.highscoreName = highscoreName;
    }

}
