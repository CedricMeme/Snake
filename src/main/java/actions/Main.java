package actions;

import Gui.Gui;
import Music.Music;
public class Main {

    public static void main(String[] args){
        Gui gui = new Gui();
        gui.menuStart();
        Music music = new Music();
        music.musicPlay();

        // Check if game should run with or without database
        if(args[0] == "Database") {
            // Game should run with database mode
        }
        if(args.length == 0) {
            // Game will use a text file to save high scores
        }

    }
}
