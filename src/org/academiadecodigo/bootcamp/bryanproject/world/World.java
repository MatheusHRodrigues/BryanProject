package org.academiadecodigo.bootcamp.bryanproject.world;

import org.academiadecodigo.bootcamp.bryanproject.game.Game;

public abstract class World {
    private Map map;
    private Game game;

    protected World(Map map,Game game) {
        this.map = map;
        this.game = game;
    }

    public Map getMap() {
        return map;
    }

    public Game getGame() {
        return game;
    }

    public abstract void init();

}
