package org.academiadecodigo.bootcamp.bryanproject.entity.player;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class KeyboardFactory {

    public static void create(Keyboard keyboard) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_RIGHT);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);

        KeyboardEvent event1 = new KeyboardEvent();
        event1.setKey(KeyboardEvent.KEY_LEFT);
        event1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event1);

        KeyboardEvent event2 = new KeyboardEvent();
        event2.setKey(KeyboardEvent.KEY_UP);
        event2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event2);

        KeyboardEvent event3 = new KeyboardEvent();
        event3.setKey(KeyboardEvent.KEY_Z);
        event3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event3);

    }
}
