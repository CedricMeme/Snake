package Gui;

import javax.swing.*;
import static Gui.Buttons.buttonsPress;
import static Gui.Buttons.menuOberflaeche;

public class Gui {

    public static JFrame menuFrame = new JFrame();
    public static JFrame gameFrame = new JFrame();

    Draw gameStil;
    Menu menuStil;
    public static int width = 800, height = 600;
    public static int xoff = 130, yoff=20;

    public void createMenu(){
        buttonsPress();
        menuFrame.setSize(width,height);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setLayout(null);
        menuFrame.setResizable(false);
        menuStil = new Menu();
        menuStil.setBounds(0,0,width,height);
        menuStil.setVisible(true);
        menuFrame.add(menuStil);
        menuFrame.requestFocus();
        menuFrame.setVisible(true);
    }

    public void createGame(){
        gameFrame.setSize(width,height);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setLayout(null);
        gameFrame.setResizable(false);
        gameFrame.add(menuOberflaeche);
        gameStil = new Draw();
        gameStil.setBounds(0,0,width,height);
        gameStil.setVisible(true);
        gameFrame.add(gameStil);
        gameFrame.requestFocus();
        gameFrame.setVisible(true);
    }
}
