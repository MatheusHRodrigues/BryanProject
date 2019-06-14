package org.academiadecodigo.bootcamp.bryanproject.entity.npc;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.EntityType;

import java.util.List;

public abstract class NPC extends Entity {
    public NPC(int health, int healthScale, EntityType entityType) {
        super(health, healthScale, entityType);
    }

    public void start() {
        agressive();
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
                                if (entity.hitable(npc.getHitbox().getX(), npc.getHitbox().getY(), npc.getHitbox().getHeight(), npc.getHitbox().getWidth())) {
                                    entity.hit(10);
                                } else {
                                    npc.setMoving(true);
                                    moveBackwards(2);
                                }
                                try {
                                    Thread.sleep(300);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }
                }
            }
        }
        Thread t = new Thread(new AI(getWorld().getEntities(), this));
        t.start();
    }


}
