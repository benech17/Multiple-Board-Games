package games.saboteur;

import games.core.model.deck.DeckBuilder;
import games.saboteur.cards.SaboteurCard;

public interface SaboteurDeckBuilder extends DeckBuilder<SaboteurCard> {

    void buildPathCards();

    void buildActionCards();

}
