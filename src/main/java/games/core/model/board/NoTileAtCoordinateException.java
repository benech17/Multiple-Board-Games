package games.core.model.board;

public class NoTileAtCoordinateException extends RuntimeException {
    public NoTileAtCoordinateException(String message) {
        super("No tile found at: " + message);
    }
}
