package games.dominoes;

import games.core.model.deck.DeckBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class DominoesDeckBuilder implements DeckBuilder {
    private Queue<DominoTile> deck;

    public DominoesDeckBuilder() {
        this.deck = new LinkedList<>();
    }

    @Override
    public void buildCards() {
        deck = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                deck.add(new DominoTile(i, j));
            }
        }
    }
}
