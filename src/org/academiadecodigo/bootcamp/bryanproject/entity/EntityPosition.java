package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.bootcamp.bryanproject.world.Position;

public class EntityPosition extends Position {

    private Ground ground;


    public EntityPosition(int x, int y, Ground ground,int size) {
        super(x, y, x - size, y + size);
        this.ground = ground;
    }

    public void moveUp(int distance) {
        super.setY(super.getY() - distance);
    }

    public void moveDown(int distance) {
        super.setY(super.getY() + distance);
    }

    public void moveRight(int distance) {
        super.setX(super.getX() + distance);
    }

    public void moveLeft(int distance) {
        super.setX(super.getX() - distance);
    }

    public Ground getGround() {
        return ground;
    }
}
