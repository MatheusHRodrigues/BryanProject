package org.academiadecodigo.bootcamp.bryanproject.entity.npc;


import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.EntityType;
import org.academiadecodigo.bootcamp.bryanproject.entity.player.Player;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;

public class Ogre extends Entity {

    Player player;

    public Ogre(int health, int maxHealth) {
        super(health, maxHealth,EntityType.OGRE);
        player = new Player(this);

    }

    @Override
    public void spawn(int x, int y, int size, Ground ground) {
        super.spawn(x -(size + 58), y -size, size, ground);
    }
}
