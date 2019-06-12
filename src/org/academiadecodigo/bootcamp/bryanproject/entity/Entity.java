package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.animation.Animation;
import org.academiadecodigo.bootcamp.bryanproject.animation.AnimationDirection;
import org.academiadecodigo.bootcamp.bryanproject.animation.AnimationType;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Entity {
    private HealthManage healthManage;
    private EntityPosition position;
    private Picture graphicsRep; //TODO class to hitbox and image
    private Rectangle hitbox;
    private Animation animation;
    private EntityType entityType;
    private int strength;
    private int size;
    private boolean jumping;

    public Entity(int health, int healthScale, int strength,EntityType entityType) {
        this.entityType = entityType;
        healthManage = new HealthManage(health, healthScale);
        this.strength = strength;
    }

    public void spawn(int x, int y, int size, Ground ground) {
        this.position = new EntityPosition(x, y, ground,size);
        this.size = size;
        addGraphicsRepresentation();
        addHitBox(x,y,graphicsRep.getWidth() -30,graphicsRep.getHeight());
        init(x,y, size);
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void addGraphicsRepresentation() {
        graphicsRep = new Picture(0, 0,
                "Game/Animations/Entity/" + entityType.getName() + "/" + entityType.getName().toLowerCase() + "-idle-0.png");
    }

    private void addHitBox(int x, int y, int width, int height) {
        hitbox = new Rectangle(x,y,width,height);
    }

    public void init(int x,int y,int size) {
        graphicsRep.translate(x ,y);
        graphicsRep.grow(size, size);
        graphicsRep.draw();
        hitbox.grow(size, size);
        hitbox.draw();
        animation = new Animation();
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
            hitbox.translate(position.getX() - oldX,0);
            animation.runAnimation(this, AnimationType.WALK, AnimationDirection.RIGHT);
        }
    }

    public void moveBackwards(int distance) {
        int oldX = position.getX();
        if((oldX - distance) >= 10) {
            position.moveLeft(distance);
            graphicsRep.translate(position.getX() - oldX, 0);
            hitbox.translate(position.getX() - oldX, 0);
            animation.runAnimation(this, AnimationType.WALK, AnimationDirection.LEFT);
        }
    }

    public void jump(){
        if (!jumping) {
            jumping = true;
            int oldY = position.getY();
            position.moveUp(graphicsRep.getHeight());
            graphicsRep.translate(0,position.getY() - oldY);
            hitbox.translate(0,position.getY() - oldY);
            animation.runAnimation(this, AnimationType.JUMP);
            try {
                Thread.sleep(300);
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
    }


}
