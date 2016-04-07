package items;


import contracts.Character;

public class HealthPotion extends Potion {
    int health;

    public HealthPotion(int itemID, int health) {
        super(itemID);
        this.health = health;
    }

    @Override
    public void applyItemEffect(Character character) {
        character.setHealth(this.health);
    }
}
