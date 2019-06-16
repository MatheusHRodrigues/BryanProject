package org.academiadecodigo.bootcamp.bryanproject.game;

import org.academiadecodigo.bootcamp.bryanproject.world.OgreWorld;
import org.academiadecodigo.bootcamp.bryanproject.world.World;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int PADDING = 10;
    private Rectangle grid;
    private List<World> worlds = new ArrayList<>();
    private Menu menu;
    private Displayable displayable;
    private Picture rectangle2;



    public Game() {
        menu = new MainMenu(this);
        rectangle2 = new Picture(0, 0,"Game/Animations/Entity/Bryan/idle/right-0.png");
        rectangle2.grow(80,80);
    }

    public Picture getRectangle2() {
        return rectangle2;
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

    public Displayable getDisplayable() {
        return displayable;
    }

    public void setDisplayable(Displayable displayable) {
        this.displayable = displayable;
    }
}
