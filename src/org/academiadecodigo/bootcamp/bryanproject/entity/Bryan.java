package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.entity.player.Player;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.bootcamp.bryanproject.world.World;

public class Bryan extends Entity {

    private Player player;

    public Bryan(int health, int maxHealth) {
        super(health, maxHealth,EntityType.BRYAN);
    }


    @Override
    public void spawn(int x, int y, int size, Ground ground, World world) {
        super.spawn(x + size, y - size, size, ground,world);
        player = new Player(this);
    }

    @Override
    public boolean isAPlayer() {
        return true;
    }
}
