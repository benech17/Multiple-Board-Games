package games.core.model.card.tile;


public abstract class Side {
    private final TileImpl parent;
    private Side nextSide; // Unnecessary now

    public Side(TileImpl parent, Side nextSide) {
        this.parent = parent;
        this.nextSide = nextSide;
    }

    public TileImpl getParent() {
        return parent;
    }

    public Side getNextSide() {
        return nextSide;
    }

    public void setNextSide(Side nextSide) {
        this.nextSide = nextSide;
    }
}
