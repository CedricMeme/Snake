package actions;

import clocks.GameClock;
import game.Pickup;
import game.Snake;

public class Collusion {
    private final Pickup pickup = new Pickup();
    private Snake snake;
    private GameClock gameClock;
    public int score = 0;

    public Collusion(GameClock gameClock){
        this.gameClock = gameClock;
        this.snake = gameClock.getSnake();
    }

    public boolean collideSelf(){
        for (int i = 0; i<snake.tails.size(); i++){
            if (snake.head.getX() == snake.tails.get(i).getX() && snake.head.getY() == snake.tails.get(i).getY()
                    && !snake.tails.get(i).isWait()){
                return true;
            }
        }
        return false;
    }

    public boolean collideWall(){
        return (snake.head.getX()<0  ||snake.head.getX() >15 ||snake.head.getY()<0  ||snake.head.getY() >15);
    }

    public void collidePickUp(){
        if (snake.head.getX() == pickup.getX() && snake.head.getY() == pickup.getY()){
            pickup.reset();
            snake.addTail();
            score +=1;
            if (gameClock.getSpielModus() ==4){
               gameClock.speed = gameClock.speed - 5;
            }
        }
    }

    public Pickup getPickup() {
        return pickup;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
