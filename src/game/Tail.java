package game;

public class Tail {

    // TODO gleiche Aufgabe wie in Gui, Head und Pickup
    int x, y;
    boolean wait = true;

    // Wie nennt man diese Methode?
    public Tail(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }
}
