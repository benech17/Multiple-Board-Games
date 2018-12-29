package games.dominoes.stickersdominoes;

import games.common.model.board.Coordinate;
import games.dominoes.DominoesBoard;

public class DominoesStickerBoard extends DominoesBoard<DominoStickerPiece, DominoStickerTile> {
    public DominoesStickerBoard(int height, int length, Coordinate c, DominoStickerPiece piece) {
        super(height, length, c, piece);
    }
}
