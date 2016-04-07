package game.states;

import characters.Minotaur;
import characters.SwordMan;
import contracts.Character;
import manageres.CharacterManager;
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
    private CharacterManager characterManager = new CharacterManager();

    public Image levelOneMap;
    private Image backGround;

    public static SwordMan swordMan;
    public Minotaur minotaur1;
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

        this.levelOneMap = new Image("resources/img/t.png");

        //this.swordMan = new SwordMan(0,0,"Alex"); /// x = 0 ?,y = 0 ?  starting position of our Character ;)

        //for (int i = 0; i <= 2; i++) {

           // this.minotaurs.add(new Minotaur( i * 100, 100));
        //}

         //this.minotaur1 = new Minotaur(900,900);
        //this.minotaur2 = new Minotaur(300,300);

        characterManager.createCharacter();

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

       // this.levelOneMap.draw(this.swordMan.manCoordX,this.swordMan.manCoordY);


        this.swordMan.render(gameContainer,graphics);


        //this.minotaur1.render(gameContainer,graphics);
        ///this.minotaur2.render(gameContainer,graphics);

       // for(Minotaur minotaur: getMinotaurs()){

           // minotaur.render(gameContainer,graphics);
        //}

        characterManager.drawCharacter();

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        /// if mission accomplished stateBasedGame -- main menu or next level
        this.swordMan.update(gameContainer, this.stateID);
        this.minotaur1.update(gameContainer,this.stateID);
        this.minotaur2.update(gameContainer,this.stateID);

        //for(Minotaur minotaur: getMinotaurs()){

           // minotaur.update(gameContainer, this.stateID);
       // }
        characterManager.moveCharacter();

    }
}
