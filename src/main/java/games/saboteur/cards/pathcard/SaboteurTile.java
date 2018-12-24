package games.saboteur.cards.pathcard;

import games.core.model.card.tile.DefaultTileImpl;
import games.core.model.card.tile.Tile;
import games.core.model.enums.Direction;


public class SaboteurTile extends DefaultTileImpl<SaboteurSide> {
    private final boolean hasPath;

    public SaboteurTile(PathCard pathCard) {
        sides.put(Direction.TOP, new SaboteurSide(this, pathCard.getPaths()[0]));
        sides.put(Direction.RIGHT, new SaboteurSide(this, pathCard.getPaths()[1]));
        sides.put(Direction.BOTTOM, new SaboteurSide(this, pathCard.getPaths()[2]));
        sides.put(Direction.LEFT, new SaboteurSide(this, pathCard.getPaths()[3]));
        this.hasPath = pathCard.getPaths()[4];
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
        return super.fitsWith(t, d) && ((SaboteurTile) t).hasPath;
        // How could we avoid that cast? can it raise errors?
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
