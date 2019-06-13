package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.entity.player.Player;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;

public class Bryan extends Entity {

    Player player;

    public Bryan(int health, int maxHealth) {
        super(health, maxHealth,EntityType.BRYAN);
    }


    @Override
    public void spawn(int x, int y, int size, Ground ground) {
        super.spawn(x + size, y - size, size, ground);
        player = new Player(this);
    }


}
