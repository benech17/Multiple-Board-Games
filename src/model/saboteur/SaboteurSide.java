package model.saboteur;

import model.core.card.tile.Side;
import model.core.card.tile.Tile;

public class SaboteurSide extends Side {
    private boolean hasPath;

    public SaboteurSide(Tile parent, boolean hasPath) {
        super(parent, null);
        this.hasPath = hasPath;
    }

    @Override
    public String toString() {
        return "SaboteurSide{" + hasPath + "}";
    }
}
