package org.academiadecodigo.bootcamp.bryanproject.world;

public class Map {
    private String bgLocation;
    private Ground ground;


    protected Map(String bgLocation, Ground ground) {
        this.bgLocation = bgLocation;
        this.ground = ground;
    }

    public String getBgLocation() {
        return bgLocation;
    }

    public Ground getGround() {
        return ground;
    }
}
