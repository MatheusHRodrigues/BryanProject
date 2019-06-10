package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.bootcamp.bryanproject.world.Position;

public class EntityPosition extends Position {

    private Ground ground;

    public EntityPosition(int x, int y, Ground ground) {
        super(x, y);
        this.ground = ground;
    }
}
