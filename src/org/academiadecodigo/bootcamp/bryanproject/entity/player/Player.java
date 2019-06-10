package org.academiadecodigo.bootcamp.bryanproject.entity.player;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.Playable;
import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Entity implements Playable {

    public Player(int health, int maxHealth, int strength) {
        super(health, maxHealth, strength);
    }


    public void spawn(int x, int y, int size, Ground ground) {
        Picture picture = new Picture(x + size, y - size, "Game/Animations/Entity/Bryan/bryan-walk-00.png");
        super.spawn(x + size, y - size, size, ground, picture);
    }

}
