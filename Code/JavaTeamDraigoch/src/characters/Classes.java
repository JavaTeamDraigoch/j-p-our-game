package characters;


public abstract class Classes {

    private int health;
    private int level;
    private int moveSpeed;
    private int attack;
    //private int spellAttack;
    private int armor;
    private int lightRadius;

    public Classes(int health, int level, int moveSpeed, int meleeAttack, int spellAttack, int armor, int lightRadius) {
        this.health = health;
        this.level = level;
        this.moveSpeed = moveSpeed;
        this.attack = meleeAttack;
        //this.spellAttack = spellAttack;
        this.armor = armor;
        this.lightRadius = lightRadius;
    }
}
