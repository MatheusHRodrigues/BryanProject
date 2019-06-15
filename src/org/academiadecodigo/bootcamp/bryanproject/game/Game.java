package org.academiadecodigo.bootcamp.bryanproject.game;

import org.academiadecodigo.bootcamp.bryanproject.music.Sound;
import org.academiadecodigo.bootcamp.bryanproject.world.OgreWorld;
import org.academiadecodigo.bootcamp.bryanproject.world.World;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int PADDING = 10;
    private Rectangle grid;
    private List<World> worlds = new ArrayList<>();
    private Menu menu;
    private Sound sound;
    private Displayable displayable;



    public Game() {
        sound = new Sound();
        menu = new MainMenu(this);
    }

    public void start() {
        menu.start();
    }

    public void init(){
        OgreWorld ogreWorld = new OgreWorld(this);
        worlds.add(ogreWorld);
        grid = new Rectangle(PADDING, PADDING, 928, 793);
        grid.draw();
        worlds.get(0).start();
    }


    public Rectangle getGrid() {
        return grid;
    }

    public Sound getSound() {
        return sound;
    }

    public Displayable getDisplayable() {
        return displayable;
    }

    public void setDisplayable(Displayable displayable) {
        this.displayable = displayable;
    }
}
