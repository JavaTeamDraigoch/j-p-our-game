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

    public float enemyCoordX = 0 ;
    public  float enemyCoordY = 0  ;

    private float enemyShiftX = enemyCoordX + 400;
    private float enemyShiftY = enemyCoordY + 300;

    private Input input;

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

        this.moveSpeed = 0.05;

        this.enemyIMG = new Image("resources/img/m.png");
        this.spriteSheetEnemy = new SpriteSheet(this.enemyIMG,0,0,50,75);
        this.assetsEnemy = new Assets();

    }

    public void init(GameContainer gameContainer) throws SlickException {


    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        //graphics.translate(this.enemyCoordX, this.enemyCoordY);


        this.spriteSheetEnemy.getSubImage(0,0,50,75).draw(this.enemyCoordX, this.enemyCoordY);

        this.movingUp = new Animation(this.spriteSheetEnemy,100);
        this.movingDown = new Animation(this.spriteSheetEnemy,100);
        this.movingLeft = new Animation(this.spriteSheetEnemy,100);
        this.movingRight = new Animation(this.spriteSheetEnemy,100);
        //this.enemyIMG.draw(150,150);


    }

    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.input = gameContainer.getInput();

        if (this.input.isKeyDown(Input.KEY_UP)){

            this.enemyCoordY += SwordMan.moveSpeed;
        }

        if (this.input.isKeyDown(Input.KEY_DOWN)){

            this.enemyCoordY -= SwordMan.moveSpeed;
        }

        if (this.input.isKeyDown(Input.KEY_LEFT)){

            this.enemyCoordX += SwordMan.moveSpeed;
        }

        if (this.input.isKeyDown(Input.KEY_RIGHT)){

            this.enemyCoordX -= SwordMan.moveSpeed;
        }

    }

}
