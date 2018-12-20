package games.saboteur;

import games.core.model.card.tile.AbstractTile;
import games.core.model.card.tile.Tile;
import games.core.model.enums.Direction;


/**
 * TODO: Implement Iterable? in the abstract class AbstractTile?
 */
public abstract class SaboteurTile extends AbstractTile<SaboteurSide> {
    private final boolean hasPath;

    public SaboteurTile(boolean hasPath) {
        this.hasPath = hasPath;
    }

    public boolean treasureReached() {
        return findGoal(node -> (node instanceof TreasureCard));
    }

    public boolean isHasPath() {
        return hasPath;
    }

    @Override
    public boolean fitsWith(Tile t, Direction d) {
        // We can't put a card if the other has paths
        // which don't connect
        return super.fitsWith(t, d) && hasPath;

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
