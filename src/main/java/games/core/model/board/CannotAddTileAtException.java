package games.core.model.board;

public class CannotAddTileAtException extends RuntimeException {
    public CannotAddTileAtException(String message) {
        super(message);
    }
}
