package org.academiadecodigo.bootcamp.bryanproject.game;

import org.academiadecodigo.bootcamp.bryanproject.music.Audio;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 14/06/2019.
 */
public abstract class Menu implements KeyboardHandler, Displayable {

    private Picture picture;
    private Keyboard keyboard;
    private Game game;
    private Audio audio;


    public Menu(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public Audio getAudio() {
        return audio;
    }

    public void create(Picture picture, Audio audio, Keyboard keyboard) {
        this.picture = picture;
        this.audio = audio;
        this.keyboard = keyboard;
        audio.runAudio();
        picture.draw();
        getGame().setDisplayable(this);
    }

}
