package characters;

/**
 * Created by TADimitrov on 4/8/2016.
 */
public class Mage extends Player {
    private int spellAttack;

    public Mage(String playerName, int health, float moveSpeed, int armor, int lightRadius, float posX, float posY, int spellAttack) {
        super(playerName, health, moveSpeed, armor, lightRadius, posX, posY);
        this.spellAttack = spellAttack;
    }

    public int getSpellAttack() {
        return spellAttack;
    }

    public void setSpellAttack(int meleeAttack) {
        this.spellAttack = meleeAttack;
    }
}
