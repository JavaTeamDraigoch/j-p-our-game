package manageres;

import java.util.List;

import characters.Enemy;
import characters.Minotaur;
import game.GameEngine;
import org.newdawn.slick.*;
import characters.SwordsMan;
import contracts.Character;

/**
 * Created by TADimitrov on 4/7/2016.
 */
public class SwordsManManager {
    private final int HEALTH = 500;
    private final float MOVE_SPEED = 5f;
    private final int ARMOR = 800;
    private final int LIGHT_RADIUS = 10;
    private final int POS_X = 0;
    private final int POS_Y = 0;
    private final int ANIMATION_DURATION = 500;
    private final int MELEE_ATTACK = 350;
    private final int IMAGE_HEIGHT = 180;
    private final int IMAGE_WIDTH = 156;
    private final int START_POS_X = POS_X + 400 - (IMAGE_WIDTH / 2);
    private final int START_POS_Y = POS_Y + 300 - (IMAGE_HEIGHT / 2);
    private Character character;
    private Input input;
    private boolean walkUp, walkDown, walkLeft, walkRight, stopWalk = true;
    private int[] supportStopWalk = {5 * IMAGE_WIDTH, 1};

    private int moveIndex = 5;
    private int moveIndexI =4;


    public SwordsManManager() {
        this.character = new SwordsMan("Player", HEALTH, MOVE_SPEED, ARMOR, LIGHT_RADIUS, POS_X, POS_Y, MELEE_ATTACK);
        //this.character = new Minotaur("enemy", HEALTH, MOVE_SPEED, ARMOR, LIGHT_RADIUS, POS_X, POS_Y, MELEE_ATTACK);
    }

