package games.dominoes;

import games.core.model.deck.Deck;
import games.core.model.deck.DeckBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class DominoesDeckBuilder implements DeckBuilder<DominoTile> {
    private Queue<DominoTile> deck;

    public DominoesDeckBuilder() {
        this.deck = new LinkedList<>();
    }

    @Override
    public Queue<DominoTile> build() {
        deck = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                deck.add(new DominoTile(i, j));
            }
        }
        return deck;
    }

    public static void main(String[] args) {
        DominoesDeckBuilder b = new DominoesDeckBuilder();
        b.build();
        System.out.println(b.getDeck());
        System.out.println(b.getSize());

    }

    public int getSize() {
        return deck.size();
    }

    public Queue<DominoTile> getDeck() {
        return deck;
    }
}
