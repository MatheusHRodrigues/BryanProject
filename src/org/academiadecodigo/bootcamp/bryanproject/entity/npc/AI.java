package org.academiadecodigo.bootcamp.bryanproject.entity.npc;

import org.academiadecodigo.bootcamp.bryanproject.animation.AnimationType;
import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;

public class AI {

    public static void Agressive(NPC npc) {
        class AgressiveAi implements Runnable {

            private NPC npc;

            public AgressiveAi(NPC npc) {
                this.npc = npc;
            }

            @Override
            public void run() {
                for (Entity en : npc.getWorld().getEntities()) {
                    synchronized (this) {
                        if (en.isAPlayer()) {
                            npc.getEntityManager().getMoves().setMoving(true);
                            while (!en.isDead()) {
                                if (en.getEntityManager().getHitBox().getX() + en.getEntityManager().getHitBox().getWidth() < npc.getEntityManager().getHitBox().getX()) {
                                    npc.getEntityManager().getMoves().moveBackwards(6);
                                } else if (npc.getEntityManager().getHitBox().getX() + npc.getEntityManager().getHitBox().getWidth() < en.getEntityManager().getHitBox().getX()) {
                                    npc.getEntityManager().getMoves().moveForward(6);
                                } else {
                                    for (int i = 0; i < 5; i++) {
                                        npc.getEntityManager().getGraphics().getAnimation().runAnimation(npc, AnimationType.ATACK);
                                        try {
                                            Thread.sleep(30);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    en.hit(10);
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

        new Thread(new AgressiveAi(npc)).start();
    }
}
