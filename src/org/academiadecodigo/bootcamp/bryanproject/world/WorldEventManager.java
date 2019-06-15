package org.academiadecodigo.bootcamp.bryanproject.world;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.game.GameOver;
import org.academiadecodigo.bootcamp.bryanproject.game.GameWin;

import java.util.Set;

public class WorldEventManager implements Runnable {


    private World world;

    public WorldEventManager(World world) {
        this.world = world;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                for (Entity en : world.getEntities()) {
                    System.out.println(en.isDead());
                    if (en.isAPlayer() && en.isDead()) {
                        System.out.println("GAME OVER");
                        new GameOver(world.getGame()).start();
                        clearThreads();
                        world.finish();
                        break;
                    } else if (en.isDead()) {
                        System.out.println("VENCEUUUUU");
                        new GameWin(world.getGame()).start();
                        clearThreads();
                        world.finish();
                        break;
                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void clearThreads() {
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for (Thread t : Thread.getAllStackTraces().keySet())
        {  if (t.getState()==Thread.State.RUNNABLE)
            t.stop();
        }
    }
}
