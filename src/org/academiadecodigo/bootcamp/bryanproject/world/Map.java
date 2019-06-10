package org.academiadecodigo.bootcamp.bryanproject.world;

public class Map {
    private String backgroudPath;
    private Ground ground;

    protected Map(String backgroudPath, Ground ground) {
        this.backgroudPath = backgroudPath;
        this.ground = ground;
    }

    public String getBackgroudPath() {
        return backgroudPath;
    }

    public Ground getGround() {
        return ground;
    }
}
