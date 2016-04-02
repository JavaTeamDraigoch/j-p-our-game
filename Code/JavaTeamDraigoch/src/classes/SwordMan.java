package classes;

import gfx.Assets;
import items.Sword;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class SwordMan  {

    Animation swordMan, isMovingUp, isMovingDown, isMovingLeft, isMovingRight;

    private Image playerIMG;
    private SpriteSheet spriteSheetPlayer;
    private Assets assets;

    boolean quit = false;

    int[] duration = {200,200};

    private float manCoordX = 50;
    private float manCoordY = 200;

    private float shiftX = manCoordX + 400;
    private float shiftY = manCoordY + 300;

    private int health;
    private int level;
    private int moveSpeed;
    private int meleeAttack;
    private int spellAttack;
    private int armor;
    private int lightRadius;
    private String playerName;

    public SwordMan (int manCoordX,int manCoordY, String playerName) throws SlickException {

        this.manCoordX = manCoordX;
        this.manCoordY = manCoordY;
        this.playerName = playerName;

        this.playerIMG = new Image("resources/img/testPlayer.png");
        this.spriteSheetPlayer = new SpriteSheet(this.playerIMG,95,587,50,114);

        this.assets = new Assets();

    }



    public void init(GameContainer gameContainer) throws SlickException {

        this.assets = new Assets();
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        this.spriteSheetPlayer.getSubImage(95,587,50,114).draw(this.manCoordX,this.manCoordY);
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {

    }



}
