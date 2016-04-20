package manageres;

import characters.Minotaur;
import characters.Player;
import characters.SwordsMan;
import contracts.Character;
import game.GameEngine;
import game.states.Play;
import org.newdawn.slick.*;

/**
 * Created by TADimitrov on 4/8/2016.
 */
public class EnemiesManager {

    private final int HEALTH = 500;
    private final float MOVE_SPEED = 0.1f;
    private final int ARMOR = 800;
    private final int LIGHT_RADIUS = 10;
    private final int POS_X = 30;
    private final int POS_Y = 30;
    private final int ANIMATION_DURATION = 200;
    private final int MELEE_ATTACK = 350;
    private final int IMAGE_HEIGHT = 75;
    private final int IMAGE_WIDTH = 50;
    private Character character;
    private Input input;

    public EnemiesManager() {
        this.character = new Minotaur("Enemy", HEALTH, MOVE_SPEED, ARMOR, LIGHT_RADIUS, POS_X, POS_Y, MELEE_ATTACK);

    }

    public void createCharacter() {
        try {
            this.character.setSpriteSheet(new SpriteSheet("resources/img/m.png", POS_X, POS_Y));
            this.character.setImageHeight(IMAGE_HEIGHT);
            this.character.setImageWidth(IMAGE_WIDTH);
        } catch (SlickException e) {
            e.printStackTrace();
        }

        this.character.setStaying(new Animation(this.character.getSpriteSheet(), this.ANIMATION_DURATION));
        this.character.setMovingUp(new Animation(this.character.getSpriteSheet(), this.ANIMATION_DURATION));
        this.character.setMovingDown(new Animation(this.character.getSpriteSheet(), this.ANIMATION_DURATION));
        this.character.setMovingLeft(new Animation(this.character.getSpriteSheet(), this.ANIMATION_DURATION));
        this.character.setMovingRight(new Animation(this.character.getSpriteSheet(), this.ANIMATION_DURATION));
    }

    public void drawCharacter() {
        character.getSpriteSheet().getSubImage(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT).draw(this.character.getPosX(), this.character.getPosY());
    }

    public void moveCharacter(GameContainer gameContainer) {
        this.input = gameContainer.getInput();

        if (this.input.isKeyDown(Input.KEY_UP)) {
            this.character.setPosY(5f);   /// ако позицията на героя по Y намалява то позицията на ЕНЕМИ се променя
            detectMapBoundies();

            /// tova e za triene --- samo gledam ot nego
//            if (Math.round(SwordsMan.getManCoordY()) < GameEngine.MOST_UP_COORDINATE - 1) {
//
//                this.enemyCoordY += SwordsMan.getMoveSpeed();
//
//            }
//            if (this.character.getPosY() < GameEngine.MOST_UP_COORDINATE - 1){
//
//                this.character.setPosY(0.2f);
//            }

            //Enemy move to detectEnemyCollision
            /*
            boolean betweenYY = (this.getShiftY() < Minotaur.getEnemyCoordY() + Minotaur.getEnemyCropHeight()) &&
                    (Minotaur.getEnemyCoordY() - this.getShiftY() < Minotaur.getEnemyCropHeight());

            boolean betweenXX = (this.getShiftX() + this.getManCropWidth() > Minotaur.getEnemyCoordX()) &&
                    (this.getShiftX() < Minotaur.getEnemyCoordX() + this.getManCropWidth());

            if (betweenYY && betweenXX) {

                this.manCoordY -= this.getMoveSpeed();

            }
            */
        }

        if (this.input.isKeyDown(Input.KEY_DOWN)) {
            this.character.setPosY(-5f);
            detectMapBoundies();

//            if (this.character.getPosY() < GameEngine.MOST_UP_COORDINATE - 1){
//
//                this.character.setPosY(0.2f);
//            }

            //Enemy move to detectEnemyCollision
            /*
            boolean betweenXX = (this.getShiftX() + this.getManCropWidth() > Minotaur.getEnemyCoordX()) &&
                    (this.getShiftX() < Minotaur.getEnemyCoordX() + this.getManCropWidth());


            boolean inY = Math.abs((this.getShiftY() + this.getManCropHeight()) - Minotaur.getEnemyCoordY()) < 2;

            if (inY && betweenXX) {

                this.manCoordY += this.getMoveSpeed();

            }
            */
        }

        if (this.input.isKeyDown(Input.KEY_LEFT)) {
            this.character.setPosX(5f);
            detectMapBoundies();

            /*
            boolean inY1 = this.getShiftY() <= (Minotaur.getEnemyCoordY() + Minotaur.getEnemyCropHeight());
            boolean inY2 = (this.getShiftY() + this.getManCropHeight()) >= Minotaur.getEnemyCoordY();
            boolean inX = Math.abs(this.getShiftX() - (Minotaur.getEnemyCoordX() + Minotaur.getEnemyCropWidth())) < 2;

            if (inY1 && inY2 && inX) {
                this.manCoordX -= this.getMoveSpeed();
            }
            */
        }

        if (this.input.isKeyDown(Input.KEY_RIGHT)) {
            this.character.setPosX(-5f);
            detectMapBoundies();

            //Enemy move to detectEnemyCollision
            /*
            boolean inY1 = this.getShiftY() <= (Minotaur.getEnemyCoordY() + Minotaur.getEnemyCropHeight());
            boolean inY2 = (this.getShiftY() + this.getManCropHeight()) >= Minotaur.getEnemyCoordY();
            boolean inX = Math.abs((this.getShiftX() + this.getManCropWidth()) - Minotaur.getEnemyCoordX()) < 2;

            if (inY1 && inY2 && inX) {

                this.manCoordX += this.getMoveSpeed();
            }
            */
        }
    }

    private void detectMapBoundies() {
        boolean isTopReached = this.character.getPosY() - this.POS_Y >= GameEngine.MOST_UP_COORDINATE;
        //boolean isTopReached = this.getCharacter().getPosY() - this.
        if (isTopReached) {
            //this.character.setPosY(-0.2f);  /// ako Swordman isTopReach = true -> enemy.setPosY(+- 0.2f)
        }



        boolean isBottomReached = this.character.getPosY() - this.POS_Y - this.character.getImageHeight() <= GameEngine.MOST_DOWN_COORDINATE;
        if (isBottomReached) {
            //this.character.setPosY(0.2f);
        }

        boolean isLeftReached = this.character.getPosX() - this.POS_X >= GameEngine.MOST_LEFT_COORDINATE;
        if (isLeftReached) {
            //this.character.setPosX(-0.2f);
        }

        boolean isRightReached = this.character.getPosX() - this.POS_X - this.character.getImageWidth() <= GameEngine.MOST_RIGHT_COORDINATE;
        if (isRightReached) {
            //this.character.setPosX(0.2f);
        }
    }

    public Character getCharacter() {
        return character;
    }


}
