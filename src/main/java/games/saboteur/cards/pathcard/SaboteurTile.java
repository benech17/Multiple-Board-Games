package games.saboteur.cards.pathcard;

import games.core.model.card.tile.Tile;
import games.core.model.card.tile.TileImpl;
import games.core.model.enums.Direction;
import games.saboteur.cards.SaboteurCard;


public class SaboteurTile extends TileImpl<SaboteurSide> implements SaboteurCard {
    private String name;
    protected boolean hidden = false;
    private final boolean hasPath;

    public SaboteurTile(PathCard pathCard) {
        sides.put(Direction.TOP, new SaboteurSide(this, pathCard.getPaths()[0]));
        sides.put(Direction.RIGHT, new SaboteurSide(this, pathCard.getPaths()[1]));
        sides.put(Direction.BOTTOM, new SaboteurSide(this, pathCard.getPaths()[2]));
        sides.put(Direction.LEFT, new SaboteurSide(this, pathCard.getPaths()[3]));
        this.hasPath = pathCard.getPaths()[4];
    }

    public SaboteurTile(PathCard pathCard, boolean hidden) {
        this(pathCard);
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void reveal() {
        if (hidden)
            hidden = false;
        else
            throw new CantRevealHiddenCardException();
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
        System.out.println(super.fitsWith(t, d));
        System.out.println(((SaboteurTile) t).hasPath);
        return super.fitsWith(t, d) && ((SaboteurTile) t).hasPath;
        // How could we avoid that cast? can it raise errors?
    }

    @Override
    public String toString() {
        return "Path card with " + (hasPath ? "" : "un") + "connected sides : " + sides;
    }
}
