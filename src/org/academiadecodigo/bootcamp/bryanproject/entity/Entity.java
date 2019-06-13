package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.animation.Animation;
import org.academiadecodigo.bootcamp.bryanproject.animation.AnimationDirection;
import org.academiadecodigo.bootcamp.bryanproject.animation.AnimationType;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.bootcamp.bryanproject.world.World;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public abstract class Entity {
    private HealthManage healthManage;
    private EntityPosition position;
    private Picture graphicsRep;
    private Rectangle hitbox;
    private Animation animation;
    private boolean jumping;
    private int size;
    private EntityType entityType;
    private World world;

    public Entity(int health, int healthScale, EntityType entityType) {
        this.entityType = entityType;
        healthManage = new HealthManage(health, healthScale);
    }

    public void spawn(int x, int y, int size, Ground ground, World world) {
        this.world = world;
        this.position = new EntityPosition(x, y, ground, size);
        this.size = size;
        addGraphicsRepresentation();
        addHitBox(x, y, graphicsRep.getWidth() - 30, graphicsRep.getHeight());
        init(x, y, size);
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void addGraphicsRepresentation() {
        graphicsRep = new Picture(0, 0,
                "Game/Animations/Entity/" + entityType.getName() + "/" + entityType.getName().toLowerCase() + "-idle-0.png");
    }

    private void addHitBox(int x, int y, int width, int height) {
        hitbox = new Rectangle(x, y, width, height);
    }

    public void init(int x, int y, int size) {
        graphicsRep.translate(x, y);
        graphicsRep.grow(size, size);
        graphicsRep.draw();
        hitbox.grow(size, size);
        hitbox.draw();
        animation = new Animation();
    }

    public Picture getGraphicsRep() {
        return graphicsRep;
    }

    public void moveForward(int distance) {
        int oldX = position.getX();

        if (oldX + distance <= position.getGround().getWidth() - size * 2) {
            position.moveRight(distance);
            graphicsRep.translate(position.getX() - oldX, 0);
            hitbox.translate(position.getX() - oldX, 0);
            animation.runAnimation(this, AnimationType.WALK, AnimationDirection.RIGHT);
        }
    }

    public void moveBackwards(int distance) {
        int oldX = position.getX();
        if ((oldX - distance) >= 10) {
            position.moveLeft(distance);
            graphicsRep.translate(position.getX() - oldX, 0);
            hitbox.translate(position.getX() - oldX, 0);
            animation.runAnimation(this, AnimationType.WALK, AnimationDirection.LEFT);
        }
    }

    public void jump() {
        if (!jumping) {
            jumping = true;
            int oldY = position.getY();
            position.moveUp(graphicsRep.getHeight());
            graphicsRep.translate(0, position.getY() - oldY);
            hitbox.translate(0, position.getY() - oldY);
            animation.runAnimation(this, AnimationType.JUMP);
            try {
                Thread.sleep(180);
                jumping = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            oldY = position.getY();
            position.moveDown(graphicsRep.getHeight());
            graphicsRep.translate(0, position.getY() - oldY);
            hitbox.translate(0, position.getY() - oldY);
            animation.runAnimation(this, AnimationType.IDLE);
        }
    } //TROCAR MOVIMENTOS POR INTERFACE

    public boolean hitable(int x, int y, int h, int w) {
        int xReverse = x + w;
        int yReverse = Math.abs(h - y);
        int xThis = this.hitbox.getX();
        int yThis = this.hitbox.getY();
        int xReverseThis = this.hitbox.getX() + this.hitbox.getWidth();
        int yReverseThis = Math.abs(this.hitbox.getHeight() - this.hitbox.getY());

        if (x > xReverseThis || xThis > xReverse ) {
            return false;
        }
        return y >= yReverseThis && yThis >= yReverse;
    }

    public void attack() {
        List<Entity> entities = world.getEntities();
        for (Entity en : entities) {
            if (en.hashCode() != this.hashCode()) {
                en.hitable(hitbox.getX(), hitbox.getY(), hitbox.getHeight(), hitbox.getWidth());
                en.hit(10);
            }
        }
    }

    public void hit(int damage) {
        System.out.println("ATAQUE");
        animation.runAnimation(this, AnimationType.JUMP);

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

    public Rectangle getHitbox() {
        return hitbox;
    }
}

