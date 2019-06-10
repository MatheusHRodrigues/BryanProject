package org.academiadecodigo.bootcamp.bryanproject.entity.player;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.Entitys;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;

public class Player extends Entity implements Playable {

    public Player(int health, int maxHealth, int strength) {
        super(health, maxHealth, strength);
        super.addGraphicsRepresentation(Entitys.BRYAN);
    }


    @Override
    public void spawn(int x, int y, int size, Ground ground) {
        super.spawn(x + size, y - size, size, ground);
    }
}
