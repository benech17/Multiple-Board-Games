package model.core.card.tile;


public abstract class Side {
    private Tile parent;
    private Side nextSide;

    public Side(Tile parent, Side nextSide) {
        this.parent = parent;
        this.nextSide = nextSide;
    }

    public Tile getParent() {
        return parent;
    }

    public void setParent(Tile parent) {
        this.parent = parent;
    }

    public Side getNextSide() {
        return nextSide;
    }

    public void setNextSide(Side nextSide) {
        this.nextSide = nextSide;
    }
}
