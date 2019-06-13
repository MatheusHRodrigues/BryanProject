package org.academiadecodigo.bootcamp.bryanproject.Music;

import javax.sound.sampled.*;
import java.io.File;

public class Sound {


    public static void music() {

        try {

            File clipFile = new File("./resources/Game/Music/BGsound.wav"); // path to your clip
            AudioInputStream audioStrmObj = AudioSystem.getAudioInputStream(clipFile);
            AudioFormat format = audioStrmObj.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStrmObj);
            audioClip.start();
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            System.out.println("NOT");
        }
    }
}
