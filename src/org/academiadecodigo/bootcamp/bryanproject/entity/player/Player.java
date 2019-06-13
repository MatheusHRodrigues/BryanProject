package org.academiadecodigo.bootcamp.bryanproject.entity.player;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public final class Player implements KeyboardHandler {

    Keyboard keyboard;
    Entity entity;

    public Player(Entity entity) {
        keyboard = new Keyboard(this);
        KeyboardFactory.create(keyboard);
        this.entity = entity;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                entity.moveForward(10);
                break;
            case KeyboardEvent.KEY_LEFT:
                entity.moveBackwards(10);
                break;
            case KeyboardEvent.KEY_UP:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        entity.jump();
                    }
                }).start();

            case KeyboardEvent.KEY_Z:
                entity.attack();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // idle

    }
}
