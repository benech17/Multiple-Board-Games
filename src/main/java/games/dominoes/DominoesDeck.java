package games.dominoes;

import games.core.model.deck.DeckBuilder;
import games.core.model.deck.DeckImpl;
import games.core.model.hand.Hand;


public class DominoesDeck extends DeckImpl<DominoTile> {

    private DeckBuilder builder = new DominoesDeckBuilder();

    public DominoesDeck() {
        cards = builder.build();
    }

    @Override
    public void deal(Hand hand) {

    }

    @Override
    public void addCard(DominoTile card) {

    }
}
