package games.core.model.deck;

import java.util.Stack;


public interface DeckBuilder<C> {
    Stack<C> build();
}
