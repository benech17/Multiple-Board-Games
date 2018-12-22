package games.saboteur;

import games.core.model.card.Card;
import games.core.model.deck.DeckBuilder;

public interface SaboteurDeckBuilder extends DeckBuilder<Card> {

    void buildPathCards();

    void buildActionCards();

}
