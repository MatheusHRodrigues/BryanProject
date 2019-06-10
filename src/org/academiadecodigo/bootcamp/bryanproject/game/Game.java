package org.academiadecodigo.bootcamp.bryanproject.game;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.npc.Ogre;
import org.academiadecodigo.bootcamp.bryanproject.entity.player.Player;
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

    public void init() throws InterruptedException {
        Picture picture = new Picture(grid.getX(), grid.getY(), worlds.get(0).getMap().getBackgroudPath());
        picture.draw();
        Entity bryan = new Player(100, 100, 10);
        bryan.spawn(picture.getWidth() - worlds.get(0).getMap().getGround().getWidth(),
                picture.getHeight() - worlds.get(0).getMap().getGround().getHeight(),
                40, worlds.get(0).getMap().getGround());

        Entity ogre = new Ogre(100, 100, 60);
        ogre.spawn(picture.getWidth(),
                picture.getHeight() - worlds.get(0).getMap().getGround().getHeight(),
                80,
                worlds.get(0).getMap().getGround());
        int delay = 2000;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(delay);
            bryan.moveForward(1);
            Thread.sleep(10);
            bryan.moveForward(1);
            Thread.sleep(300);
            bryan.moveBackwards(1);
            Thread.sleep(300);
        }

    }

}
