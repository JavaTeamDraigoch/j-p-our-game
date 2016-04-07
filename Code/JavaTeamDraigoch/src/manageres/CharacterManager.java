package manageres;

import characters.SwordMan;
import contracts.Character;
import org.newdawn.slick.Animation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TADimitrov on 4/7/2016.
 */
public class CharacterManager {
    private List<Character> characters;
    private Character character;

    public CharacterManager() {
        this.characters = new ArrayList<>();
    }

    public void createCharacter(){
        //this.character= new SwordMan();
    }

    public void drawCharacter(){
        character.getSpriteSheet().getSubImage(95,587,50,114).draw(character.getPosX(),character.getPosY());
         /* FIX
        character.get = new Animation(this.getSpriteSheetPlayer(),200);
        this.movingDown = new Animation(this.getSpriteSheetPlayer(),200);
        this.movingLeft = new Animation(this.getSpriteSheetPlayer(),200);
        this.movingRight = new Animation(this.getSpriteSheetPlayer(),200);
        */

    }

    public void moveCharacter(){

    }

    public boolean detectEnemyCollision(List<Character> enemies){
        return true;
    }
}
