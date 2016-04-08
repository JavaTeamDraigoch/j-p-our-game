package game;

import org.newdawn.slick.SlickException;

public class Launcher {
    private final String GAME_NAME = "Diablo 4";

    public static void main(String[] args) {
        GameEngine game = new GameEngine("GAME_NAME");
        try {
            game.run();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}