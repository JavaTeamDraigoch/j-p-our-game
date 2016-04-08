package characters;

import org.newdawn.slick.*;

public class SwordsMan extends Player {
    private int meleeAttack;

    public SwordsMan(String playerName, int health, float moveSpeed, int armor, int lightRadius, float posX, float posY, int meleeAttack) {
        super(playerName, health, moveSpeed, armor, lightRadius, posX, posY);
        this.meleeAttack = meleeAttack;
    }

    public int getMeleeAttack() {
        return meleeAttack;
    }

    public void setMeleeAttack(int meleeAttack) {
        this.meleeAttack = meleeAttack;
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

            if ((Math.round(this.getManCoordY()) > GameEngine.MOST_UP_COORDINATE)){

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

            if (Math.round(this.getManCoordY()) < GameEngine.MOST_DOWN_COORDINATE){

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

            if (Math.round(this.getManCoordX()) > GameEngine.MOST_LEFT_COORDINATE ){

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

            if (Math.round(this.getManCoordX()) < GameEngine.MOST_RIGHT_COORDINATE){

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
