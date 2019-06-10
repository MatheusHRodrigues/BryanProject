package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Entity {
    private HealthManage healthManage;
    private EntityPosition position;
    private Picture graphicsRep;
    private int strength;
    private int size;

    public Entity(int health, int healthScale, int strength) {
        healthManage = new HealthManage(health, healthScale);
        this.strength = strength;
    }

    public void spawn(int x, int y, int size, Ground ground) {
        this.position = new EntityPosition(x, y, ground,size);
        this.size = size;
        graphicsRep.translate(x ,y);
        graphicsRep.grow(size, size);
        graphicsRep.draw();
    }

    public void addGraphicsRepresentation(Entitys entity) {
        graphicsRep = new Picture(0, 0,
                "Game/Animations/Entity/" + entity.getName() + "/" + entity.getName().toLowerCase() + "-idle-00.png");
    }

    public int getSize() {
        return size;
    }

    public void hit(int damage) {
        healthManage.tryMakeDamage(damage);
    }

    public void moveForward(int distance) {
        position.moveRight(distance);
    }

    public void moveBackwards(int distance) {
        position.moveLeft(distance);
    }


}
