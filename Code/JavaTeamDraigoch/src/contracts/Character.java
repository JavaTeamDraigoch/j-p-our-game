package contracts;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

/**
 * Created by tadimitrov on 3/28/2016.
 */
public interface Character {
    int getHealth();

    void setHealth(int health);

    int getLevel();

    void setLevel(int level);

    int getExperience();

    void setExperience(int experience);

    float getMoveSpeed();

    void setMoveSpeed(float moveSpeed);

    int getArmor();

    void setArmor(int armor);

    int getLightRadius();

    void setLightRadius(int lightRadius);

    float getPosX();

    void setPosX(float posX);

    float getPosY();

    void setPosY(float posY);

    void setImage(Image image);

    float getImageHeight();

    void setImageHeight(float imageHeight);

    float getImageWidth();

    void setImageWidth(float imageWidth);

    void setSpriteSheet(SpriteSheet spriteSheet);

    SpriteSheet getSpriteSheet();

    Animation getStaying();

    void setStaying(Animation staying);

    Animation getMovingUp();

    void setMovingUp(Animation movingUp);

    Animation getMovingDown();

    void setMovingDown(Animation movingDown);

    Animation getMovingLeft();

    void setMovingLeft(Animation movingLeft);

    Animation getMovingRight();

    void setMovingRight(Animation movingRight);
}
