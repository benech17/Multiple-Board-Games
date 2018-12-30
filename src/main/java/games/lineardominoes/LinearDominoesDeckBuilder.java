package games.lineardominoes;

import games.common.model.deck.DeckBuilder;

import java.util.Stack;


public class LinearDominoesDeckBuilder implements DeckBuilder<LinearDominoTile> {
    private Stack<LinearDominoTile> deck;

    public LinearDominoesDeckBuilder() {
        this.deck = new Stack<>();
    }

    public static void main(String[] args) {
        LinearDominoesDeckBuilder b = new LinearDominoesDeckBuilder();
        b.build();
        System.out.println(b.getDeck());
        System.out.println(b.getSize());

    }

    @Override
    public Stack<LinearDominoTile> build() {
        deck = new Stack<>();
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                deck.add(new LinearDominoTile(i, j));
            }
        }
        return deck;
    }

    public int getSize() {
        return deck.size();
    }

    public Stack<LinearDominoTile> getDeck() {
        return deck;
    }
}
