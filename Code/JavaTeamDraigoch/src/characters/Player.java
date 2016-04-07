package characters;

import contracts.Character;

public abstract class Player implements Character {
    private final int START_LEVEL = 1;
    private final int EXPERIENCE = 1;
    private String playerName;
    private int health;
    private int level;
    private int experience;
    private float moveSpeed;
    private int meleeAttack;
    private int spellAttack;
    private int armor;
    private int lightRadius;
    private float posX;
    private float posY;


    public Player(String playerName, int health, float moveSpeed, int meleeAttack, int spellAttack, int armor, int lightRadius, float posX, float posY) {
        this.playerName = playerName;
        this.health = health;
        this.moveSpeed = moveSpeed;
        this.meleeAttack = meleeAttack;
        this.spellAttack = spellAttack;
        this.armor = armor;
        this.lightRadius = lightRadius;
        this.posX = posX;
        this.posY = posY;
        this.level=START_LEVEL;
        this.experience=EXPERIENCE;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

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

    public int getMeleeAttack() {
        return meleeAttack;
    }

    @Override
    public void setMeleeAttack(int meleeAttack) {
        this.meleeAttack = meleeAttack;
    }

    public int getSpellAttack() {
        return spellAttack;
    }

    @Override
    public void setSpellAttack(int spellAttack) {
        this.spellAttack = spellAttack;
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public void setArmor(int armor) {
        this.armor = armor;
    }

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
        this.posX = posX;
    }

    @Override
    public float getPosY() {
        return posY;
    }

    @Override
    public void setPosY(float posY) {
        this.posY = posY;
    }

}
