package org.academiadecodigo.bootcamp.bryanproject.entity;

public class HealthManage {
    private int health;
    private int healthScale;

    public HealthManage(int health, int healthScale) {
        this.health = health;
        this.healthScale = healthScale;
    }

    public boolean tryMakeDamage(int damage) {
        if (health > damage) {
            health -= damage;
            return true;
        }
        return false;
    }
}
