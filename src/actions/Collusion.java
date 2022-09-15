package actions;

import clocks.GameClock;
import game.Pickup;
import game.Snake;
import persistence.HighscoreDao;

public class Collusion {
    private final Pickup pickup = new Pickup();
    private  final Snake snake = new Snake();
    private final GameClock gameClock;
    public int score = 0;
    //public int bestscore = 0;

    // TODO
    // ist hier der Spielmodul (also leicht, mittel, schwer) gemeint?
    public int modus = 0;

    public Collusion(GameClock gameClock) {
        this.gameClock = gameClock;
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
            if (modus == 1){
               gameClock.speed = gameClock.speed - 5;
            }
            /*if (score == bestscore) {
                // TODO welcher Score soll gelöscht werden?
                HighscoreDao.deleteHighscoreFromDatabase(modus, bestscore);

            if(score > bestscore) {
                bestscore = score;
            }}*/
        }
    }
}
