package classes;

import game.*;
import game.Game;
import gfx.Assets;
import items.Sword;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class SwordMan {

    //Animation swordMan, isMovingUp, isMovingDown, isMovingLeft, isMovingRight;

    private Image playerIMG;
    private SpriteSheet spriteSheetPlayer;
    private Assets assets;

    boolean quit = false;

    public static float manCoordX = 0;
    public static  float manCoordY = 0;

    public static float shiftX = manCoordX + 400;
    public static float shiftY = manCoordY + 300;

    public static int manCropWidth;
    public static int manCropHeight;

    private Animation staying, movingUp, movingDown, movingLeft, movingRight;
    int[] duration = {200,200};

    private Input input;

    private int health;
    private int level;
    public static double moveSpeed;
    private int meleeAttack;
    private int spellAttack;
    private int armor;
    private int lightRadius;
    private String playerName;

    public SwordMan (int manCoordX,int manCoordY, String playerName) throws SlickException {


        this.manCoordX = manCoordX;
        this.manCoordY = manCoordY;
        this.playerName = playerName;

        this.moveSpeed = 0.2;

        this.manCropWidth = 50;
        this.manCropHeight = 114;

        this.playerIMG = new Image("resources/img/testPlayer.png");
        this.spriteSheetPlayer = new SpriteSheet(this.playerIMG,95,587,this.manCropWidth, this.manCropHeight);

        this.assets = new Assets();

    }



    public void init(GameContainer gameContainer) throws SlickException {


    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        this.spriteSheetPlayer.getSubImage(95,587,50,114).draw(this.shiftX,this.shiftY);

        this.movingUp = new Animation(this.spriteSheetPlayer,200);
        this.movingDown = new Animation(this.spriteSheetPlayer,200);
        this.movingLeft = new Animation(this.spriteSheetPlayer,200);
        this.movingRight = new Animation(this.spriteSheetPlayer,200);

        /// get hero coordinates
        graphics.drawString("hero  manCoordX: " + this.manCoordX + "\nhero Y: " + this.manCoordY, 0,20);
        //graphics.drawString("hero X: " + this.shiftX + "\nhero Y: " + this.shiftY, 200,20);
    }

    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.input = gameContainer.getInput();

        if (this.input.isKeyDown(Input.KEY_UP)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordY += this.moveSpeed;

            if ((Math.round(this.manCoordY) > Game.MOST_UP_COORDINATE)){

                this.manCoordY -= this.moveSpeed;

            }

            boolean betweenYY = (this.shiftY < Minotaur.enemyCoordY + Minotaur.enemyCropHeight) &&
                                (Minotaur.enemyCoordY - this.shiftY < Minotaur.enemyCropHeight);

            boolean betweenXX = (this.shiftX + this.manCropWidth > Minotaur.enemyCoordX) &&
                                (this.shiftX  < Minotaur.enemyCoordX + this.manCropWidth);

            if (betweenYY && betweenXX){

                this.manCoordY -= this.moveSpeed;

            }
        }

        if (this.input.isKeyDown(Input.KEY_DOWN)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordY -= this.moveSpeed;

            if (Math.round(this.manCoordY) < Game.MOST_DOWN_COORDINATE){

                this.manCoordY += this.moveSpeed;

            }

            boolean betweenXX = (this.shiftX + this.manCropWidth > Minotaur.enemyCoordX) &&
                    (this.shiftX  < Minotaur.enemyCoordX + this.manCropWidth);


            boolean inY = Math.abs((this.shiftY + this.manCropHeight) - Minotaur.enemyCoordY) < 2;

            if (inY && betweenXX){

                this.manCoordY += this.moveSpeed;

            }
        }

        if (this.input.isKeyDown(Input.KEY_LEFT)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordX += this.moveSpeed;

            if (Math.round(this.manCoordX) > Game.MOST_LEFT_COORDINATE ){

                this.manCoordX -= this.moveSpeed;

            }

            boolean inY1 = this.shiftY <= (Minotaur.enemyCoordY + Minotaur.enemyCropHeight);
            boolean inY2 = (this.shiftY + this.manCropHeight) >= Minotaur.enemyCoordY;
            boolean inX = Math.abs(this.shiftX - (Minotaur.enemyCoordX + Minotaur.enemyCropWidth)) < 2 ;

            if (inY1 && inY2 && inX){
                this.manCoordX -= this.moveSpeed;
            }
        }

        if (this.input.isKeyDown(Input.KEY_RIGHT)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordX -= this.moveSpeed;

            if (Math.round(this.manCoordX) < Game.MOST_RIGHT_COORDINATE){

                this.manCoordX += this.moveSpeed;

            }

            boolean inY1 = this.shiftY <= (Minotaur.enemyCoordY + Minotaur.enemyCropHeight);
            boolean inY2 = (this.shiftY + this.manCropHeight) >= Minotaur.enemyCoordY;
            boolean inX = Math.abs((this.shiftX + this.manCropWidth) - Minotaur.enemyCoordX  ) < 2 ;

            if (inY1 && inY2 && inX){

                this.manCoordX += this.moveSpeed;
            }
        }

    }



}
