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

    public float manCoordX = 0;
    public  float manCoordY = 0;

    private float shiftX = manCoordX + 400;
    private float shiftY = manCoordY + 300;

    private Animation staying, movingUp, movingDown, movingLeft, movingRight;
    int[] duration = {200,200};

    private Input input;

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

        //this.assets = new Assets();

        //this.movingUp = new Animation(this.spriteSheetPlayer,200);
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        this.spriteSheetPlayer.getSubImage(95,587,50,114).draw(this.shiftX,this.shiftY);

        this.movingUp = new Animation(this.spriteSheetPlayer,200);
        this.movingDown = new Animation(this.spriteSheetPlayer,200);
        this.movingLeft = new Animation(this.spriteSheetPlayer,200);
        this.movingRight = new Animation(this.spriteSheetPlayer,200);

        /// get hero coordinates
        graphics.drawString("hero X: " + this.manCoordX + "\nhero Y: " + this.manCoordY, 400,20);
    }

    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.input = gameContainer.getInput();

        if (this.input.isKeyDown(Input.KEY_UP)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordY += delta * .1f;

            if (this.manCoordY > 300){

                this.manCoordY -= delta * .1f;

            }
        }

        if (this.input.isKeyDown(Input.KEY_DOWN)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordY -= delta * .1f;

            if (this.manCoordY < -2720){

                this.manCoordY += delta * .1f;

            }
        }

        if (this.input.isKeyDown(Input.KEY_LEFT)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordX += delta * .1f;

            if (this.manCoordX > 400){

                this.manCoordX -= delta * .1f;

            }
        }

        if (this.input.isKeyDown(Input.KEY_RIGHT)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordX -= delta * .1f;

            if (this.manCoordX < -2685){

                this.manCoordX += delta * .1f;

            }
        }

    }



}
