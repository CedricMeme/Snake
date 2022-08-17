package actions;

// TODO normalerweise keine Absätze zwischen einzelnen import statements
import Gui.Gui;
import javax.swing.*;


public class Main {

public static String name;
// TODO Was bedeutet namee2? Für mich sagt der Name nicht viel aus. Vielleicht kannst du mir erklären, weshalb der Name doch sinnvoll ist oder dir einen besseren überlegen :)
public static String name2;

    public static void main(String[] args){
        Gui g = new Gui();
        g.createMenu();
    }

    public static void Name(){
        name = JOptionPane.showInputDialog(null, "Bitte Namen eingeben");
    }

}
