package classes;

import gfx.Assets;
import items.Sword;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Minotaur {

    private Animation movingUp, movingDown, movingLeft, movingRight;

    private Image enemyIMG;
    private SpriteSheet spriteSheetEnemy;
    private Assets assetsEnemy;

    public float enemyCoordX = 0;
    public  float enemyCoordY = 0;

    private float enemyShiftX = enemyCoordX + 400;
    private float enemyShiftY = enemyCoordY + 300;

    int[] duration = {200,200};

    private int health;
    private int level;
    private double moveSpeed;
    private int meleeAttack;
    private int spellAttack;
    private int armor;
    private int lightRadius;
    private String playerName;

    public Minotaur (int enemyCoordX, int enemyCoordY) throws SlickException{

        this.enemyCoordX = enemyCoordX;
        this.enemyCoordY = enemyCoordY;

        this.moveSpeed = 0.15;

        this.enemyIMG = new Image("aa.txt");
        this.spriteSheetEnemy = new SpriteSheet(this.enemyIMG,0,0,156,180);
        this.assetsEnemy = new Assets();

    }

    public void init(GameContainer gameContainer) throws SlickException {


    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        this.spriteSheetEnemy.getSubImage(0,0,156,180).draw(this.enemyShiftX,this.enemyShiftY);

        this.movingUp = new Animation(this.spriteSheetEnemy,200);
        this.movingDown = new Animation(this.spriteSheetEnemy,200);
        this.movingLeft = new Animation(this.spriteSheetEnemy,200);
        this.movingRight = new Animation(this.spriteSheetEnemy,200);

        /// get hero coordinates

    }



}
