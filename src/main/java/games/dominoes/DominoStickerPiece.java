package games.dominoes;

import games.common.model.enums.Color;
import games.common.model.enums.Direction;
import games.common.model.enums.Shape;


public class DominoStickerPiece extends DominoPiece<DominoStickerTile> {

    public DominoStickerPiece(Shape shape1, Color color1, Shape shape2, Color color2) {
        this(new DominoStickerTile(shape1, color1), new DominoStickerTile(shape2, color2));
    }

    public DominoStickerPiece(Shape shape1, Color color1, Shape shape2, Color color2, Direction orientation) {
        this(new DominoStickerTile(shape1, color1), new DominoStickerTile(shape2, color2), orientation);
    }

    public DominoStickerPiece(DominoStickerTile tile1, DominoStickerTile tile2) {
        super(tile1, tile2);
    }

    public DominoStickerPiece(DominoStickerTile tile1, DominoStickerTile tile2, Direction orientation) {
        super(tile1, tile2, orientation);
    }
}
