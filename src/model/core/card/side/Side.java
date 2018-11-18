package model.core.card.side;

import model.core.card.tile.Tile;

public abstract class Side implements Cloneable {
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

    @Override
    protected Side clone() throws CloneNotSupportedException {
        return (Side) super.clone();
    }
}
