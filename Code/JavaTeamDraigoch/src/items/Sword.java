package items;


import contracts.Character;

public class Sword extends Equipment {
    private int meleeAttack;;
    private int lightRadius;

    public Sword(int itemID, int meleeAttack, int lightRadius) {
        super(itemID);
        this.meleeAttack = meleeAttack;
        this.lightRadius = lightRadius;
    }

    @Override
    public void applyItemEffect(Character character) {
        character.setMeleeAttack(this.meleeAttack);
        character.setLightRadius(this.lightRadius);
    }
}
