package games.dominoes;

import games.core.model.deck.DeckBuilder;
import games.core.model.deck.DeckImpl;

import java.util.Queue;

public abstract class DominoesDeck extends DeckImpl<DominoTile> {

    private DeckBuilder builder = new DominoesDeckBuilder();

    public DominoesDeck() {
        cards = builder.buildCards();
    }

}
