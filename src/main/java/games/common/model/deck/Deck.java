package games.common.model.deck;

import games.common.model.hand.Hand;

import java.util.List;
import java.util.Stack;


/**
 * A deck data type
 *
 * @param <C> the type of cards manipulated by the deck
 */
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

    /**
     * Distributes some cards to the given hands
     *
     * @param hands the hands that get the distributed cards
     * @throws EmptyDeckException if the deck is empty
     */
    void distributeCards(List<? extends Hand<C>> hands) throws EmptyDeckException;

    /**
     * Adds a card to the deck
     * @param card the card to be added to the deck
     */
    void addCard(C card);

    /**
     * Shuffles the cards of the deck randomly
     */
    void shuffle();
}
