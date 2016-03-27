package classes;


public abstract class Classes {

    private int health;
    private int level;
    private int moveSpeed;
    private int meleeAttack;
    private int spellAttack;
    private int armor;
    private int lightRadius;

    public Classes(int health, int level, int moveSpeed, int meleeAttack, int spellAttack, int armor, int lightRadius) {
        this.health = health;
        this.level = level;
        this.moveSpeed = moveSpeed;
        this.meleeAttack = meleeAttack;
        this.spellAttack = spellAttack;
        this.armor = armor;
        this.lightRadius = lightRadius;
    }
}
