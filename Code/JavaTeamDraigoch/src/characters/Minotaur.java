package characters;

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

/*
        if (this.input.isKeyDown(Input.KEY_UP)){

            if (Math.round(SwordsMan.getManCoordY()) < GameEngine.MOST_UP_COORDINATE - 1) {

                this.enemyCoordY += SwordsMan.getMoveSpeed();

            }

            if ((this.getEnemyCoordY() + this.getEnemyCropHeight()) > SwordsMan.getShiftY()){

                //this.enemyCoordY -= SwordsMan.moveSpeed;

                if (this.getEnemyCoordX() <= SwordsMan.getShiftX() + this.getEnemyCropWidth() ){

                    //this.enemyCoordY -= SwordsMan.moveSpeed;

                    if ((this.getEnemyCoordX() + this.getEnemyCropWidth()) >= SwordsMan.getShiftX() ){

                        //this.enemyCoordY -= SwordsMan.moveSpeed;

                        if ((SwordsMan.getShiftY() + SwordsMan.getManCropHeight()) > this.getEnemyCoordY() ){

                            this.enemyCoordY -= SwordsMan.getMoveSpeed();
                        }

                    }
                }


            }

        }

        if (this.input.isKeyDown(Input.KEY_DOWN)){

            if ( Math.round(SwordsMan.getManCoordY()) >= GameEngine.MOST_DOWN_COORDINATE + 1){

                this.enemyCoordY -= SwordsMan.getMoveSpeed();
            }

            boolean inY1 = (this.getEnemyCoordY() + this.getEnemyCropHeight()) > SwordsMan.getShiftY();
            boolean inY2 = (this.getEnemyCoordX() + this.getEnemyCropWidth()) >= SwordsMan.getShiftX();
            boolean inX1 = this.getEnemyCoordX() <= SwordsMan.getShiftX() + this.getEnemyCropWidth();
            boolean inX2 = (this.getEnemyCoordX() + this.getEnemyCropWidth()) >= SwordsMan.getShiftX();

            boolean x1 = SwordsMan.getShiftX() <= (this.getEnemyCoordX() + this.getEnemyCropWidth());
            boolean x2 = this.getEnemyCoordX() <= (SwordsMan.getShiftX() + SwordsMan.getManCropWidth());
            boolean y1 = Math.abs(this.getEnemyCoordY() - (SwordsMan.getShiftY() + SwordsMan.getManCropHeight())) < 2;

            if (x1 && x2 && y1){

                this.enemyCoordY += SwordsMan.getMoveSpeed();
            }

        }

        if (this.input.isKeyDown(Input.KEY_LEFT)){

            if (Math.round(SwordsMan.getManCoordX()) <= GameEngine.MOST_LEFT_COORDINATE - 1){

                this.enemyCoordX += SwordsMan.getMoveSpeed();

            }

            boolean inY1 = this.getEnemyCoordY() <= (SwordsMan.getShiftY() + SwordsMan.getManCropHeight());
            boolean inY2 = (this.getEnemyCoordY() + this.getEnemyCropHeight()) >= SwordsMan.getShiftY();
            boolean inX = Math.abs((this.getEnemyCoordX() + this.getEnemyCropWidth()) - SwordsMan.getShiftX()) < 2;

            if (inY1 && inY2 && inX){

                this.enemyCoordX -= SwordsMan.getMoveSpeed();
            }

        }

        if (this.input.isKeyDown(Input.KEY_RIGHT)){

            if (Math.round(SwordsMan.getManCoordX()) >= GameEngine.MOST_RIGHT_COORDINATE + 1){

                this.enemyCoordX -= SwordsMan.getMoveSpeed();
            }

            boolean inY1 = this.getEnemyCoordY() <= (SwordsMan.getShiftY() + SwordsMan.getManCropHeight());;
            boolean inY2 = (this.getEnemyCoordY() + this.getEnemyCropHeight()) >= SwordsMan.getShiftY();;
            boolean inX = Math.abs((SwordsMan.getShiftX() + SwordsMan.getManCropWidth()) - this.getEnemyCoordX() ) < 2;

            if (inY1 && inY2 && inX){

                this.enemyCoordX += SwordsMan.getMoveSpeed();
            }
        }


        //boolean inRadius = Math.abs(Math.sqrt(Math.pow(SwordsMan.manCoordX - this.enemyCoordX,2) + Math.pow(SwordsMan.manCoordY - this.enemyCoordY, 2))) < 200;

        /// this will be in method ! :) inRadius

        boolean inRadius = Math.abs(SwordsMan.getShiftX() - this.getEnemyCoordX()) < 200 &&
                Math.abs(SwordsMan.getShiftY() - this.getEnemyCoordY()) < 300;



        if (inRadius){

            if (this.getEnemyCoordX() > SwordsMan.getShiftX() + SwordsMan.getManCropWidth()){

                this.enemyCoordX -= this.getMoveSpeed();
            }

            if (this.getEnemyCoordX() + this.getEnemyCropWidth() < SwordsMan.getShiftX()){

                this.enemyCoordX += this.getMoveSpeed();
            }

            if (this.getEnemyCoordY() + this.getEnemyCropHeight() > SwordsMan.getShiftY()){

                this.enemyCoordY -= this.getMoveSpeed();
            }

            if (this.getEnemyCoordY() < SwordsMan.getShiftY() + SwordsMan.getManCropHeight()){

                this.enemyCoordY += this.getMoveSpeed();
            }



        }
*/
    }

}
