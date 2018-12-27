package games.core.model.deck;

import java.util.Stack;


/**
 * This builds a deck
 *
 * @param <C> the type of cards built by the builder
 */
public interface DeckBuilder<C> {
    Stack<C> build();
}
