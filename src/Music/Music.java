package Music;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

import static javax.sound.sampled.Clip.LOOP_CONTINUOUSLY;

public class Music {
    private Clip clip;
    public static FloatControl fc;
    public float currentVolume = -38;
    public void musicPlay(){
        File music = new File("src/Music/music.wav");
        while(true){
                    try {
                        clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream(new File(music.toURI())));
                        fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                        fc.setValue(currentVolume);
                        clip.loop(LOOP_CONTINUOUSLY);
                        Thread.sleep(clip.getMicrosecondLength()/1000);
                    }catch (Exception e){
                    }



        }

    }
}
