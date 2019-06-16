package org.academiadecodigo.bootcamp.bryanproject.game;

import org.academiadecodigo.bootcamp.bryanproject.music.Audio;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainMenu extends Menu {

    private Picture picture;
    private Audio audio;
    private Keyboard keyboard;


    public MainMenu(Game game) {
        super(game);
        init();
    }

    public void init() {
        picture = new Picture(10, 10, "Game/Menu/startMenu.png");
        keyboard = new Keyboard(this);
        audio = new Audio("Game/Music/startsong.wav");
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);
    }

    @Override
    public void start() {
        super.create(picture, audio, keyboard);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (getGame().getDisplayable() instanceof MainMenu) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_SPACE:
                    getGame().init();
                    getAudio().stopAudio();
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
