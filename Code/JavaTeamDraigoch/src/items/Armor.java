package items;


import contracts.Hero;

public class Armor extends Equipment {

    private int health;
    private int moveSpeed;
    private int armor;

    public Armor(int itemID, int health, int armor, int moveSpeed) {
        super(itemID);
        this.health = health;
        this.moveSpeed = moveSpeed;
        this.armor = armor;
    }

    @Override
    public void applyItemEffect(Hero hero) {
        hero.setHealth(this.health);
        hero.setMoveSpeed(this.moveSpeed);
        hero.setArmor(this.armor);
    }
}
