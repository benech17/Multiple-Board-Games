package games.dominoes;

import games.core.model.deck.DeckBuilder;

import java.util.Stack;

public class DominoesDeckBuilder implements DeckBuilder<DominoTile> {
    private Stack<DominoTile> deck;

    public DominoesDeckBuilder() {
        this.deck = new Stack<>();
    }

    @Override
    public Stack<DominoTile> build() {
        deck = new Stack<>();
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

    public Stack<DominoTile> getDeck() {
        return deck;
    }
}
