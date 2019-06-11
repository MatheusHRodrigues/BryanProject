package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.animation.Animation;
import org.academiadecodigo.bootcamp.bryanproject.animation.AnimationType;
import org.academiadecodigo.bootcamp.bryanproject.game.Game;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Timer;

public abstract class Entity {
    private HealthManage healthManage;
    private EntityPosition position;
    private Picture graphicsRep;
    private Animation animation;
    private EntityType entityType;
    private int strength;
    private int size;

    public Entity(int health, int healthScale, int strength,EntityType entityType) {
        this.entityType = entityType;
        healthManage = new HealthManage(health, healthScale);
        this.strength = strength;
    }

    public void spawn(int x, int y, int size, Ground ground) {
        this.position = new EntityPosition(x, y, ground,size);
        this.size = size;
        graphicsRep.translate(x ,y);
        graphicsRep.grow(size, size);
        graphicsRep.draw();
        animation = new Animation();
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void addGraphicsRepresentation() {
        graphicsRep = new Picture(0, 0,
                "Game/Animations/Entity/" + entityType.getName() + "/" + entityType.getName().toLowerCase() + "-idle-00.png");
    }

    public int getSize() {
        return size;
    }

    public void hit(int damage) {
        healthManage.tryMakeDamage(damage);
    }

    public Picture getGraphicsRep() {
        return graphicsRep;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setGraphicsRep(Picture graphicsRep) {
        this.graphicsRep = graphicsRep;
    }

    public void moveForward(int distance) {
        int oldX = position.getX();

        if (oldX + distance <= position.getGround().getWidth() - size * 2) {
            position.moveRight(distance);
            graphicsRep.translate(position.getX() - oldX, 0);
            animation.runAnimation(this, AnimationType.RUN);
        }
    }

    public void moveBackwards(int distance) {
        int oldX = position.getX();
        if((oldX - distance) >= 10) {
            position.moveLeft(distance);
            graphicsRep.translate(position.getX() - oldX, 0);
            animation.runAnimation(this, AnimationType.RUN);
        }
    }

    public void jump() throws InterruptedException {
        int oldY = position.getY();
        position.moveUp(graphicsRep.getHeight());
        graphicsRep.translate(0,position.getY() - oldY);
        animation.runAnimation(this, AnimationType.JUMP);
                Thread.sleep(300);
        oldY = position.getY();
        position.moveDown(graphicsRep.getHeight());
        graphicsRep.translate(0,position.getY() - oldY);
        animation.runAnimation(this, AnimationType.RUN);
        Thread.sleep(300);
    }


}
