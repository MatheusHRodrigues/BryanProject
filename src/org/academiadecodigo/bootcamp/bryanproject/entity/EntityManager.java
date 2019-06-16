package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.world.Ground;
import org.academiadecodigo.bootcamp.bryanproject.world.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EntityManager {

    private Entity entity;
    private EntityLogical logical;
    private EntityHitBox hitBox;
    private EntityGraphics graphics;
    private EntityMove move;
    private Ground ground; //TODO Send to map


    public EntityManager(Entity entity) {
        this.entity = entity;
        move = new EntityMove(entity, this);
    }

    public void moveUp(int distance) {
        logical.setY(logical.getY() - distance);
    }

    public void moveDown(int distance) {
        logical.setY(logical.getY() + distance);
    }


    public Ground getGround() {
        return ground;
    }

    public void init(int x, int y, Ground ground, int size, Picture gRepresentation) {
        this.ground = ground;
        logical = new EntityLogical(x, y, size * 2, size * 2);
        graphics = new EntityGraphics(this, gRepresentation);
        graphics.init(x, y, size, entity);
        hitBox = new EntityHitBox(x, y, size * 2, size * 2); //Tem que da grow
    }

    public Position getLogical() {
        return logical;
    }

    public EntityMove getMoves() {
        return move;
    }

    public EntityGraphics getGraphics() {
        return graphics;
    }

    public EntityHitBox getHitBox() {
        return hitBox;
    }


}
