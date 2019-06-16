package org.academiadecodigo.bootcamp.bryanproject.music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Audio {

    private String path;
    private Clip clip;

    public Audio(String path) {
        this.path = path;
    }

    public void runAudio() {
        try {
            ClassLoader classLoader = Audio.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(path);
            clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            clip.open(ais);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void stopAudio() {
        clip.close();
    }
}
