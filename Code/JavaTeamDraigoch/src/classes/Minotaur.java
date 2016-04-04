package classes;

import game.*;
import game.Game;
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

        this.spriteSheetEnemy.getSubImage(0,0,50,75).draw(this.enemyCoordX, this.enemyCoordY);

        this.movingUp = new Animation(this.spriteSheetEnemy,100);
        this.movingDown = new Animation(this.spriteSheetEnemy,100);
        this.movingLeft = new Animation(this.spriteSheetEnemy,100);
        this.movingRight = new Animation(this.spriteSheetEnemy,100);

        // test enemy coordinates
        graphics.drawString("enemy X: " + this.enemyCoordX + "\nenemy Y: " + this.enemyCoordY, 500,20);

    }

    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.input = gameContainer.getInput();


        if (this.input.isKeyDown(Input.KEY_UP)){

            if (Math.round(SwordMan.manCoordY) <= Game.MOST_UP_COORDINATE - 1) {

                this.enemyCoordY += SwordMan.moveSpeed;
            }

        }

        if (this.input.isKeyDown(Input.KEY_DOWN)){

            if ( Math.round(SwordMan.manCoordY) >= Game.MOST_DOWN_COORDINATE + 1){

                this.enemyCoordY -= SwordMan.moveSpeed;
            }
        }

        if (this.input.isKeyDown(Input.KEY_LEFT)){

            if (Math.round(SwordMan.manCoordX) <= Game.MOST_LEFT_COORDINATE - 1){

                this.enemyCoordX += SwordMan.moveSpeed;

            }

        }

        if (this.input.isKeyDown(Input.KEY_RIGHT)){

            if (Math.round(SwordMan.manCoordX) >= Game.MOST_RIGHT_COORDINATE + 1){

                this.enemyCoordX -= SwordMan.moveSpeed;
            }
        }

    }

}
