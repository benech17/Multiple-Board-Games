package games.dominoes.stickersdominoes;

import games.common.model.enums.Color;
import games.common.model.enums.Direction;
import games.dominoes.DominoTile;


public class DominoStickerTile extends DominoTile<DominoStickerSide> {

    public DominoStickerTile(Shape shape, Color color) {
        for (Direction d : Direction.values())
            sides.put(d, new DominoStickerSide(shape, color));
    }

    @Override
    public String toString() {
        return getSide(Direction.TOP).toString();
    }
}
