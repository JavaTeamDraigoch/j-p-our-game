package gfx;


public class Assets {

    // configure all images paths here

    String pMeleeImg = "/img/Player-Melee-Red.png";
    String prMageImg = "/img/Player-Mage-Green.png";

    String eMageImg = "/img/Enemy-Mage-Purple.png";
    String eMeleeImg = "/img/Enemy-Melle-Teal.png";
    String eBossImg = "/img/Enemy-Boss-Blue.png";

    String WorldImg = "/img/World.png";

    String background = "/img/basicGrid20x20.png";


    //define method for all animations gChar(
    //                                  interfaceID(player type, enemy type),
    //                                  directionFacing,
    //                                  heroState(weapon,attack)
    //                                  )

    // all characters will call this method for their movements graphics.

    // define crop area and animation for BasicWalk
    // define crop areas and animation for BasicAttack
    // define crop areas and animation for SupperWalk
    // define crop areas and animation for SuperAttack




    // define method for all Item images gItems(itemID)
    // item 1 - health
    // item 2 - sword
    // item 3 - wand
    // item 4 - armor
    // item 5 -
    // item 6 - reserved for Enemy Spawn
    // item 7 - reserved for Boss spawn
    // item 8 - reserved for exit tile
    // item 9 - reserved for player spawn





    // define method for cropping all world tiles gTiles(tileID)
    // tile 1 - grass
    // tile 2 - sand
    // tile 3 - path
    // tile 4 - stone
    // tile 5 - tbd
    // tile 6 - small rubble (impassable)
    // tile 7 - large rubble (impassable)
    // tile 8 - exit door
    // tile 9 - wall (impassable)




}
