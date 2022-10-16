package game;

import java.awt.*;
import java.util.ArrayList;

public class Snake extends Component {
    public Head head = new Head(7, -7);
    public ArrayList<Tail> tails = new ArrayList<>();

    public void addTail() {
        if (tails.size() < 1) {
            tails.add(new Tail(head.getX(), head.getY()));
        } else {
            tails.add(new Tail(tails.get(tails.size() - 1).x, tails.get(tails.size() - 1).y));
        }
    }

    public void move() {
        if (tails.size() >= 2) {
            for (int i = tails.size() - 1; i >= 1; i--) {
                if (tails.get(i).isWait()) {
                    tails.get(i).setWait(false);
                } else {
                    tails.get(i).setX(tails.get(i - 1).getX());
                    tails.get(i).setY(tails.get(i - 1).getY());
                }
            }
        }

        if (tails.size() >= 1) {
            if (tails.get(0).isWait()) {
                tails.get(0).setWait(false);
            } else {
                tails.get(0).setX(head.getX());
                tails.get(0).setY(head.getY());
            }
        }

        switch (head.getDir()) {
            case RIGHT:
                head.setX(head.getX() + 1);
                break;
            case DOWN:
                head.setY(head.getY() + 1);
                break;
            case LEFT:
                head.setX(head.getX() - 1);
                break;
            case UP:
                head.setY(head.getY() - 1);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public Point ptc(int x, int y) {
        Point p = new Point(0, 0);
        p.x = x * 32 + 120;
        p.y = y * 32 + 20;
        return p;
    }
}
