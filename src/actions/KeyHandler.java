package actions;

import clocks.GameClock;
import game.Dir;
import game.Snake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean waitToMove = false;
    private  final GameClock gameClock;
    private final Snake snake;

    public KeyHandler(GameClock  gameClock) {
        this.gameClock = gameClock;
        this.snake = gameClock.getSnake();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (!(snake.head.getDir() == Dir.DOWN) && !this.isWaitToMove()) {
                    gameClock.setMoveDir(0);
                    snake.head.setDir(Dir.UP);
                    this.setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!(snake.head.getDir() == Dir.RIGHT) && !this.isWaitToMove()) {
                    gameClock.setMoveDir(0);
                    snake.head.setDir(Dir.LEFT);
                    this.setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!(snake.head.getDir() == Dir.UP) && !this.isWaitToMove()) {
                    gameClock.setMoveDir(0);
                    snake.head.setDir(Dir.DOWN);
                    this.setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!(snake.head.getDir() == Dir.LEFT) && !this.isWaitToMove()) {
                    gameClock.setMoveDir(0);
                    snake.head.setDir(Dir.RIGHT);
                    this.setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_P:
                if (!this.isWaitToMove()) {
                    gameClock.setMoveDir(1);
                    this.setWaitToMove(false);
                }
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public boolean isWaitToMove() {
        return waitToMove;
    }

    public void setWaitToMove(boolean b) {
        this.waitToMove = waitToMove;
    }
}
