package org.academiadecodigo.bootcamp.bryanproject.world;


public class Position {

    private int x;
    private int y;
    private int height;
    private int width;

    public Position(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
