package games.core.model.deck;

import games.core.model.hand.Hand;

import java.util.Queue;

public interface Deck<C> {
    /**
     * Deal a card from the top of the deck to the player's hand
     * @param hand
     */
    void deal(Hand hand);

    /**
     * Adds a card to the deck
     * @param card
     */
    void addCard(C card);

    /**
     * Shuffles the cards of the deck randomly
     */
    void shuffle();
}
