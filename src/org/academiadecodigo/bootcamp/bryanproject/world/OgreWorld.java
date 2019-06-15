package org.academiadecodigo.bootcamp.bryanproject.world;

import org.academiadecodigo.bootcamp.bryanproject.Music.Sound;
import org.academiadecodigo.bootcamp.bryanproject.entity.Bryan;
import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.npc.Ogre;
import org.academiadecodigo.bootcamp.bryanproject.game.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;


public class OgreWorld extends World {

    private List<Entity> entities = new ArrayList<>();

    public OgreWorld(Game game) {
        super(new Map("resources/Game/OgreWorld/map/Background.png", new Ground(928, 85)),game);
    }


    public void init() {
        super.addPicture(new Picture(super.getGame().getGrid().getX(),super.getGame().getGrid().getY(), super.getMap().getBackgroudPath()));
        super.getPicture().draw();
        generateEntitys();
        for (Entity entity : entities) {
            if (entity instanceof Bryan) {
                entity.spawn(super.getPicture().getWidth() - getMap().getGround().getWidth(),
                        super.getPicture().getHeight() - getMap().getGround().getHeight() ,
                        40, getMap().getGround(),this);
            } else {
                entity.spawn(super.getPicture().getWidth(),
                        super.getPicture().getHeight() - getMap().getGround().getHeight(),
                        80,getMap().getGround(),this);
            }
        }

    }

    public List<Entity> getEntities() {
        return entities;
    }

    private void generateEntitys() {
        entities.add(new Ogre(100, 100));
        entities.add(new Bryan(100, 100));
    }


}
