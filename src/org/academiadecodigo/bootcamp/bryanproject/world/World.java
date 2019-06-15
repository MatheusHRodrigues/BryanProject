package org.academiadecodigo.bootcamp.bryanproject.world;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.game.Displayable;
import org.academiadecodigo.bootcamp.bryanproject.game.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public abstract class World implements Displayable {
    private Map map;
    private Game game;
    private Picture picture;
    private List<Entity> entities = new ArrayList<>();

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

    public Picture getPicture() {
        return picture;
    }

    public void addPicture(Picture picture) {
        this.picture = picture;
    }

    public List<Entity> getEntities() {
        return entities;
    }

}
