package games.dominoes;

import games.common.model.deck.DeckImpl;
import games.common.model.hand.Hand;


public class DominoesDeck extends DeckImpl<DominoTile> {

    public DominoesDeck(DominoesDeckBuilder builder) {
        super(builder);
        cards = builder.build();
    }

    @Override
    public void deal(Hand hand) {

    }

    @Override
    public void addCard(DominoTile card) {

    }
}
