package items;


import contracts.Hero;

public class Sword extends Equipment {
    private int meleeAttack;;
    private int lightRadius;

    public Sword(int itemID, int meleeAttack, int lightRadius) {
        super(itemID);
        this.meleeAttack = meleeAttack;
        this.lightRadius = lightRadius;
    }

    @Override
    public void applyItemEffect(Hero hero) {
        hero.setMeleeAttack(this.meleeAttack);
        hero.setLightRadius(this.lightRadius);
    }
}
