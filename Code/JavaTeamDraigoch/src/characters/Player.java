package characters;

import contracts.Character;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public abstract class Player implements Character {
    private final int START_LEVEL = 1;
    private final int EXPERIENCE = 0;
    private String playerName;
    private int health;
    private int level;
    private int experience;
    private float moveSpeed;
    private int armor;
    private int lightRadius;
    private float posX;
    private float posY;
    private Image image;
    private float imageHeight;
    private float imageWidth;
    private SpriteSheet spriteSheet;
    private Animation staying, movingUp, movingDown, movingLeft, movingRight;

    public Player(String playerName, int health, float moveSpeed, int armor, int lightRadius, float posX, float posY) {
        this.playerName = playerName;
        this.health = health;
        this.level = START_LEVEL;
        this.experience = EXPERIENCE;
        this.moveSpeed = moveSpeed;
        this.armor = armor;
        this.lightRadius = lightRadius;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public float getMoveSpeed() {
        return moveSpeed;
    }

    @Override
    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public int getLightRadius() {
        return lightRadius;
    }

    @Override
    public void setLightRadius(int lightRadius) {
        this.lightRadius = lightRadius;
    }

    @Override
    public float getPosX() {
        return posX;
    }

    @Override
    public void setPosX(float posX) {
        this.posX += posX;
    }

    @Override
    public float getPosY() {
        return posY;
    }

    @Override
    public void setPosY(float posY) {
        this.posY += posY;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public float getImageHeight() {
        return imageHeight;
    }

    @Override
    public void setImageHeight(float imageHeight) {
        this.imageHeight = imageHeight;
    }

    @Override
    public float getImageWidth() {
        return imageWidth;
    }

    @Override
    public void setImageWidth(float imageWidth) {
        this.imageWidth = imageWidth;
    }

    @Override
    public void setSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    @Override
    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    @Override
    public Animation getStaying() {
        return staying;
    }

    @Override
    public void setStaying(Animation staying) {
        this.staying = staying;
    }

    @Override
    public Animation getMovingUp() {
        return movingUp;
    }

    @Override
    public void setMovingUp(Animation movingUp) {
        this.movingUp = movingUp;
    }

    @Override
    public Animation getMovingDown() {
        return movingDown;
    }

    @Override
    public void setMovingDown(Animation movingDown) {
        this.movingDown = movingDown;
    }

    @Override
    public Animation getMovingLeft() {
        return movingLeft;
    }

    @Override
    public void setMovingLeft(Animation movingLeft) {
        this.movingLeft = movingLeft;
    }

    @Override
    public Animation getMovingRight() {
        return movingRight;
    }

    @Override
    public void setMovingRight(Animation movingRight) {
        this.movingRight = movingRight;
    }
}
