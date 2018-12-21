package games.core.model.hand;

public interface Hand<C> {

    /**
     * Adds a card to the player's hand
     * There should be a limit to the number of cards that
     * one player can hold
     */
    void addCard();

    /**
     * Removes a card at the specified index from the player's hand
     * @return the removed card
     */
    C removeCard();

}
