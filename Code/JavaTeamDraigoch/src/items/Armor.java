package items;


import contracts.Character;

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
    public void applyItemEffect(Character character) {
        character.setHealth(this.health);
        character.setMoveSpeed(this.moveSpeed);
        character.setArmor(this.armor);
    }
}
