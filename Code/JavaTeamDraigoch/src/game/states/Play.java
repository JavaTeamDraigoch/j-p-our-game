package game.states;

import characters.Minotaur;
import characters.SwordsMan;
import manageres.EnemiesManager;
import manageres.SwordsManManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TADimitrov on 3/30/2016.
 */
public class Play extends BasicGameState {
    private int stateID;
    private SwordsManManager swordsManManager = new SwordsManManager();
    private EnemiesManager enemiesManager = new EnemiesManager();

    public Image levelOneMap;
    private Image backGround;

    public static SwordsMan swordMan;
    public static Minotaur minotaur;
    public Minotaur minotaur2;

    private List<Minotaur> minotaurs = new ArrayList<>();

    public List<Minotaur> getMinotaurs() {
        return minotaurs;
    }

    public Play(int state) {
        this.stateID = state;
    }

    @Override
    public int getID() {
        return this.stateID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        //backGround = new Image("resources/img/basicGrid20x20.png");
        //levelOneMap = new Image("resources/img/World.png");

        //this.levelOneMap = new Image("resources/img/t.png");
        this.levelOneMap = new Image("resources/img/Level1-Mockup.png");

        this.swordsManManager.createCharacter();

        this.enemiesManager.createCharacter();

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        this.levelOneMap.draw(this.swordsManManager.getCharacter().getPosX(), this.swordsManManager.getCharacter().getPosY());

        this.swordsManManager.drawCharacter();
        this.enemiesManager.drawCharacter();

        graphics.drawString("X "+ this.swordsManManager.getCharacter().getPosX()+ "", 0, 30);
        graphics.drawString("Y "+ this.swordsManManager.getCharacter().getPosY()+ "", 0, 50);

        graphics.drawString("ENEMY X "+ this.enemiesManager.getCharacter().getPosX()+ "", 150, 30);
        graphics.drawString("ENEMY Y "+ this.enemiesManager.getCharacter().getPosY()+ "", 150, 50);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        this.swordsManManager.moveCharacter(gameContainer);

        this.enemiesManager.moveCharacter(gameContainer);

    }
}
