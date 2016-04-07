package characters;

import game.Game;
import org.newdawn.slick.*;


public class SwordMan extends Player {
    private final int ANIMATION_DURATION =  200;
    private SpriteSheet spriteSheet;
    private Image image;
    private Animation staying, movingUp, movingDown, movingLeft, movingRight;

    private float height;
    private float width;


    public SwordMan(String playerName, int health, float moveSpeed, int meleeAttack, int spellAttack, int armor, int lightRadius, float posX, float posY,float height, float width, Image image) {
        super(playerName, health, moveSpeed, meleeAttack, spellAttack, armor, lightRadius, posX, posY);
        this.height=height;
        this.width=width;
        this.image = image;// "resources/img/testPlayer.png"
        //this.staying//init
        //this.movingUp//int
    }


       // this.image = new Image("resources/img/testPlayer.png");
        //this.spriteSheetPlayer = new SpriteSheet(this.image,95,587,this.manCropWidth, this.manCropHeight);


    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public void setSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Animation getStaying() {
        return staying;
    }

    public void setStaying(Animation staying) {
        this.staying = staying;
    }

    public Animation getMovingUp() {
        return movingUp;
    }

    public void setMovingUp(Animation movingUp) {
        this.movingUp = movingUp;
    }

    public Animation getMovingDown() {
        return movingDown;
    }

    public void setMovingDown(Animation movingDown) {
        this.movingDown = movingDown;
    }

    public Animation getMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(Animation movingLeft) {
        this.movingLeft = movingLeft;
    }

    public Animation getMovingRight() {
        return movingRight;
    }

    public void setMovingRight(Animation movingRight) {
        this.movingRight = movingRight;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Deprecated
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

       // this.spriteSheetPlayer.getSubImage(95,587,50,114).draw(this.getShiftX(),this.getShiftY());

        //this.movingUp = new Animation(this.getSpriteSheetPlayer(),200);
        //this.movingDown = new Animation(this.getSpriteSheetPlayer(),200);
        //this.movingLeft = new Animation(this.getSpriteSheetPlayer(),200);
        //this.movingRight = new Animation(this.getSpriteSheetPlayer(),200);

        /// get hero coordinates
        //graphics.drawString("hero  manCoordX: " + this.getManCoordX() + "\nhero Y: " + this.getManCoordY(), 0,20);
        //graphics.drawString("hero X: " + this.shiftX + "\nhero Y: " + this.shiftY, 200,20);
    }

    @Deprecated
    public void update(GameContainer gameContainer, int delta) throws SlickException {
/*
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
*/
    }

}
