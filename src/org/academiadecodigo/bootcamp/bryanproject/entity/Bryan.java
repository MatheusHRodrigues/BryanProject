package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.entity.player.Player;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;

public class Bryan extends Entity {

    Player player;

    public Bryan(int health, int maxHealth, int strength) {
        super(health, maxHealth, strength,EntityType.BRYAN);
        super.addGraphicsRepresentation();
    }


    @Override
    public void spawn(int x, int y, int size, Ground ground) {
        super.spawn(x + size, y - size, size, ground);
        player = new Player(this);
    }


}
