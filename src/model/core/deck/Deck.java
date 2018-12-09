package model.core.deck;

import java.util.Queue;

public interface Deck<T> {
    Queue<T> getCards();
    void shuffle();
}
