package org.academiadecodigo.bootcamp.bryanproject.entity.npc;


import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.EntityType;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;

public class Ogre extends Entity {

    public Ogre(int health, int maxHealth, int strength) {
        super(health, maxHealth, strength,EntityType.OGRE);
        super.addGraphicsRepresentation();

    }

    @Override
    public void spawn(int x, int y, int size, Ground ground) {
        super.spawn(x -(size + 58), y -size, size, ground);
    }
}
