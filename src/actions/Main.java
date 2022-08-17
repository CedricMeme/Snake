package actions;


import Gui.Gui;


import javax.swing.*;

public class Main {

public static String name;
public static String name2;

    public static void main(String[] args){
        Gui g = new Gui();
        g.createMenu();
    }

    public static void Name(){
        name = JOptionPane.showInputDialog(null, "Bitte Namen eingeben");
    }

}
