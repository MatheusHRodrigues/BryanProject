package org.academiadecodigo.bootcamp.bryanproject.entity.npc;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.entity.EntityType;

public abstract class NPC extends Entity {


    public NPC(int health, int healthScale, int strength, EntityType entityType) {
        super(health, healthScale, entityType);
    }
}
