package games.dominoesold;

import games.common.model.deck.DeckBuilder;
import games.common.model.deck.DeckImpl;


public abstract class DominoesDeck extends DeckImpl<DominoTile> {
    public DominoesDeck(DeckBuilder<DominoTile> deckBuilder) {
        super(deckBuilder);
    }

    /*public DominoesDeck(LinearDominoesDeckBuilder builder) {
        super(builder);
        cards = builder.build();
    }

    @Override
    public void deal(Hand hand) {

    }

    @Override
    public void addCard(DominoTile card) {

    }*/
}
