package games.saboteur;

public class BlockedPlayerException extends RuntimeException {
    public BlockedPlayerException(String message) {
        super(message);
    }
}
