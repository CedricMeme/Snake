package actions;

import Gui.Gui;
import Music.Music;
public class Main {

    public static void main(String[] args){
        // Check if game should run with or without database
        if(args != null && args[0] == "database") {
            // Game will use a text file to save high scores
            // Do something..
        } else {
            // Game should run with database mode
            // Do something...
        }

        Gui gui = new Gui();
        gui.menuStart();
        Music music = new Music();
        music.musicPlay();
    }
}
