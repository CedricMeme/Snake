package actions;

import Gui.Gui;
import Music.Music;
import persistence.HighscoreDao;
import persistence.HighscoreData;

import java.util.Objects;

public class Main {

    public static void main(String[] args){
        // Check if game should run with or without database
        if(/*args != null && */Objects.equals(args[0], "Database")) {
            HighscoreData highscoreData = new HighscoreData();
            highscoreData.setDatabase(1);
        }

        Gui gui = new Gui();
        gui.menuStart();
        Music music = new Music();
        music.musicPlay();

    }
}
