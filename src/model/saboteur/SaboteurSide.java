package model.saboteur;

import model.core.card.tile.AbstractTile;
import model.core.card.tile.Side;

public class SaboteurSide extends Side {
    private boolean hasPath;

    public SaboteurSide(AbstractTile parent, boolean hasPath) {
        super(parent, null);
        this.hasPath = hasPath;
    }

    @Override
    public String toString() {
        return "SaboteurSide{" + hasPath + "}";
    }
}