    public void createCharacter() {
        try {
            this.character.setSpriteSheet(new SpriteSheet("resources/img/Player-Melee-Red.png", START_POS_X, START_POS_Y));
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


        if (stopWalk){
            fps(25);


            character.getSpriteSheet().getSubImage(this.supportStopWalk[0], this.supportStopWalk[1], this.IMAGE_WIDTH, this.IMAGE_HEIGHT).draw(START_POS_X, START_POS_Y);
        }


        if (walkUp){
            stopWalk =false;

            fps(25);

            character.getSpriteSheet()
                    .getSubImage(this.moveIndex * this.IMAGE_WIDTH, 1, this.IMAGE_WIDTH, this.IMAGE_HEIGHT)
                    .draw(START_POS_X, START_POS_Y);

            this.moveIndex++;
            if (this.moveIndex == 8){
                this.moveIndex = 5;
            }
        }
        if (walkDown){
            stopWalk =false;

            fps(25);

            character.getSpriteSheet()
                    .getSubImage(this.moveIndexI * this.IMAGE_WIDTH, this.IMAGE_HEIGHT, this.IMAGE_WIDTH, this.IMAGE_HEIGHT)
                    .draw(START_POS_X, START_POS_Y);

            this.moveIndexI--;
            if (this.moveIndexI == 2){
                this.moveIndexI = 4;
            }

        }
        if (walkLeft){
            stopWalk =false;
            fps(25);

            character.getSpriteSheet()
                    .getSubImage(this.moveIndexI * this.IMAGE_WIDTH, 1, this.IMAGE_WIDTH, this.IMAGE_HEIGHT)
                    .draw(START_POS_X, START_POS_Y);

            this.moveIndexI--;
            if (this.moveIndexI == 2){
                this.moveIndexI = 4;
            }
        }
        if (walkRight){
            stopWalk =false;

            fps(25);

            character.getSpriteSheet().getSubImage(this.moveIndex * this.IMAGE_WIDTH, this.IMAGE_HEIGHT, this.IMAGE_WIDTH, this.IMAGE_HEIGHT).draw(START_POS_X, START_POS_Y);

            this.moveIndex++;

            if (this.moveIndex == 8){
                this.moveIndex = 5;
            }
        }


    }

    public void moveCharacter(GameContainer gameContainer) {
        this.input = gameContainer.getInput();



        if (this.input.isKeyDown(Input.KEY_UP)) {

            this.stopWalk = false;
            this.supportStopWalk[0] = 5 * this.IMAGE_WIDTH;
            this.supportStopWalk[1] = 1;

            this.walkUp = true;

            this.character.setPosY(this.character.getMoveSpeed());
            detectMapBoundies();

            //character.getSpriteSheet().getSubImage(5*156, 1, 156, 180).draw(START_POS_X, START_POS_Y);



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
        } else {
            this.walkUp = false;
            this.stopWalk = true;
        }

        if (this.input.isKeyDown(Input.KEY_DOWN)) {

            this.stopWalk = false;
            this.supportStopWalk[0] = 4 * this.IMAGE_WIDTH;
            this.supportStopWalk[1] = this.IMAGE_HEIGHT;
            this.walkDown = true;

            this.character.setPosY(-this.character.getMoveSpeed());
            detectMapBoundies();

            //Enemy move to detectEnemyCollision
            /*
            boolean betweenXX = (this.getShiftX() + this.getManCropWidth() > Minotaur.getEnemyCoordX()) &&
                    (this.getShiftX() < Minotaur.getEnemyCoordX() + this.getManCropWidth());


            boolean inY = Math.abs((this.getShiftY() + this.getManCropHeight()) - Minotaur.getEnemyCoordY()) < 2;

            if (inY && betweenXX) {

                this.manCoordY += this.getMoveSpeed();

            }
            */
        } else {
            this.walkDown = false;
            this.stopWalk = true;
        }

        if (this.input.isKeyDown(Input.KEY_LEFT)) {

            this.stopWalk = false;
            this.supportStopWalk[0] = 4 * this.IMAGE_WIDTH;
            this.supportStopWalk[1] = 1;
            this.walkLeft = true;
            this.character.setPosX(+this.character.getMoveSpeed());
            detectMapBoundies();

            /*
            boolean inY1 = this.getShiftY() <= (Minotaur.getEnemyCoordY() + Minotaur.getEnemyCropHeight());
            boolean inY2 = (this.getShiftY() + this.getManCropHeight()) >= Minotaur.getEnemyCoordY();
            boolean inX = Math.abs(this.getShiftX() - (Minotaur.getEnemyCoordX() + Minotaur.getEnemyCropWidth())) < 2;

            if (inY1 && inY2 && inX) {
                this.manCoordX -= this.getMoveSpeed();
            }
            */
        } else {
            this.walkLeft = false;
            this.stopWalk = true;
        }

        if (this.input.isKeyDown(Input.KEY_RIGHT)) {

            this.stopWalk = false;
            this.supportStopWalk[0] = 5 * this.IMAGE_WIDTH;
            this.supportStopWalk[1] = this.IMAGE_HEIGHT;
            this.walkRight = true;
            this.character.setPosX(-this.character.getMoveSpeed());
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
        } else {
            this.walkRight = false;
            this.stopWalk = true;
        }

    }

    private void detectEnemyCollision(List<Character> enemies) {
    }

    private void detectMapBoundies() {
        boolean isTopReached = this.character.getPosY() - this.START_POS_Y >= GameEngine.MOST_UP_COORDINATE;
        if (isTopReached) {
            this.character.setPosY(-this.character.getMoveSpeed());
        }

        boolean isBottomReached = this.character.getPosY() - this.START_POS_Y - this.character.getImageHeight() <= GameEngine.MOST_DOWN_COORDINATE;
        if (isBottomReached) {
            this.character.setPosY(+this.character.getMoveSpeed());
        }

        boolean isLeftReached = this.character.getPosX() - this.START_POS_X >= GameEngine.MOST_LEFT_COORDINATE;
        if (isLeftReached) {
            this.character.setPosX(-this.character.getMoveSpeed());
        }

        boolean isRightReached = this.character.getPosX() - this.START_POS_X - this.character.getImageWidth() <= GameEngine.MOST_RIGHT_COORDINATE;
        if (isRightReached) {
            this.character.setPosX(+this.character.getMoveSpeed());
        }
    }

    public Character getCharacter() {
        return character;
    }

    public void fps(int fps){

        //int fps = 10;

        double ticksPerFrame = 1000000000/fps;

        double passedTime = 0;

        long now;
        long lastTimeTicked = System.nanoTime();

        while (true){

            now = System.nanoTime();
            passedTime += (now - lastTimeTicked) / ticksPerFrame;
            lastTimeTicked = now;

            if (passedTime >= 1){

                passedTime--;
                break;
            }


        }
    }
}
