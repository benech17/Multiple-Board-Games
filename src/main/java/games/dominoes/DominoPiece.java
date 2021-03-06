package games.dominoes;

import games.common.model.board.Coordinate;
import games.common.model.enums.Direction;


/**
 * A domino piece is made of two domino tiles.
 * <p>
 * The orientation of the domino piece is determined by the position of
 * the second tile with respect to the first tile (TOP, RIGHT, BOTTOM, LEFT).
 */
public class DominoPiece<T extends DominoTile> {
    private T tile1;
    private T tile2;
    private Direction orientation;
    private Coordinate tile2Position;

    /**
     * By default the piece is oriented to the top
     */
    public DominoPiece(T tile1, T tile2) {
        this(tile1, tile2, Direction.TOP);

    }

    public DominoPiece(T tile1, T tile2, Direction orientation) {
        this.tile1 = tile1;
        this.tile2 = tile2;
        this.orientation = orientation;
        tile2Position = orientation.getRelativeCoordinates();
    }

    public void rotate(Direction d) {
        orientation = d;
        this.tile2Position = orientation.getRelativeCoordinates();
    }

    public T getTile1() {
        return tile1;
    }

    public T getTile2() {
        return tile2;
    }

    public Direction getOrientation() {
        return orientation;
    }

    public Coordinate getTile2Position() {
        return tile2Position;
    }

    @Override
    public String toString() {
        return "DominoPiece{" +
                "tile1=" + tile1 +
                ", tile2=" + tile2 +
                ", orientation=" + orientation +
                ", tile2Position=" + tile2Position +
                '}';
    }
}
