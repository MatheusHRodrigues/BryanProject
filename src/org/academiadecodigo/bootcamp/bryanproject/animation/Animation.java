package org.academiadecodigo.bootcamp.bryanproject.animation;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;

import java.util.Date;

public class Animation {
    private int frame = -1;
    private AnimationType currentType;
    private String path = "Game/Animations/";
    private String fileConcat = "-";
    private String tag = "{}";
    private Date date;
    private Boolean idle; //TODO USAR
    private AnimationDirection lastDirection = AnimationDirection.RIGHT;


    public Animation() {
        this.date = new Date(System.currentTimeMillis());
    }

    public void runAnimation(Entity entity, AnimationType type) {
        String load = path + "Entity/" + entity.getEntityType().getName() + "/" + type.toString().toLowerCase() + "/" + lastDirection.toString().toLowerCase() + fileConcat + tag + ".png";
        System.out.println(load);
        run(entity, type, load);
    }

    public void runAnimation(Entity entity, AnimationType type, AnimationDirection animationDirection) {
        this.lastDirection = animationDirection;
        String load = path + "Entity/" + entity.getEntityType().getName() + "/" + type.toString().toLowerCase() + "/" + animationDirection.toString().toLowerCase() + fileConcat + tag + ".png";
        run(entity, type, load);

    }

    public void startIdle(Entity entity) {
        class Idle implements Runnable {
            private Entity entity;
            private Animation animation;

            Idle(Entity entity, Animation animation) {
                this.entity = entity;
                this.animation = animation;
            }

            @Override
            public void run() {
                if (animation.getLastDirection() == null) {
                    animation.setLastDirection(AnimationDirection.RIGHT);
                }
                while (true) {
                    synchronized (this) {
                        long time = new Date(System.currentTimeMillis()).getTime();
                        if (animation.getDate().getTime() + 10 < time && !entity.getEntityManager().getMoves().isMoving() && !entity.getEntityManager().getMoves().isMovingBlock()) {

                            animation.runAnimation(entity, AnimationType.IDLE, animation.getLastDirection());
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        Thread t = new Thread(new Idle(entity, this));
        t.start();
    }

    private void run(Entity entity, AnimationType type, String load) {
        if (currentType == type) {
            frame++;
            currentType = type;
            if (frame < 3) {
                load = load.replace("{}", new Integer(frame).toString());
                entity.getEntityManager().getGraphics().getGraphicsRep().load(load);
            } else {
                frame = -1;
            }
        } else {
            frame = -1;
            currentType = type;
            run(entity, type, load);
            return;
        }
        date = new Date(System.currentTimeMillis());
    }

    public Date getDate() {
        return date;
    }

    public AnimationDirection getLastDirection() {
        return lastDirection;
    }

    public void setLastDirection(AnimationDirection lastDirection) {
        this.lastDirection = lastDirection;
    }
}
