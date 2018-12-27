package games.saboteur.cards.actioncard;

public class ActionCardException extends RuntimeException {

    public static class BlockCardAlreadyAppliedException extends RuntimeException {
    }

    public static class NoMatchingBlockCardAppliedException extends RuntimeException {
    }

    public static class UnsupportedActionException extends RuntimeException {
        public UnsupportedActionException(String message) {
            super(message);
        }
    }
}
