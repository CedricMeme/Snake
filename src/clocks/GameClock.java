package clocks;

import actions.Collusion;
import actions.KeyHandler;
import game.Snake;
import persistence.HighscoreDao;
import persistence.HighscoreData;

public class GameClock extends Thread{
    public boolean running = true;
    private final Collusion collusion;
    private HighscoreDao namePlayer = new HighscoreDao();
    private final Snake snake = new Snake();
    private final KeyHandler keyHandler;
    private HighscoreData highscoreData;
    private int spielModus;
    public int speed = 0;
    public int moveDir = 0;
    private int highscore = 0;
    private String highscoreName;

    public GameClock(int spielModus){
        this.spielModus = spielModus;
        this.highscoreData = HighscoreDao.loadHighscoreFromDatabase(spielModus);
        this.collusion = new Collusion(this);
        this.keyHandler = new KeyHandler(this);
        if (spielModus == 1){
            this.speed = 200;
        }else if(spielModus == 2){
            this.speed = 150;
        }else if(spielModus == 3){
            this.speed = 100;
        }else if(spielModus == 4){
            this.speed = 200;
        }
    }

    public void run(){
        while(running){
            try {
                keyHandler.waitToMove = false;
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
                if(collusion.collideSelf()) {
                    if (highscoreData == null && collusion.score != 0 && collusion.score > highscore){
                        namePlayer.namePlayer(spielModus,collusion.score);
                        highscore = collusion.score;
                        highscoreName = namePlayer.getNameHighscoretraeger();
                    } else if (collusion.score >= highscore && collusion.score != 0) {
                        HighscoreDao.deleteHighscoreFromDatabase(highscoreData.getScore(), spielModus);
                        namePlayer.namePlayer(spielModus,collusion.score);
                        highscore = collusion.score;
                        highscoreName = namePlayer.getNameHighscoretraeger();
                    }
                    snake.tails.clear();
                    collusion.score = 0;
                    if (spielModus == 4){
                        speed = 200;
                    }
                }
                if (collusion.collideWall()){
                    if(highscoreData == null && collusion.score != 0 && collusion.score > highscore){
                        namePlayer.namePlayer(spielModus,collusion.score);
                        highscore = collusion.score;
                        highscoreName = namePlayer.getNameHighscoretraeger();
                    } else if (collusion.score >= highscore && collusion.score != 0) {
                        HighscoreDao.deleteHighscoreFromDatabase(highscoreData.getScore(), spielModus);
                        namePlayer.namePlayer(spielModus,collusion.score);
                        highscore = collusion.score;
                        highscoreName = namePlayer.getNameHighscoretraeger();
                    }
                    snake.tails.clear();
                    snake.head.setX(7);
                    snake.head.setY(7);
                    collusion.score = 0;
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

    public void setSpeed(int speed) {
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

    public int getSpielModus() {
        return spielModus;
    }

    public void setSpielModus(int spielModus) {
        this.spielModus = spielModus;
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
