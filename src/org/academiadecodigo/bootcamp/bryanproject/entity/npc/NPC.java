package org.academiadecodigo.bootcamp.bryanproject.entity.npc;

import org.academiadecodigo.bootcamp.bryanproject.animation.AnimationType;
import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.EntityType;

import java.util.List;

public abstract class NPC extends Entity {
    public NPC(int health, int healthScale, EntityType entityType) {
        super(health, healthScale, entityType);
    }

    public void start() {
        AI.Agressive(this);
    }

    public void agressive() {
        class AI implements Runnable {
            List<Entity> entities;
            NPC npc;

            AI(List<Entity> en, NPC npc) {
                entities = en;
                this.npc = npc;
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (Entity entity : entities) {
                        if (entity.isAPlayer()) {
                            while (!entity.isDead()) {
                                if (entity.getEntityManager().getHitBox().hitable(npc.getEntityManager().getHitBox().getX(), npc.getEntityManager().getHitBox().getY(), npc.getEntityManager().getHitBox().getHeight(), npc.getEntityManager().getHitBox().getWidth())) {
                                    npc.getEntityManager().getMoves().setMoving(true);
                                    synchronized (this) {
                                        for (int i = 0; i < 5; i++) {
                                            npc.getEntityManager().getGraphics().getAnimation().runAnimation(npc, AnimationType.ATACK);
                                            try {
                                                Thread.sleep(30);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                    entity.hit(10);
                                } else {
                                    npc.getEntityManager().getMoves().setMoving(true);
                                    npc.getEntityManager().getMoves().moveBackwards(2);
                                }
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }
                    npc.getEntityManager().getMoves().setMoving(false);
                }
            }
        }
        Thread t = new Thread(new AI(getWorld().getEntities(), this));
        t.start();
    }


}
