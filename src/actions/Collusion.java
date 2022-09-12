package actions;

import game.Pickup;
import game.Snake;
import persistence.HighscoreDao;

public class Collusion {
    Pickup pickup = new Pickup();
    Snake addTail = new Snake();
    public boolean collideSelf(){
        for (int i = 0; i<Snake.tails.size(); i++){
            if (Snake.head.getX() == Snake.tails.get(i).getX() && Snake.head.getY() == Snake.tails.get(i).getY()
                    && !Snake.tails.get(i).isWait()){
                return true;
            }
        }
        return false;
    }

    public boolean collideWall(){
        return (Snake.head.getX()<0  ||Snake.head.getX() >15 ||Snake.head.getY()<0  ||Snake.head.getY() >15);
    }

    public void collidePickUp(){
        if (Snake.head.getX() == pickup.getX() && Snake.head.getY() == pickup.getY()){
            pickup.reset();
            addTail.addTail();
            Snake.score +=1;
            if (Snake.modus == 1){
                Snake.speed = Snake.speed - 5;
            }
            if (Snake.score == Snake.bestscore) {
                HighscoreDao namePlayer = new HighscoreDao();
                namePlayer.deleteHighscoreFromDatabase();
            }
            if(Snake.score > Snake.bestscore) {
                Snake.bestscore = Snake.score;

            }
        }
    }
}
