package games.core.model.deck;

import games.core.model.hand.Hand;

import java.util.Stack;

public interface Deck<C> {

    /**
     * Get the cards available in the deck
     * @return the cards in the deck
     */
    Stack<C> getCards();

    /**
     * Deal a card from the top of the deck to the player's hand
     * @param hand
     * @throws EmptyDeckException if the deck is empty
     */
    void deal(Hand<C> hand) throws EmptyDeckException;

    void distributeCards(Hand<C>[] hands);

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
