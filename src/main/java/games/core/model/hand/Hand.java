package games.core.model.hand;

public interface Hand<C> {

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

    /**
     *
     * @param index
     * @return true if the card was discarded as a result of this call
     * @throws IndexOutOfBoundsException
     */
    boolean discardCard(int index) throws IndexOutOfBoundsException;

}
