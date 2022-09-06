package actions;

import Gui.Gui;
import Music.Music;
import javax.swing.*;
public class Main {
public static String nameSpieler;
public static String nameHighscoretraeger;

    public static void main(String[] args){
        Gui gui = new Gui();
        gui.menuStart();
        Music music = new Music();
        music.musicPlay();
    }

    public static void Name(){
        nameSpieler = JOptionPane.showInputDialog(null, "Bitte Namen eingeben");
    }

}
