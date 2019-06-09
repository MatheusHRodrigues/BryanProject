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


    public Game() {
        worlds.add(new OgreWorld());
        grid = new Rectangle(PADDING, PADDING, 928, 793);
        grid.draw();
    }

    public void init() {
        Picture picture = new Picture(PADDING, PADDING, worlds.get(0).getMap().getBgLocation());
        picture.draw();
    }


}
