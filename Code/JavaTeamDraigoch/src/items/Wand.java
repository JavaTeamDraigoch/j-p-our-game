package items;


import contracts.Hero;

public class Wand extends Equipment {
    private int spellAttack;;
    private int lightRadius;

    public Wand(int itemID, int spellAttack, int lightRadius) {
        super(itemID);
        this.spellAttack = spellAttack;
        this.lightRadius = lightRadius;
    }

    @Override
    public void applyItemEffect(Hero hero) {
        hero.setSpellAttack(this.spellAttack);
        hero.setLightRadius(this.lightRadius);
    }
}