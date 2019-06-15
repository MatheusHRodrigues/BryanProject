package org.academiadecodigo.bootcamp.bryanproject.entity;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class EntityHitBox extends Rectangle {

    public EntityHitBox(double x, double y, double width, double height) {
        super(x, y, width,height);
    }

    public boolean hitable(int x, int y, int height, int width) {
        int xReverse = x + width;
        int yReverse = Math.abs(height - y);
        int xThis = this.getX();
        int yThis = this.getY();
        int xReverseThis = this.getX() + this.getWidth();
        int yReverseThis = Math.abs(this.getHeight() - this.getY());
        if (x > xReverseThis || xThis > xReverse ) {
            return false;
        }
        return y >= yReverseThis && yThis >= yReverse;
    }


}
