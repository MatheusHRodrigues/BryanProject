package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.world.Position;

public abstract class Entity {
    private int health;
    private int maxHealth;
    private int strength;
    private Position position;

    public Entity(int health, int maxHealth, int strength) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
    }

    public void jump() {

    }

    public void moveLeft() {

    }

    public void moveRight() {

    }

}
