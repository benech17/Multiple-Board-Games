package games.dominoeswithstickers;

import games.common.model.card.tile.TileImpl;
import games.common.model.enums.Color;
import games.common.model.enums.Direction;
import games.common.model.enums.Shape;


/**
 * A domino sticker tile is made of two domino sticker sides that implement
 * the Tile interface.
 * <p>
 * The orientation of the domino sticker side is determined by the position of
 * the second side with respect to the first side (TOP, RIGHT, BOTTOM, LEFT).
 */
public class DominoStickerTile extends TileImpl<DominoStickerSide> {
    private DominoStickerPiece parentPiece;


    public DominoStickerTile(Shape shape, Color color, DominoStickerPiece parentPiece) {
        for (Direction d : Direction.values())
            sides.put(d, new DominoStickerSide(shape, color, this));
        this.parentPiece = parentPiece;
    }

    @Override
    public String toString() {
        return getSide(Direction.TOP).toString();
    }
}
