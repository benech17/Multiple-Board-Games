package games.saboteur.cards;

public class WrongCardException extends RuntimeException {
    public WrongCardException(String message) {
        super(message);
    }
}
