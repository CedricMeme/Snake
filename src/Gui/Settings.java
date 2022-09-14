package Gui;

import Music.Music;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private final Gui gui;
    private final JButton menuOberflaeche = new JButton("Menü");
    private JTextField eingabeUp, eingabeDown, eingabeLeft, eingabeRight;
    private JLabel down, up, left, right, textKeychanger, volumeChanger;
    private  final JSlider slider = new JSlider();

    public Settings(Gui gui) throws HeadlessException {
        super();
        this.gui = gui;
        init();
        initButtons();
        initSlider();
    }
    private void init(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);

        textKeychanger = new JLabel("Keychanger");
        textKeychanger.setBounds(350,10,300,50);
        this.add(textKeychanger);

        volumeChanger = new JLabel("Volume");
        volumeChanger.setBounds(350,270,300,50);
        this.add(volumeChanger);

        up = new JLabel("UP");
        up.setBounds(150,60,50,50);
        this.add(up);

        down = new JLabel("DOWN");
        down.setBounds(150,110,50,50);
        this.add(down);

        left = new JLabel("LEFT");
        left.setBounds(150,160,50,50);
        this.add(left);

        right = new JLabel("RIGHT");
        right.setBounds(150,210,50,50);
        this.add(right);

        eingabeUp = new JTextField();
        eingabeUp.setBounds(300,60,300,50);
        this.add(eingabeUp);

        eingabeDown = new JTextField();
        eingabeDown.setBounds(300,110,300,50);
        this.add(eingabeDown);

        eingabeLeft = new JTextField();
        eingabeLeft.setBounds(300,160,300,50);
        this.add(eingabeLeft);

        eingabeRight = new JTextField();
        eingabeRight.setBounds(300,210,300,50);
        this.add(eingabeRight);
        this.setVisible(true);
    }
    private void initButtons(){
        menuOberflaeche.setBounds(655,125,50,10);
        this.add(menuOberflaeche);

        menuOberflaeche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.settingFrame.dispose();
                gui.menuStart();
            }
        });
    }
    private void initSlider(){
        slider = new JSlider(-80,6);
        slider.setBounds(250,300, 300,50);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Music music = new Music();
                music.currentVolume = slider.getValue();
                music.fc.setValue(music.currentVolume);
            }
        });
        this.add(slider);
    }
}
