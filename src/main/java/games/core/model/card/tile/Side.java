package games.core.model.card.tile;


/**
 * A side of a tile referencing the tile
 *
 * @param <T> the type of tile
 */
public abstract class Side<T extends Tile<? extends Side<T>>> {
    private final T parent;
    //private Side nextSide; // Unnecessary now

    public Side(T parent) {
        this.parent = parent;
        //this.nextSide = nextSide;
    }

    public T getParent() {
        return parent;
    }

    /*public Side getNextSide() {
        return nextSide;
    }*/

    /*public void setNextSide(Side nextSide) {
        this.nextSide = nextSide;
    }*/
}
