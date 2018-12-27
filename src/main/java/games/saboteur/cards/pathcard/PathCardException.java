package games.saboteur.cards.pathcard;

public class PathCardException extends RuntimeException {
    public static class CantRevealHiddenCardException extends RuntimeException {
    }

    public static class UnconnectedPathException extends RuntimeException {
        public UnconnectedPathException(String message) {
            super(message);
        }
    }
}
