package dev.codnmore.tilegame;

import dev.codenmore.tilegame.display.Game;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Best Game Ever", 350, 350);
        game.start();

    }
}
