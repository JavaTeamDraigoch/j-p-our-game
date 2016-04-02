package classes;

import gfx.Assets;
import items.Sword;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Minotaur {

    Animation isMovingUp, isMovingDown, isMovingLeft, isMovingRight;

    private Image enemyIMG;
    private SpriteSheet spriteSheetEnemy;
    private Assets assetsEnemy;

    public float enemyCoordX = 0;
    public  float enemyCoordY = 0;

    private float enemyShiftX = enemyCoordX + 400;
    private float enemyShiftY = enemyCoordY + 300;

    int[] duration = {200,200};

    private int health;
    private int level;
    private int moveSpeed;
    private int meleeAttack;
    private int spellAttack;
    private int armor;
    private int lightRadius;
    private String playerName;
}
