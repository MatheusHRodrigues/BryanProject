
package org.academiadecodigo.bootcamp.bryanproject.Music;

import javax.sound.sampled.*;
import java.io.File;

public class Sound {

    public Clip startMusic() {
            try {

                File clipFile = new File("./resources/Game/Music/startsong.wav"); // path to your clip
                AudioInputStream audioStrmObj = AudioSystem.getAudioInputStream(clipFile);
                AudioFormat format = audioStrmObj.getFormat();
                Clip audioClip = AudioSystem.getClip();
                audioClip.open(audioStrmObj);
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);

                return audioClip;
            } catch (Exception ex) {
                System.out.println("NOT");
            }
            return null;
        }


    public Clip gameMusic() {

        try {

            File clipFile = new File("./resources/Game/Music/BGsound.wav"); // path to your clip
            AudioInputStream audioStrmObj = AudioSystem.getAudioInputStream(clipFile);
            AudioFormat format = audioStrmObj.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStrmObj);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);

            return audioClip;
        } catch (Exception ex) {
            System.out.println("NOT");
            return null;
        }
    }


    public Clip finalMusic() {

        try {

            File clipFile = new File("./resources/Game/Music/gameover.wav"); // path to your clip
            AudioInputStream audioStrmObj = AudioSystem.getAudioInputStream(clipFile);
            AudioFormat format = audioStrmObj.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStrmObj);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);

            return audioClip;
        } catch (Exception ex) {
            System.out.println("NOT");
            return null;
        }

    }
    public void stopMusic(Clip audioClip) {
        audioClip.stop();
        audioClip.close();
    }

}
