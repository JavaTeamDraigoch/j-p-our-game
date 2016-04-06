package classes;

import game.*;
import game.Game;
import gfx.Assets;
import items.Sword;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.pathfinding.heuristics.ManhattanHeuristic;


public class Minotaur {

    private Animation movingUp, movingDown, movingLeft, movingRight;

    private Image enemyIMG;
    private SpriteSheet spriteSheetEnemy;
    private Assets assetsEnemy;
    private SwordMan swordMan;

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

            if (Math.round(SwordMan.manCoordY) < Game.MOST_UP_COORDINATE - 1) {

                this.enemyCoordY += SwordMan.moveSpeed;

            }

            if ((this.enemyCoordY + this.enemyCropHeight) > SwordMan.shiftY){

                //this.enemyCoordY -= SwordMan.moveSpeed;

                if (this.enemyCoordX <= SwordMan.shiftX + this.enemyCropWidth ){

                    //this.enemyCoordY -= SwordMan.moveSpeed;

                    if ((this.enemyCoordX + this.enemyCropWidth) >= SwordMan.shiftX ){

                        //this.enemyCoordY -= SwordMan.moveSpeed;

                        if ((SwordMan.shiftY + SwordMan.manCropHeight) > this.enemyCoordY ){

                            this.enemyCoordY -= SwordMan.moveSpeed;
                        }

                    }
                }


            }

        }

        if (this.input.isKeyDown(Input.KEY_DOWN)){

            if ( Math.round(SwordMan.manCoordY) >= Game.MOST_DOWN_COORDINATE + 1){

                this.enemyCoordY -= SwordMan.moveSpeed;
            }

            boolean inY1 = (this.enemyCoordY + this.enemyCropHeight) > SwordMan.shiftY;
            boolean inY2 = (this.enemyCoordX + this.enemyCropWidth) >= SwordMan.shiftX;
            boolean inX1 = this.enemyCoordX <= SwordMan.shiftX + this.enemyCropWidth;
            boolean inX2 = (this.enemyCoordX + this.enemyCropWidth) >= SwordMan.shiftX;

            boolean x1 = SwordMan.shiftX <= (this.enemyCoordX + this.enemyCropWidth);
            boolean x2 = this.enemyCoordX <= (SwordMan.shiftX + SwordMan.manCropWidth);
            boolean y1 = Math.abs(this.enemyCoordY - (SwordMan.shiftY + SwordMan.manCropHeight)) < 2;

            if (x1 && x2 && y1){

                this.enemyCoordY += SwordMan.moveSpeed;
            }

        }

        if (this.input.isKeyDown(Input.KEY_LEFT)){

            if (Math.round(SwordMan.manCoordX) <= Game.MOST_LEFT_COORDINATE - 1){

                this.enemyCoordX += SwordMan.moveSpeed;

            }

            boolean inY1 = this.enemyCoordY <= (SwordMan.shiftY + SwordMan.manCropHeight);
            boolean inY2 = (this.enemyCoordY + this.enemyCropHeight) >= SwordMan.shiftY;
            boolean inX = Math.abs((this.enemyCoordX + this.enemyCropWidth) - SwordMan.shiftX) < 2;

            if (inY1 && inY2 && inX){

                this.enemyCoordX -= SwordMan.moveSpeed;
            }

        }

        if (this.input.isKeyDown(Input.KEY_RIGHT)){

            if (Math.round(SwordMan.manCoordX) >= Game.MOST_RIGHT_COORDINATE + 1){

                this.enemyCoordX -= SwordMan.moveSpeed;
            }

            boolean inY1 = this.enemyCoordY <= (SwordMan.shiftY + SwordMan.manCropHeight);;
            boolean inY2 = (this.enemyCoordY + this.enemyCropHeight) >= SwordMan.shiftY;;
            boolean inX = Math.abs((SwordMan.shiftX + SwordMan.manCropWidth) - this.enemyCoordX ) < 2;

            if (inY1 && inY2 && inX){

                this.enemyCoordX += SwordMan.moveSpeed;
            }
        }


        //boolean inRadius = Math.abs(Math.sqrt(Math.pow(SwordMan.manCoordX - this.enemyCoordX,2) + Math.pow(SwordMan.manCoordY - this.enemyCoordY, 2))) < 200;

        /// this will be in method ! :) inRadius

        boolean inRadius = Math.abs(SwordMan.shiftX - this.enemyCoordX) < 200 &&
                Math.abs(SwordMan.shiftY - this.enemyCoordY) < 300;



        if (inRadius){

            if (this.enemyCoordX > SwordMan.shiftX + SwordMan.manCropWidth){

                this.enemyCoordX -= this.moveSpeed;
            }

            if (this.enemyCoordX + this.enemyCropWidth < SwordMan.shiftX){

                this.enemyCoordX += this.moveSpeed;
            }

            if (this.enemyCoordY + this.enemyCropHeight > SwordMan.shiftY){

                this.enemyCoordY -= this.moveSpeed;
            }

            if (this.enemyCoordY < SwordMan.shiftY + SwordMan.manCropHeight){

                this.enemyCoordY += this.moveSpeed;
            }



        }

    }

}
