package actions;

import Gui.Gui;
import Music.Music;
import persistence.HighscoreDao;
import persistence.HighscoreData;

public class Main {

    public static void main(String[] args){
        // Check if game should run with or without database
        if(args != null && args[0] == "database") {
            HighscoreData highscoreData = new HighscoreData();
            highscoreData.setDatabase(String.valueOf(1));
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
