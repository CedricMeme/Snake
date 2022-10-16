package actions;

import Gui.Gui;
import Music.Music;
public class Main {

    public static void main(String[] args){
        Gui gui = new Gui();
        gui.menuStart();
        Music music = new Music();
        music.musicPlay();
    }
}
