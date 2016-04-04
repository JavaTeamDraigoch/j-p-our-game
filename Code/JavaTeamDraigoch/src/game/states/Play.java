package game.states;

import classes.Minotaur;
import classes.SwordMan;
import gfx.Assets;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by TADimitrov on 3/30/2016.
 */
public class Play extends BasicGameState {
    private int stateID;

    public Image levelOneMap;
    private Image backGround;

    public static SwordMan swordMan;
    public static Minotaur minotaur;


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

        this.levelOneMap = new Image("resources/img/t.png");

        this.swordMan = new SwordMan(0,0,"Alex"); /// x = 0 ?,y = 0 ?  starting position of our Hero ;)

//        for (int i = 0; i <= 10; i++) {
//
//            this.minotaur = new Minotaur(-i * 60, -i * 100);
//        }

         this.minotaur = new Minotaur(20,20);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        this.levelOneMap.draw(this.swordMan.manCoordX,this.swordMan.manCoordY);


        this.swordMan.render(gameContainer,graphics);


        this.minotaur.render(gameContainer,graphics);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        /// if mission accomplished stateBasedGame -- main menu or next level
        this.swordMan.update(gameContainer, this.stateID);
        this.minotaur.update(gameContainer,this.stateID);

    }
}
