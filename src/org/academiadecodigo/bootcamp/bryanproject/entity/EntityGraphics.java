package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.bootcamp.bryanproject.animation.Animation;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EntityGraphics {

    private EntityManager entityManager;
    private Picture graphicsRep;
    private Animation animation;

    public EntityGraphics(EntityManager entityManager,Picture picture) {
        this.entityManager = entityManager;
        addRepresentation(picture);
    }

    private void addRepresentation(Picture picture) {
        graphicsRep = picture;
        animation = new Animation();
    }

    public void init(int x, int y, int size, Entity entity) {
        translate(x,y);
        grow(size,size);
        draw();
        getAnimation().startIdle(entity);
    }

    public Animation getAnimation() {
        return animation;
    }

    public Picture getGraphicsRep() {
        return graphicsRep;
    }


    public void translate(int x, int y) {
        graphicsRep.translate(x,y);
    }

    public void grow(double v, double v2) {
        graphicsRep.grow(v,v2);
    }

    public void draw() {
        graphicsRep.draw();
    }

}
