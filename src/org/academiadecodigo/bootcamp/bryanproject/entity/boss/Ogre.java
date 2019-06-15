package org.academiadecodigo.bootcamp.bryanproject.entity.boss;


import org.academiadecodigo.bootcamp.bryanproject.entity.EntityType;
import org.academiadecodigo.bootcamp.bryanproject.entity.npc.NPC;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.bootcamp.bryanproject.world.World;

public class Ogre extends NPC {

    public Ogre(int health, int maxHealth) {
        super(health, maxHealth,EntityType.OGRE);

    }
    @Override
    public void spawn(int x, int y, int size, Ground ground, World world) {
        super.spawn(x -(size + 58), y -size, size, ground,world);
    }
}
