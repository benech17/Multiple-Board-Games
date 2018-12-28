package games.saboteur.cards.pathcard;

import games.common.model.card.tile.Tile;
import games.common.model.card.tile.TileImpl;
import games.common.model.enums.Direction;
import games.saboteur.cards.SaboteurCard;


// TODO: review rotations: there are only two possible orientations
public class SaboteurTile extends TileImpl<SaboteurSide> implements SaboteurCard {
    protected String name;
    protected boolean hidden = false;
    private final boolean hasPath;

    public SaboteurTile(PathCard pathCard) {
        sides.put(Direction.TOP, new SaboteurSide(this, pathCard.getPaths()[0]));
        sides.put(Direction.RIGHT, new SaboteurSide(this, pathCard.getPaths()[1]));
        sides.put(Direction.BOTTOM, new SaboteurSide(this, pathCard.getPaths()[2]));
        sides.put(Direction.LEFT, new SaboteurSide(this, pathCard.getPaths()[3]));
        this.hasPath = pathCard.getPaths()[4];
        name = "Path card with " + (hasPath ? "" : "un") + "connected sides : " + sides;
    }

    public SaboteurTile(PathCard pathCard, boolean hidden) {
        this(pathCard);
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void reveal() {
        if (hidden)
            hidden = false;
        else
            throw new PathCardException.CantRevealHiddenCardException();
    }

    /*public boolean treasureReached() {
        return findGoal(node -> (node instanceof TreasureCard));
    }*/

    public boolean isHasPath() {
        return hasPath;
    }

    @Override
    public boolean fitsWith(Tile t, Direction d) {
        // We can't put a card if the other has paths
        // which don't connect
        System.out.println(super.fitsWith(t, d));
        System.out.println(((SaboteurTile) t).hasPath);
        return super.fitsWith(t, d) && ((SaboteurTile) t).hasPath;
        // How could we avoid that cast? can it raise errors?
    }

    @Override
    public String toString() {
        return name;
    }
}
