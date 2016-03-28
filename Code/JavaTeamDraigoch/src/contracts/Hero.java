package contracts;

/**
 * Created by tadimitrov on 3/28/2016.
 */
public interface Hero {
    void setHealth(int health);

    void setLevel(int level);

    void setMoveSpeed(int moveSpeed);

    void setMeleeAttack(int meleeAttack);

    void setSpellAttack(int spellAttack);

    void setArmor(int armor);

    void setLightRadius(int lightRadius);
}
