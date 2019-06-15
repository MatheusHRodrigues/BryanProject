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
    private boolean movingBlock;
    private boolean moving;
    private boolean attacking;

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

    public Animation getAnimation() {
        return animation;
    }

    public void addGraphicsRepresentation() {
        graphicsRep = new Picture(0, 0,
                "Game/Animations/Entity/" + entityType.getName() + "/idle/right-0.png");
    }

    public void addGraphicsRepresentation(AnimationDirection animationDirection) {
        graphicsRep = new Picture(0, 0,
                "Game/Animations/Entity/" + entityType.getName() + "/idle/" + animationDirection + "-0.png");
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
        animation.startIdle(this);
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
        try {
        if (!jumping) {
            jumping = true;
            movingBlock = true;
            int oldY = position.getY();
            position.moveUp(graphicsRep.getHeight()/2);
            graphicsRep.translate(0, position.getY() - oldY);
            hitbox.translate(0, position.getY() - oldY);
            animation.runAnimation(this, AnimationType.JUMP);

            Thread.sleep(180/4);

            oldY = position.getY();
            position.moveUp(graphicsRep.getHeight()/2);
            graphicsRep.translate(0, position.getY() - oldY);
            hitbox.translate(0, position.getY() - oldY);
            animation.runAnimation(this, AnimationType.JUMP);


            Thread.sleep(180/2);


            oldY = position.getY();
            position.moveDown(graphicsRep.getHeight()/2);
            graphicsRep.translate(0, position.getY() - oldY);
            hitbox.translate(0, position.getY() - oldY);
            animation.runAnimation(this,AnimationType.JUMP);


            Thread.sleep(180/4);

            oldY = position.getY();
            position.moveDown(graphicsRep.getHeight()/2);
            graphicsRep.translate(0, position.getY() - oldY);
            hitbox.translate(0, position.getY() - oldY);
            animation.runAnimation(this,AnimationType.JUMP);

            jumping = false;
            movingBlock = false;

        }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } //TROCAR MOVIMENTOS POR INTERFACE

    public boolean isMovingBlock() {
        return movingBlock;
    }

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

    public void setMovingBlock(boolean movingBlock) {
        this.movingBlock = movingBlock;
    }

    public void attack() {
        //CREATE THREAD
        class Attack implements Runnable {
            private Entity entity;

            public Attack(Entity entity) {
                this.entity = entity;
            }
            @Override
            public void run() {
                if (!entity.isAttacking()) {
                    entity.setAttacking(true);
                    entity.setMoving(true);
                    entity.setMovingBlock(true);
                    List<Entity> entities = world.getEntities();
                    for (int i = 0; i < 5; i++) {
                        animation.runAnimation(entity,AnimationType.ATACK);
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (Entity en : entities) {
                        if (en.hashCode() != entity.hashCode()) {
                            en.hitable(hitbox.getX(), hitbox.getY(), hitbox.getHeight(), hitbox.getWidth());
                            en.hit(10);
                        }
                    }
                    entity.setMovingBlock(false);
                    entity.setMoving(false);
                    entity.setAttacking(false);
                }
            }
        }

        new Thread(new Attack(this)).start();
    }

    public void hit(int damage) {
        this.setMoving(true);

        class Hit implements Runnable {

            private Entity entity;

            public Hit(Entity entity) {
                this.entity = entity;
            }
            @Override
            public void run() {
                entity.setMovingBlock(true);
                for (int i = 0; i < 5; i++) {
                    animation.runAnimation(entity, AnimationType.HURT);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Chance de da Break
                }
                entity.setMovingBlock(false);
                entity.setMoving(false);
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

    public Rectangle getHitbox() {
        return hitbox;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
}

