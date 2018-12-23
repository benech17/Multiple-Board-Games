package games.core.model.board;

public class NoTileAtCoordinate extends RuntimeException {
    public NoTileAtCoordinate(String message) {
        super("No tile found at: " + message);
    }
}
