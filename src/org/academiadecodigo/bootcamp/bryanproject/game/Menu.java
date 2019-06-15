package org.academiadecodigo.bootcamp.bryanproject.game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.Clip;

/**
 * Created by codecadet on 14/06/2019.
 */
public abstract class Menu implements KeyboardHandler, Displayable {

    private Picture picture;
    private Keyboard keyboard;
    private Game game;
    private Clip musicClip;


    public Menu(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public Clip getMusicClip() {
        return musicClip;
    }

    public void create(Picture picture, Clip musicClip, Keyboard keyboard) {
        this.picture = picture;
        this.musicClip = musicClip;
        this.keyboard = keyboard;
        picture.draw();
    }

}
