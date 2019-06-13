package org.academiadecodigo.bootcamp.bryanproject.world;

import org.academiadecodigo.bootcamp.bryanproject.entity.Bryan;
import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.npc.Ogre;
import org.academiadecodigo.bootcamp.bryanproject.game.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class OgreWorld extends World {

    ArrayList<Entity> worldEntity;

    public OgreWorld(Game game) {
        super(new Map("resources/Game/OgreWorld/map/Background.png", new Ground(928, 85)),game);
        worldEntity = new ArrayList<>();
        worldEntity.add(new Bryan(100, 100));
        worldEntity.add(new Ogre(100, 100));
    }


    public void init() {
        Picture picture = new Picture(getGame().getGrid().getX(), getGame().getGrid().getY(),getMap().getBackgroudPath());
        picture.draw();


        for (Entity entity : worldEntity) {
            if (entity instanceof Bryan) {
                entity.spawn(picture.getWidth() - getMap().getGround().getWidth(),
                        picture.getHeight() - getMap().getGround().getHeight(),
                        40, getMap().getGround());
            } else {
                entity.spawn(picture.getWidth(),
                        picture.getHeight() - getMap().getGround().getHeight(),
                        80,getMap().getGround());
            }
        }

    }


}
