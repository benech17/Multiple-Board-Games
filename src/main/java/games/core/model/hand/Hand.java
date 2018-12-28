package games.core.model.hand;


import java.util.List;

/**
 * The hand of a player
 *
 * @param <C> the type of cards contained in the hand
 */
public interface Hand<C> {

    List<C> getHand();

    /**
     * Get a card from the hand at the specified index
     * @param index
     * @return
     */
    C getCardAt(int index);

    /**
     * Get the number of cards to distribute to the hand
     * at the start of the game
     *
     * @return
     */
    int getCardNumberAtStart();

    /**
     * Adds a card to the player's hand
     * @param card
     */
    void addCard(C card);

    /**
     * Removes a card at the specified index from the player's hand
     * @param index
     * @return the removed card
     */
    C drawCard(int index);

}
