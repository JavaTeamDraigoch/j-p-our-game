package characters;

import game.Game;
import gfx.Assets;
import org.newdawn.slick.*;


public class Minotaur {

    private Animation movingUp, movingDown, movingLeft, movingRight;
    private Image enemyIMG;
    private SpriteSheet spriteSheetEnemy;
    private Assets assetsEnemy;

    public static float enemyCoordX = 0;
    public static float enemyCoordY = 0;

    public static int enemyCropWidth ;
    public static int enemyCropHeight;

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

        this.enemyCropWidth = 50;
        this.enemyCropHeight = 75;

        this.moveSpeed = 0.05;

        this.enemyIMG = new Image("resources/img/m.png");
        this.spriteSheetEnemy = new SpriteSheet(this.enemyIMG,0,0,this.enemyCropHeight,this.enemyCropHeight);
        this.assetsEnemy = new Assets();

    }

    public static float getEnemyCoordX() {
        return enemyCoordX;
    }

    public static float getEnemyCoordY() {
        return enemyCoordY;
    }

    public static int getEnemyCropWidth() {
        return enemyCropWidth;
    }

    public static int getEnemyCropHeight() {
        return enemyCropHeight;
    }

    public double getMoveSpeed() {
        return moveSpeed;
    }

    public Animation getMovingUp() {
        return movingUp;
    }

    public Animation getMovingDown() {
        return movingDown;
    }

    public Animation getMovingLeft() {
        return movingLeft;
    }

    public Animation getMovingRight() {
        return movingRight;
    }

    public Input getInput() {
        return input;
    }

    public SpriteSheet getSpriteSheetEnemy() {
        return spriteSheetEnemy;
    }

    public void init(GameContainer gameContainer) throws SlickException {


    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        this.spriteSheetEnemy.getSubImage(0,0,50,75).draw(this.getEnemyCoordX(), this.getEnemyCoordY());

        this.movingUp = new Animation(this.getSpriteSheetEnemy(),100);
        this.movingDown = new Animation(this.getSpriteSheetEnemy(),100);
        this.movingLeft = new Animation(this.getSpriteSheetEnemy(),100);
        this.movingRight = new Animation(this.getSpriteSheetEnemy(),100);

        // test enemy coordinates
        //graphics.drawString("enemy X: " + this.getEnemyCoordX() + "\nenemy Y: " + this.getEnemyCoordY(), 500,20);

    }

    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.input = gameContainer.getInput();


        if (this.input.isKeyDown(Input.KEY_UP)){

            if (Math.round(SwordMan.getManCoordY()) < Game.MOST_UP_COORDINATE - 1) {

                this.enemyCoordY += SwordMan.getMoveSpeed();

            }

            if ((this.getEnemyCoordY() + this.getEnemyCropHeight()) > SwordMan.getShiftY()){

                //this.enemyCoordY -= SwordMan.moveSpeed;

                if (this.getEnemyCoordX() <= SwordMan.getShiftX() + this.getEnemyCropWidth() ){

                    //this.enemyCoordY -= SwordMan.moveSpeed;

                    if ((this.getEnemyCoordX() + this.getEnemyCropWidth()) >= SwordMan.getShiftX() ){

                        //this.enemyCoordY -= SwordMan.moveSpeed;

                        if ((SwordMan.getShiftY() + SwordMan.getManCropHeight()) > this.getEnemyCoordY() ){

                            this.enemyCoordY -= SwordMan.getMoveSpeed();
                        }

                    }
                }


            }

        }

        if (this.input.isKeyDown(Input.KEY_DOWN)){

            if ( Math.round(SwordMan.getManCoordY()) >= Game.MOST_DOWN_COORDINATE + 1){

                this.enemyCoordY -= SwordMan.getMoveSpeed();
            }

            boolean inY1 = (this.getEnemyCoordY() + this.getEnemyCropHeight()) > SwordMan.getShiftY();
            boolean inY2 = (this.getEnemyCoordX() + this.getEnemyCropWidth()) >= SwordMan.getShiftX();
            boolean inX1 = this.getEnemyCoordX() <= SwordMan.getShiftX() + this.getEnemyCropWidth();
            boolean inX2 = (this.getEnemyCoordX() + this.getEnemyCropWidth()) >= SwordMan.getShiftX();

            boolean x1 = SwordMan.getShiftX() <= (this.getEnemyCoordX() + this.getEnemyCropWidth());
            boolean x2 = this.getEnemyCoordX() <= (SwordMan.getShiftX() + SwordMan.getManCropWidth());
            boolean y1 = Math.abs(this.getEnemyCoordY() - (SwordMan.getShiftY() + SwordMan.getManCropHeight())) < 2;

            if (x1 && x2 && y1){

                this.enemyCoordY += SwordMan.getMoveSpeed();
            }

        }

        if (this.input.isKeyDown(Input.KEY_LEFT)){

            if (Math.round(SwordMan.getManCoordX()) <= Game.MOST_LEFT_COORDINATE - 1){

                this.enemyCoordX += SwordMan.getMoveSpeed();

            }

            boolean inY1 = this.getEnemyCoordY() <= (SwordMan.getShiftY() + SwordMan.getManCropHeight());
            boolean inY2 = (this.getEnemyCoordY() + this.getEnemyCropHeight()) >= SwordMan.getShiftY();
            boolean inX = Math.abs((this.getEnemyCoordX() + this.getEnemyCropWidth()) - SwordMan.getShiftX()) < 2;

            if (inY1 && inY2 && inX){

                this.enemyCoordX -= SwordMan.getMoveSpeed();
            }

        }

        if (this.input.isKeyDown(Input.KEY_RIGHT)){

            if (Math.round(SwordMan.getManCoordX()) >= Game.MOST_RIGHT_COORDINATE + 1){

                this.enemyCoordX -= SwordMan.getMoveSpeed();
            }

            boolean inY1 = this.getEnemyCoordY() <= (SwordMan.getShiftY() + SwordMan.getManCropHeight());;
            boolean inY2 = (this.getEnemyCoordY() + this.getEnemyCropHeight()) >= SwordMan.getShiftY();;
            boolean inX = Math.abs((SwordMan.getShiftX() + SwordMan.getManCropWidth()) - this.getEnemyCoordX() ) < 2;

            if (inY1 && inY2 && inX){

                this.enemyCoordX += SwordMan.getMoveSpeed();
            }
        }


        //boolean inRadius = Math.abs(Math.sqrt(Math.pow(SwordMan.manCoordX - this.enemyCoordX,2) + Math.pow(SwordMan.manCoordY - this.enemyCoordY, 2))) < 200;

        /// this will be in method ! :) inRadius

        boolean inRadius = Math.abs(SwordMan.getShiftX() - this.getEnemyCoordX()) < 200 &&
                Math.abs(SwordMan.getShiftY() - this.getEnemyCoordY()) < 300;



        if (inRadius){

            if (this.getEnemyCoordX() > SwordMan.getShiftX() + SwordMan.getManCropWidth()){

                this.enemyCoordX -= this.getMoveSpeed();
            }

            if (this.getEnemyCoordX() + this.getEnemyCropWidth() < SwordMan.getShiftX()){

                this.enemyCoordX += this.getMoveSpeed();
            }

            if (this.getEnemyCoordY() + this.getEnemyCropHeight() > SwordMan.getShiftY()){

                this.enemyCoordY -= this.getMoveSpeed();
            }

            if (this.getEnemyCoordY() < SwordMan.getShiftY() + SwordMan.getManCropHeight()){

                this.enemyCoordY += this.getMoveSpeed();
            }



        }

    }

}
