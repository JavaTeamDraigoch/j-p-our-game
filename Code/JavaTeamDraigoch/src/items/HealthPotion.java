package items;


import contracts.Hero;

public class HealthPotion extends Potion {
    int health;

    public HealthPotion(int itemID, int health) {
        super(itemID);
        this.health = health;
    }

    @Override
    public void applyItemEffect(Hero hero) {
        hero.setHealth(this.health);
    }
}
