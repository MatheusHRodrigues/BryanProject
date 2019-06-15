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

        KeyboardEvent event_re = new KeyboardEvent();
        event_re.setKey(KeyboardEvent.KEY_RIGHT);
        event_re.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event_re);


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

        KeyboardEvent event1_re = new KeyboardEvent();
        event1_re.setKey(KeyboardEvent.KEY_LEFT);
        event1_re.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event1_re);


        KeyboardEvent event2_re = new KeyboardEvent();
        event2_re.setKey(KeyboardEvent.KEY_UP);
        event2_re.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event2_re);


        KeyboardEvent event3_re = new KeyboardEvent();
        event3_re.setKey(KeyboardEvent.KEY_Z);
        event3_re.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event3_re);

    }
}
