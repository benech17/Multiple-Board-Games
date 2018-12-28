package games.saboteur;

import games.common.model.deck.DeckBuilder;
import games.saboteur.cards.SaboteurCard;

public interface SaboteurDeckBuilder extends DeckBuilder<SaboteurCard> {

    void buildPathCards();

    void buildActionCards();

}
