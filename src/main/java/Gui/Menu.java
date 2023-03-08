package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
     private final Gui gui;
     private boolean menuRunning;
     private final JButton easy = new JButton("Easy");
     private final JButton medium = new JButton("Medium");
     private final JButton hard = new JButton("Hard");
     private final JButton speedup = new JButton("Speed Up");
     private final JButton settings = new JButton("Settings");

     public Menu(Gui gui) throws HeadlessException {
        super();
        this.gui = gui;
        init();
        initButtons();
        menuRunning = true;
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
        easy.setBounds(150,310,500,100);
        medium.setBounds(150,210,500,100);
        hard.setBounds(150,110,500,100);
        speedup.setBounds(150,10,500,100);
        settings.setBounds(150,410,500,100);
        this.add(easy);
        this.add(medium);
        this.add(hard);
        this.add(speedup);
        this.add(settings);

        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.gameStart(1);
                dispose();
            }
        });
        medium.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                gui.gameStart(2);
                dispose();
            }
        });
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.gameStart(3);
                dispose();
            }
        });
        speedup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.gameStart(4);
                dispose();

            }
        });
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.settingStart();

                dispose();
            }
        });
    }
}


