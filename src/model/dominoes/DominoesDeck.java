package model.dominoes;

import model.core.deck.Deck;
import model.core.deck.DeckBuilder;

import java.util.Queue;

public class DominoesDeck implements Deck<DominoTile> {

    private DeckBuilder builder = new DominoesDeckBuilder();

    public DominoesDeck() {
        builder.buildCards();
    }

    @Override
    public Queue<DominoTile> getCards() {
        return null;
    }

    @Override
    public void shuffle() {

    }
}
