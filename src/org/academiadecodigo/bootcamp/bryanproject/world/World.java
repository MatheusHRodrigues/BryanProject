package org.academiadecodigo.bootcamp.bryanproject.world;

import org.academiadecodigo.bootcamp.bryanproject.entity.Entity;
import org.academiadecodigo.bootcamp.bryanproject.game.Displayable;
import org.academiadecodigo.bootcamp.bryanproject.game.Game;
import org.academiadecodigo.bootcamp.bryanproject.music.Audio;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public abstract class World implements Displayable {
    private Map map;
    private Game game;
    private Picture picture;
    private WorldEventManager worldEventManager;
    private Audio audio;
    private List<Entity> entities = new ArrayList<>();

    protected World(Map map,Game game, Audio audio) {
        this.map = map;
        this.game = game;
        this.audio = audio;
        worldEventManager = new WorldEventManager(this);
        new Thread(worldEventManager).start();
    }

    public Audio getAudio() {
        return audio;
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

    public void finish() {
        audio.stopAudio();
        for (Entity entity : entities) {
            entity.remove();
        }
        map = null;
        picture = null;
        entities = null;
    }

}
