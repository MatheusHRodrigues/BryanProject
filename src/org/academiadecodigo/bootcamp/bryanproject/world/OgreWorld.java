package org.academiadecodigo.bootcamp.bryanproject.world;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.boss.Ogre;
import org.academiadecodigo.bootcamp.bryanproject.entity.heros.Bryan;
import org.academiadecodigo.bootcamp.bryanproject.entity.npc.NPC;
import org.academiadecodigo.bootcamp.bryanproject.game.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class OgreWorld extends World {

    public OgreWorld(Game game) {
        super(new Map("resources/Game/OgreWorld/map/Background.png", new Ground(928, 85)),game);
    }

    private void generateEntitys() {
        Ogre ogre = new Ogre(100, 100);
        new Thread(ogre).start();
        super.getEntities().add(ogre);
        Bryan bryan = new Bryan(100, 100);
        new Thread(bryan).start();
        super.getEntities().add(bryan);
    }

    private void npcLife() {
        for (Entity entity :  super.getEntities()) {
            if (!entity.isAPlayer() && entity instanceof NPC) {
                NPC npc = (NPC) entity;
                System.out.println(npc);
                npc.start();
            }
        }
    }

    @Override
    public void start() {
        getGame().setDisplayable(this);
        super.addPicture(new Picture(super.getGame().getGrid().getX(),super.getGame().getGrid().getY(), super.getMap().getBackgroudPath()));
        super.getPicture().draw();
        getGame().getSound().gameMusic();
        generateEntitys();
        for (Entity entity :  super.getEntities()) {
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
        npcLife();
    }
}
