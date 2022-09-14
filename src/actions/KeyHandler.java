package actions;

import clocks.GameClock;
import game.Dir;
import game.Snake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener {

    public boolean waitToMove = false;
    private final GameClock gameClock = new GameClock();
    private final Snake snake = new Snake();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (!(snake.head.getDir() == Dir.DOWN) && !waitToMove) {
                    gameClock.moveDir =0;
                    snake.head.setDir(Dir.UP);
                    waitToMove = true;
                }
            case KeyEvent.VK_LEFT:
                if (!(snake.head.getDir() == Dir.RIGHT) && !waitToMove) {
                    gameClock.moveDir =0;
                    snake.head.setDir(Dir.LEFT);
                    waitToMove = true;
                }
            case KeyEvent.VK_DOWN:
                if (!(snake.head.getDir() == Dir.UP) && waitToMove) {
                    gameClock.moveDir =0;
                    snake.head.setDir(Dir.DOWN);
                    waitToMove = true;
                }
            case KeyEvent.VK_RIGHT:
                if (!(snake.head.getDir() == Dir.LEFT) && !waitToMove) {
                    gameClock.moveDir =0;
                    snake.head.setDir(Dir.RIGHT);
                    waitToMove = true;
                }
            case KeyEvent.VK_P:
                if (!waitToMove) {
                    gameClock.moveDir = 1;
                    waitToMove = false;
                }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
