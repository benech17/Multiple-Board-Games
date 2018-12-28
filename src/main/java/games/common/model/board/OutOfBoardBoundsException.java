package games.common.model.board;

public class OutOfBoardBoundsException extends RuntimeException {
    public OutOfBoardBoundsException(String message) {
        super(String.format("%s out of the board", message));
    }
}
