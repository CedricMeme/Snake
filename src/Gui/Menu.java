package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
     private final Gui gui;
     private final JButton leicht = new JButton("Schwierigkeit: Leicht");
     private final JButton mittel = new JButton("Schwierigkeit: Mittel");
     private final JButton schwer = new JButton("Schwierigkeit: Schwer");
     private final JButton modus = new JButton("Modus");
     private final JButton settings = new JButton("Settings");
     public int spielModus =0;

     public Menu(Gui gui) throws HeadlessException {
        super();
        this.gui = gui;
        init();
        initButtons();
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
        leicht.setBounds(150,310,500,100);
        mittel.setBounds(150,210,500,100);
        schwer.setBounds(150,110,500,100);
        modus.setBounds(150,10,500,100);
        settings.setBounds(150,410,500,100);
        this.add(leicht);
        this.add(mittel);
        this.add(schwer);
        this.add(modus);
        this.add(settings);

        leicht.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spielModus = 1;
                gui.gameStart(spielModus);
                gui.menuFrame.dispose();
            }
        });
        mittel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spielModus = 2;
                gui.gameStart(spielModus);
                gui.menuFrame.dispose();
            }
        });
        schwer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spielModus = 3;
                gui.gameStart(spielModus);
                gui.menuFrame.dispose();
            }
        });
        modus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spielModus = 4;
                gui.gameStart(spielModus);
                gui.menuFrame.dispose();
            }
        });
        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.settingStart();
                gui.menuFrame.dispose();
            }
        });
    }
}


