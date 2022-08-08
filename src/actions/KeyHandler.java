package actions;

import clocks.GameClock;
import game.Dir;
import game.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static clocks.GameClock.running;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                if(!(Snake.head.getDir() == Dir.DOWN) && !Snake.waitToMove){
                    Snake.head.setDir(Dir.UP);
                    Snake.waitToMove = true;
                }else{
                    running= true;
                }
            case KeyEvent.VK_LEFT:
                if(!(Snake.head.getDir() == Dir.RIGHT) && !Snake.waitToMove){
                    Snake.head.setDir(Dir.LEFT);
                    Snake.waitToMove = true;
                }
            case KeyEvent.VK_DOWN:
                if(!(Snake.head.getDir() == Dir.UP) && !Snake.waitToMove){
                    Snake.head.setDir(Dir.DOWN);
                    Snake.waitToMove = true;
                }
            //Rechts
            case KeyEvent.VK_RIGHT:
                if(!(Snake.head.getDir() == Dir.LEFT) && !Snake.waitToMove){
                    Snake.head.setDir(Dir.RIGHT);
                    Snake.waitToMove = true;
                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
