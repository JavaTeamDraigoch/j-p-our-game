package items;

import contracts.Item;

/**
 * Created by tadimitrov on 3/28/2016.
 */
public abstract class Potion implements Item {
    private int itemID;

    protected Potion(int itemID) {
        this.itemID = itemID;
    }

    @Override
    public int getItemID() {
        return this.itemID;
    }
}
