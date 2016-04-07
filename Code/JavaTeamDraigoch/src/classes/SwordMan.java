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

    public static float getManCoordX() {
        return manCoordX;
    }

    public static float getManCoordY() {
        return manCoordY;
    }

    public static float getShiftX() {
        return shiftX;
    }

    public static float getShiftY() {
        return shiftY;
    }

    public static int getManCropWidth() {
        return manCropWidth;
    }

    public static int getManCropHeight() {
        return manCropHeight;
    }

    public static double getMoveSpeed() {
        return moveSpeed;
    }

    public SpriteSheet getSpriteSheetPlayer() {
        return spriteSheetPlayer;
    }

    public void init(GameContainer gameContainer) throws SlickException {


    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        this.spriteSheetPlayer.getSubImage(95,587,50,114).draw(this.getShiftX(),this.getShiftY());

        this.movingUp = new Animation(this.getSpriteSheetPlayer(),200);
        this.movingDown = new Animation(this.getSpriteSheetPlayer(),200);
        this.movingLeft = new Animation(this.getSpriteSheetPlayer(),200);
        this.movingRight = new Animation(this.getSpriteSheetPlayer(),200);

        /// get hero coordinates
        graphics.drawString("hero  manCoordX: " + this.getManCoordX() + "\nhero Y: " + this.getManCoordY(), 0,20);
        //graphics.drawString("hero X: " + this.shiftX + "\nhero Y: " + this.shiftY, 200,20);
    }

    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.input = gameContainer.getInput();

        if (this.input.isKeyDown(Input.KEY_UP)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordY += this.getMoveSpeed();

            if ((Math.round(this.getManCoordY()) > Game.MOST_UP_COORDINATE)){

                this.manCoordY -= this.getMoveSpeed();

            }

            boolean betweenYY = (this.getShiftY() < Minotaur.getEnemyCoordY() + Minotaur.getEnemyCropHeight()) &&
                                (Minotaur.getEnemyCoordY() - this.getShiftY() < Minotaur.getEnemyCropHeight());

            boolean betweenXX = (this.getShiftX() + this.getManCropWidth() > Minotaur.getEnemyCoordX()) &&
                                (this.getShiftX()  < Minotaur.getEnemyCoordX() + this.getManCropWidth());

            if (betweenYY && betweenXX){

                this.manCoordY -= this.getMoveSpeed();

            }
        }

        if (this.input.isKeyDown(Input.KEY_DOWN)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordY -= this.getMoveSpeed();

            if (Math.round(this.getManCoordY()) < Game.MOST_DOWN_COORDINATE){

                this.manCoordY += this.getMoveSpeed();

            }

            boolean betweenXX = (this.getShiftX() + this.getManCropWidth() > Minotaur.getEnemyCoordX()) &&
                    (this.getShiftX()  < Minotaur.getEnemyCoordX() + this.getManCropWidth());


            boolean inY = Math.abs((this.getShiftY() + this.getManCropHeight()) - Minotaur.getEnemyCoordY()) < 2;

            if (inY && betweenXX){

                this.manCoordY += this.getMoveSpeed();

            }
        }

        if (this.input.isKeyDown(Input.KEY_LEFT)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordX += this.getMoveSpeed();

            if (Math.round(this.getManCoordX()) > Game.MOST_LEFT_COORDINATE ){

                this.manCoordX -= this.getMoveSpeed();

            }

            boolean inY1 = this.getShiftY() <= (Minotaur.getEnemyCoordY() + Minotaur.getEnemyCropHeight());
            boolean inY2 = (this.getShiftY() + this.getManCropHeight()) >= Minotaur.getEnemyCoordY();
            boolean inX = Math.abs(this.getShiftX() - (Minotaur.getEnemyCoordX() + Minotaur.getEnemyCropWidth())) < 2 ;

            if (inY1 && inY2 && inX){
                this.manCoordX -= this.getMoveSpeed();
            }
        }

        if (this.input.isKeyDown(Input.KEY_RIGHT)){

            /// staying = kartinkata s koiato da se dviji
            this.manCoordX -= this.getMoveSpeed();

            if (Math.round(this.getManCoordX()) < Game.MOST_RIGHT_COORDINATE){

                this.manCoordX += this.getMoveSpeed();

            }

            boolean inY1 = this.getShiftY() <= (Minotaur.getEnemyCoordY() + Minotaur.getEnemyCropHeight());
            boolean inY2 = (this.getShiftY() + this.getManCropHeight()) >= Minotaur.getEnemyCoordY();
            boolean inX = Math.abs((this.getShiftX() + this.getManCropWidth()) - Minotaur.getEnemyCoordX()  ) < 2 ;

            if (inY1 && inY2 && inX){

                this.manCoordX += this.getMoveSpeed();
            }
        }

    }



}
