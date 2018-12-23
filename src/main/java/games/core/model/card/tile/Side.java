package games.core.model.card.tile;


public abstract class Side {
    private final DefaultTileImpl parent;
    private Side nextSide; // Unnecessary now

    public Side(DefaultTileImpl parent, Side nextSide) {
        this.parent = parent;
        this.nextSide = nextSide;
    }

    public DefaultTileImpl getParent() {
        return parent;
    }

    public Side getNextSide() {
        return nextSide;
    }

    public void setNextSide(Side nextSide) {
        this.nextSide = nextSide;
    }
}
