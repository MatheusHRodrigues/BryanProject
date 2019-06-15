package org.academiadecodigo.bootcamp.bryanproject.game;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.Clip;

public class MainMenu extends Menu {

    private Picture picture;
    private Clip clip;
    private Keyboard keyboard;


    public MainMenu(Game game) {
        super(game);
        init();
    }

    public void init() {
        picture = new Picture(10, 10, "Resources/Game/Menu/startMenu.png");
        clip = getGame().getSound().startMusic();
        keyboard = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);
    }

    @Override
    public void start() {
        getGame().setDisplayable(this);
        super.create(picture, clip, keyboard);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (getGame().getDisplayable() instanceof MainMenu) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_SPACE:
                    getGame().getSound().stopMusic(getMusicClip());
                    getGame().init();
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
