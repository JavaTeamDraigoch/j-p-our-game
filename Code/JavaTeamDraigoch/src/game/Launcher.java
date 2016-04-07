package game;

import org.newdawn.slick.SlickException;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("Diablo");
        try {
            game.run();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}