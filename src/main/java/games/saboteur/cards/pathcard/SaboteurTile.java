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
    private final PathCard type;
    private boolean flipped;

    public SaboteurTile(PathCard pathCard) {
        sides.put(Direction.TOP, new SaboteurSide(pathCard.getPaths()[0]));
        sides.put(Direction.RIGHT, new SaboteurSide(pathCard.getPaths()[1]));
        sides.put(Direction.BOTTOM, new SaboteurSide(pathCard.getPaths()[2]));
        sides.put(Direction.LEFT, new SaboteurSide(pathCard.getPaths()[3]));
        this.hasPath = pathCard.getPaths()[4];
        name = "Path card with " + (hasPath ? "" : "un") + "connected sides : " + sides;
        type = pathCard;
        flipped = false;
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

    @Override
    public void rotate(int nbRotations) {
        if (nbRotations % 2 == 1)
            flipped = !flipped;
        super.rotate(2 * nbRotations);
    }

    public void rotate() {
        rotate(1);
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
        return super.fitsWith(t, d) && ((SaboteurTile) t).hasPath;
        // How could we avoid that cast? can it raise errors?
    }

    @Override
    public String toString() {
        return name;
    }
}
