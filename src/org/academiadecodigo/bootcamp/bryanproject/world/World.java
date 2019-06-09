package org.academiadecodigo.bootcamp.bryanproject.world;

public abstract class World {
    private Map map;

    World(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }
}
