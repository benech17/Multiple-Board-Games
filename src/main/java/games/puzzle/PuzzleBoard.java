package games.puzzle;

import games.core.model.board.DefaultBoardImpl;

public class PuzzleBoard extends DefaultBoardImpl<PuzzleTile> {
    public PuzzleBoard(int height, int length) {
        super(height, length);
    }
}
