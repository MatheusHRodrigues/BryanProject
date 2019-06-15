package org.academiadecodigo.bootcamp.bryanproject.game;

import org.academiadecodigo.bootcamp.bryanproject.Music.Sound;
import org.academiadecodigo.bootcamp.bryanproject.entity.player.KeyboardFactory;
import org.academiadecodigo.bootcamp.bryanproject.world.OgreWorld;
import org.academiadecodigo.bootcamp.bryanproject.world.World;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int PADDING = 10;
    private Rectangle grid;
    private List<World> worlds = new ArrayList<>();
    private Menu menu;
    private Sound sound;



    public Game() {
        sound = new Sound();
        menu = new Menu(this);
        OgreWorld ogreWorld = new OgreWorld(this);
        worlds.add(ogreWorld);
        grid = new Rectangle(PADDING, PADDING, 928, 793);
        grid.draw();

    }

    public void init(){
        System.out.println(worlds.toString());
        worlds.get(0).init();

    }

    public Rectangle getGrid() {
        return grid;
    }

    public Sound getSound() {
        return sound;
    }
}
