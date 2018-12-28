package games.dominoeswithstickers;

import games.core.model.board.Coordinate;
import games.core.model.enums.Color;
import games.core.model.enums.Direction;
import games.core.model.enums.Shape;


/**
 * A domino sticker piece is made of two domino sticker tiles that implement
 * the Tile interface.
 * <p>
 * The orientation of the domino sticker piece is determined by the position of
 * the second tile with respect to the first tile (TOP, RIGHT, BOTTOM, LEFT).
 */
public class DominoStickerPiece {
    private DominoStickerTile tile1;
    private DominoStickerTile tile2;
    private Direction side2Direction;
    private Coordinate side2Position;

    public DominoStickerPiece(Shape shape1, Color color1, Shape shape2, Color color2) {
        tile1 = new DominoStickerTile(shape1, color1, this);
        tile2 = new DominoStickerTile(shape2, color2, this);
        side2Direction = Direction.TOP;
        side2Position = side2Direction.getRelativeCoordinates();
    }

    public void rotate(Direction d) {
        side2Direction = d;
        side2Position = side2Direction.getRelativeCoordinates();
    }

    public DominoStickerTile getTile1() {
        return tile1;
    }

    public DominoStickerTile getTile2() {
        return tile2;
    }

    public Direction getSide2Direction() {
        return side2Direction;
    }

    public Coordinate getSide2Position() {
        return side2Position;
    }
}
