package games.core.model.deck;


import java.util.Queue;

public interface DeckBuilder<C> {
    Queue<C> buildCards();
}
