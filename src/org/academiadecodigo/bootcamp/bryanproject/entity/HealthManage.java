package org.academiadecodigo.bootcamp.bryanproject.entity;

public class HealthManage {
    private int health;
    private int healthScale;
    private boolean dead;
    private Entity entity;
    //CHANCE DE BLOQUEAR ATAQUE E CONSEGUIR ATACAR

    public HealthManage(int health, int healthScale,Entity entity) {
        this.health = health;
        this.healthScale = healthScale;
        this.entity = entity;
    }

    public boolean tryMakeDamage(int damage) {
        if (health > -1) {
            health -= damage;
            return true;
        }
        return false;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        if (dead = true) {
            entity.getEntityManager().getMoves().setMovingBlock(true);
            entity.getEntityManager().getMoves().setMoving(true);
        }
        this.dead = dead;
    }

    public int getHealth() {
        return health;
    }
}
