package model.core.card.tile;


public abstract class Side {
    private AbstractTile parent;
    private Side nextSide;

    public Side(AbstractTile parent, Side nextSide) {
        this.parent = parent;
        this.nextSide = nextSide;
    }

    public AbstractTile getParent() {
        return parent;
    }

    public void setParent(AbstractTile parent) {
        this.parent = parent;
    }

    public Side getNextSide() {
        return nextSide;
    }

    public void setNextSide(Side nextSide) {
        this.nextSide = nextSide;
    }
}
