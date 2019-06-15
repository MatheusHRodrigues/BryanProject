package org.academiadecodigo.bootcamp.bryanproject.game;
import org.academiadecodigo.bootcamp.bryanproject.entity.player.KeyboardFactory;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.Clip;

/**
 * Created by codecadet on 14/06/2019.
 */
public class Menu implements KeyboardHandler{

    private Picture startPic;
    private Picture overPic;
    private Keyboard keyboard;
    private Game game;
    private Clip musicClip;

    public Menu(Game game) {

        startPic = new Picture(10,10,"Resources/Game/Menu/startMenu.png");
        startPic.draw();
        musicClip = game.getSound().startMusic();
        keyboard = new Keyboard(this);
        KeyboardFactory.create(keyboard);

        this.game = game;

    }

    public void gameOver() {

        game.getSound().stopMusic(musicClip);
        overPic = new Picture(10 ,10 ,"Resources/Game/Menu/gameOver.png" );
        overPic.draw();
        game.getSound().finalMusic();

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                game.getSound().stopMusic(musicClip);
                game.init();
                musicClip = game.getSound().gameMusic();
                break;
            case KeyboardEvent.KEY_Q:
                gameOver();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
