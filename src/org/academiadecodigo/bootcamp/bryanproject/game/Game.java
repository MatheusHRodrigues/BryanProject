package org.academiadecodigo.bootcamp.bryanproject.game;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.world.OgreWorld;
import org.academiadecodigo.bootcamp.bryanproject.world.World;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private final int PADDING = 10;
    private Rectangle grid;
    private List<World> worlds = new ArrayList<>();
    public static HashMap<World, List<Entity>> worldListHashMap = new HashMap<>();


    public Game() {
        OgreWorld ogreWorld = new OgreWorld(this);
        worlds.add(ogreWorld);
        worldListHashMap.put(ogreWorld,new ArrayList<Entity>());
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

}
