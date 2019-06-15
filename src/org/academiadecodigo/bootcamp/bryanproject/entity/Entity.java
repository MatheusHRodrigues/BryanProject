package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.animation.AnimationType;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.bootcamp.bryanproject.world.World;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Entity {

    private EntityType entityType;
    private EntityManager entityManager;
    private HealthManage healthManage;
    private World world;
    private int size;

    public Entity(int health, int healthScale, EntityType entityType) {
        this.entityType = entityType;
        this.healthManage = new HealthManage(health, healthScale);
        this.entityManager = new EntityManager(this);
    }

    public void spawn(int x, int y, int size, Ground ground, World world) {
        this.world = world;
        this.size = size;
        this.entityManager.init(x, y, ground, size, new Picture(0, 0,
                "Game/Animations/Entity/" + entityType.getName() + "/idle/right-0.png"));

    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void hit(int damage) {
        this.getEntityManager().getMoves().setMoving(true);

        class Hit implements Runnable {

            private Entity entity;

            public Hit(Entity entity) {
                this.entity = entity;
            }

            @Override
            public void run() {
                entity.getEntityManager().getMoves().setMovingBlock(true);
                for (int i = 0; i < 5; i++) {
                    entityManager.getGraphics().getAnimation().runAnimation(entity, AnimationType.HURT);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Chance de da Break
                }
                entity.getEntityManager().getMoves().setMovingBlock(false);
                entity.getEntityManager().getMoves().setMoving(false);
            }

        }

        new Thread(new Hit(this)).start();

    }

    public boolean isAPlayer() {
        return false;
    }

    public World getWorld() {
        return world;
    }

    public boolean isDead() {
        return false;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "entityType = " + entityType.getName() +
                ", entityManager = " + entityManager +
                ", healthManage = " + healthManage +
                ", world = " + world +
                ", size = " + size +
                '}';
    }
}

