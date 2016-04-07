package contracts;

import org.newdawn.slick.SpriteSheet;

/**
 * Created by tadimitrov on 3/28/2016.
 */
public interface Character {
    void setHealth(int health);

    void setLevel(int level);

    void setMoveSpeed(float moveSpeed);

    float getMoveSpeed();

    void setMeleeAttack(int meleeAttack);

    void setSpellAttack(int spellAttack);

    SpriteSheet getSpriteSheet();

    void setArmor(int armor);

    void setLightRadius(int lightRadius);

    void setPosX(float posX);

    float getPosX();

    void setPosY(float posY);

    float getPosY();

    float getHeight();

    float getWidth();
}
