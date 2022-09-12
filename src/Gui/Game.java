package Gui;

import actions.KeyHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private Gui gui;
    private JButton menuOberflaeche = new JButton("Menü");
    private GameArea gameArea = new GameArea();

    public Game(Gui gui) throws HeadlessException{
        super();
        this.gui = gui;
        init();
        initButtons();
        initGameArea();
    }
    private void init(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    private void initButtons(){
        menuOberflaeche.setBounds(655,125,50,10);
        this.add(menuOberflaeche);

        menuOberflaeche.addKeyListener(new KeyHandler());
        menuOberflaeche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.menuStart();
            }
        });
    }
    private void initGameArea(){
        gameArea.setBounds(0,0,800,600);
        gameArea.setVisible(true);
        this.add(gameArea);

    }
}

