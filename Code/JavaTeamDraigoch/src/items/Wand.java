package items;


import contracts.Character;

public class Wand extends Equipment {
    private int spellAttack;;
    private int lightRadius;

    public Wand(int itemID, int spellAttack, int lightRadius) {
        super(itemID);
        this.spellAttack = spellAttack;
        this.lightRadius = lightRadius;
    }

    @Override
    public void applyItemEffect(Character character) {
        character.setSpellAttack(this.spellAttack);
        character.setLightRadius(this.lightRadius);
    }
}