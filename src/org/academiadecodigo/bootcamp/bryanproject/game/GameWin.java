package org.academiadecodigo.bootcamp.bryanproject.game;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.Clip;

public class GameWin extends Menu {
    private Picture picture;
    private Clip clip;
    private Keyboard keyboard;

    public GameWin(Game game) {
        super(game);
        init();
    }

    public void init() {
        picture = new Picture(10, 10, "Game/Menu/winscreen.png");
        clip = getGame().getSound().startMusic();
        keyboard = new Keyboard(this);/*
        KeyboardEvent event7 = new KeyboardEvent();
        event7.setKey(KeyboardEvent.KEY_Q);
        event7.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event7);*/
    }

    @Override
    public void start() {
        super.create(picture,clip,keyboard);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
