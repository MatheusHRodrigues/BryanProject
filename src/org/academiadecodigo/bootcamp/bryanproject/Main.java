package org.academiadecodigo.bootcamp.bryanproject;

import org.academiadecodigo.bootcamp.bryanproject.game.Game;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {

        Game game = new Game();
        game.start();

    }
}