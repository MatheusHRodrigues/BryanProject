package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Entity {
    private int health;
    private int maxHealth;
    private int strength;
    private EntityPosition position;
    private int size;
    private Picture graphicsRep;

    public Entity(int health, int maxHealth, int strength) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
    }

    public void spawn(int x, int y, int size, Ground ground, Picture picture) {
        this.position = new EntityPosition(x, y, ground);
        this.graphicsRep = picture;
        this.size = size;
        graphicsRep.grow(size, size);
        graphicsRep.draw();
    }

    public int getSize() {
        return size;
    }
}
