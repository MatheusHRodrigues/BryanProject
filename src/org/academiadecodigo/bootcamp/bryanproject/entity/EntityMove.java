package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.animation.Animation;
import org.academiadecodigo.bootcamp.bryanproject.animation.AnimationDirection;
import org.academiadecodigo.bootcamp.bryanproject.animation.AnimationType;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class EntityMove {


    private Entity entity;
    private EntityManager entityManager;
    private boolean jumping;
    private boolean movingBlock;
    private boolean moving;
    private boolean attacking;


    public EntityMove(Entity entity, EntityManager entityManager) {
        this.entity = entity;
        this.entityManager = entityManager;
    }

    //TODO REFACTOR
    public void jump() {
        EntityManager entityManager = entity.getEntityManager();
        Picture graphicsRep = entity.getEntityManager().getGraphics().getGraphicsRep();
        Rectangle hitbox = entity.getEntityManager().getHitBox();
        Animation animation = entity.getEntityManager().getGraphics().getAnimation();
        try {
            if (!jumping) {
                jumping = true;
                movingBlock = true;
                int oldY = entityManager.getLogical().getY();
                entityManager.moveUp(graphicsRep.getHeight() / 2);
                graphicsRep.translate(0, entityManager.getLogical().getY() - oldY);
                hitbox.translate(0, entityManager.getLogical().getY() - oldY);
                animation.runAnimation(entity, AnimationType.JUMP);

                Thread.sleep(180 / 4);

                oldY = entityManager.getLogical().getY();
                entityManager.moveUp(graphicsRep.getHeight() / 2);
                graphicsRep.translate(0, entityManager.getLogical().getY() - oldY);
                hitbox.translate(0, entityManager.getLogical().getY() - oldY);
                animation.runAnimation(entity, AnimationType.JUMP);


                Thread.sleep(180 / 2);


                oldY = entityManager.getLogical().getY();
                entityManager.moveDown(graphicsRep.getHeight() / 2);
                graphicsRep.translate(0, entityManager.getLogical().getY() - oldY);
                hitbox.translate(0, entityManager.getLogical().getY() - oldY);
                animation.runAnimation(entity, AnimationType.JUMP);


                Thread.sleep(180 / 4);

                oldY = entityManager.getLogical().getY();
                entityManager.moveDown(graphicsRep.getHeight() / 2);
                graphicsRep.translate(0, entityManager.getLogical().getY() - oldY);
                hitbox.translate(0, entityManager.getLogical().getY() - oldY);
                animation.runAnimation(entity, AnimationType.JUMP);

                jumping = false;
                movingBlock = false;

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Entity getEntity() {
        return entity;
    }

    public boolean isJumping() {
        return jumping;
    }

    public boolean isMovingBlock() {
        return movingBlock;
    }

    public void setMovingBlock(boolean movingBlock) {
        this.movingBlock = movingBlock;
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

    ////////////////////////////////////////////////////////////////////

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public void moveForward(int distance) {
        int oldX = entityManager.getLogical().getX();
        if (oldX + distance <= entityManager.getGround().getWidth() - entity.getSize() * 2) {
            this.moveRight(distance);
        }
    }

    public void moveBackwards(int distance) {
        int oldX = entityManager.getLogical().getX();
        if ((oldX - distance) >= 10) {
            this.moveLeft(distance);
        }
    }

    private void moveLeft(int distance) {
        int oldX = entityManager.getLogical().getX();
        entityManager.getLogical().setX(oldX - distance);
        int logicalX = entityManager.getLogical().getX();
        entityManager.getGraphics().getGraphicsRep().translate(logicalX - oldX, 0);
        entityManager.getHitBox().translate(logicalX - oldX, 0);
        entityManager.getGraphics().getAnimation().runAnimation(entity, AnimationType.WALK, AnimationDirection.LEFT);
    }

    private void moveRight(int distance) {
        int oldX = entityManager.getLogical().getX();
        entityManager.getLogical().setX(oldX + distance);
        int logicalX = entityManager.getLogical().getX();
        entityManager.getGraphics().getGraphicsRep().translate(logicalX - oldX, 0);
        entityManager.getHitBox().translate(logicalX - oldX, 0);
        entityManager.getGraphics().getAnimation().runAnimation(entity, AnimationType.WALK, AnimationDirection.RIGHT);
    }

    public void attack() {
        class Attack implements Runnable {
            private Entity entity;

            public Attack(Entity entity) {
                this.entity = entity;
            }
            @Override
            public void run() {
                if (!entity.getEntityManager().getMoves().isAttacking()) {
                    //TODO MELHORAR ISSO
                    entity.getEntityManager().getMoves().setAttacking(true);
                    entity.getEntityManager().getMoves().setMoving(true);
                    entity.getEntityManager().getMoves().setMovingBlock(true);
                    List<Entity> entities = entity.getWorld().getEntities();
                    for (int i = 0; i < 5; i++) {
                        entityManager.getGraphics().getAnimation().runAnimation(entity,AnimationType.ATACK);
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (Entity en : entities) {
                        if (en.hashCode() != entity.hashCode()) {
                            if (en.getEntityManager().getHitBox().hitable(entityManager.getHitBox().getX(), entityManager.getHitBox().getY(), entityManager.getHitBox().getHeight(), entityManager.getHitBox().getWidth())) {
                                en.hit(10);
                            }
                        }
                    }
                    entity.getEntityManager().getMoves().setMovingBlock(false);
                    entity.getEntityManager().getMoves().setMoving(false);
                    entity.getEntityManager().getMoves().setAttacking(false);
                }
            }
        }

        new Thread(new Attack(entity)).start();
    }
}
