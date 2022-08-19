package actions;

import Gui.Gui;
import javax.swing.*;
public class Main {
public static String nameSpieler;
public static String nameHighscoretraeger;

    public static void main(String[] args){
        Gui g = new Gui();
        g.createMenu();
    }

    public static void Name(){
        nameSpieler = JOptionPane.showInputDialog(null, "Bitte Namen eingeben");
    }

}
