package games.core.model.card.tile;


public abstract class Side {
    private final AbstractTile parent;
    private Side nextSide;

    public Side(AbstractTile parent, Side nextSide) {
        this.parent = parent;
        this.nextSide = nextSide;
    }

    public AbstractTile getParent() {
        return parent;
    }

    public Side getNextSide() {
        return nextSide;
    }

    public void setNextSide(Side nextSide) {
        this.nextSide = nextSide;
    }
}
