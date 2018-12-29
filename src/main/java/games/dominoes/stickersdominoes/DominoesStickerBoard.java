package games.dominoes.stickersdominoes;

import games.common.model.board.CannotAddTileAtException;
import games.common.model.board.Coordinate;
import games.common.model.board.OutOfBoardBoundsException;
import games.dominoes.DominoesBoard;

public class DominoesStickerBoard extends DominoesBoard<DominoStickerPiece, DominoStickerTile, DominoStickerSide> {
    public DominoesStickerBoard(int height, int length, Coordinate c, DominoStickerPiece piece) {
        super(height, length, c, piece);
    }

    @Override
    public boolean putTileAt(Coordinate c, DominoStickerPiece piece) throws OutOfBoardBoundsException, CannotAddTileAtException {
        return super.putTileAt(c, piece,
                (s1, s2) -> s1.getColor().equals(s2.getColor())
                        || s1.getShape().equals(s2.getShape())
        );
    }
}
