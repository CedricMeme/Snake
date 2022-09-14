package clocks;

import Gui.Menu;
import actions.Collusion;
import actions.KeyHandler;
import game.Snake;
import persistence.HighscoreDao;

public class GameClock extends Thread{
    public boolean running = true;
    private final Collusion collusion = new Collusion();
    private final HighscoreDao namePlayer = new HighscoreDao();
    private final Snake snake = new Snake();
    private final KeyHandler keyHandler = new KeyHandler();
    private final Menu menu = new Menu();
    public int speed = 0;
    public int moveDir = 0;

    public GameClock(int spielModus){
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
        while(running == true){
            try {
                keyHandler.waitToMove = false;
                sleep(speed);
                if (moveDir == 0){
                    snake.move();
                }
                collusion.collidePickUp();
                if(collusion.collideSelf()) {
                    if(collusion.score >= collusion.bestscore && collusion.score != 0) {
                        namePlayer.namePlayer();
                        namePlayer.deleteHighscoreFromDatabase();
                        namePlayer.saveHighscoreToDatabase();
                    }
                    snake.tails.clear();
                    collusion.score = 0;
                    if (menu.spielModus == 4){
                        speed = 200;
                    }
                }
                if (collusion.collideWall()){
                    if(collusion.score >= collusion.bestscore && collusion.score != 0) {
                        namePlayer.namePlayer();
                        namePlayer.deleteHighscoreFromDatabase();
                        namePlayer.saveHighscoreToDatabase(menu);
                    }
                    snake.tails.clear();
                    snake.head.setX(7);
                    snake.head.setY(7);
                    collusion.score = 0;
                    if (menu.spielModus == 4){
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

    public Menu getMenu() {
        return menu;
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
}
