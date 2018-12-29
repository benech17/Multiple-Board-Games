package games.dominoes.stickersdominoes;

import games.common.model.deck.DeckBuilder;
import games.common.model.deck.Tuple;
import games.common.model.enums.Color;

import java.util.*;


public class DominoesStickerDeckBuilder implements DeckBuilder<DominoStickerPiece> {
    private Stack<DominoStickerPiece> deck;

    public DominoesStickerDeckBuilder() {
        this.deck = new Stack<>();
    }

    public static void main(String[] args) {
        DominoesStickerDeckBuilder b = new DominoesStickerDeckBuilder();
        b.build();
        System.out.println(b.getDeck());
        System.out.println(b.getSize());

    }

    public <S, T> Set<Tuple<S, T>> cartesianProduct(List<S> a, List<T> b) {
        Set<Tuple<S, T>> product = new HashSet<>();
        for (S s : a) {
            for (T t : b) {
                product.add(new Tuple<>(s, t));
            }
        }
        return product;
    }

    @Override
    public Stack<DominoStickerPiece> build() {
        deck = new Stack<>();
        Set<Tuple<Tuple<Shape, Color>, Tuple<Shape, Color>>> pairSides = new HashSet<>();
        Set<Tuple<Shape, Color>> prod = cartesianProduct(Arrays.asList(Shape.values()), Arrays.asList(Color.values()));
        for (Tuple<Shape, Color> t1 : prod) {
            for (Tuple<Shape, Color> t2 : prod) {
                pairSides.add(new Tuple<>(t1, t2));
            }
        }
        for (Tuple<Tuple<Shape, Color>, Tuple<Shape, Color>> pair : pairSides) {
            deck.add(new DominoStickerPiece(
                    new DominoStickerTile(pair.getX().getX(), pair.getX().getY()),
                    new DominoStickerTile(pair.getY().getX(), pair.getY().getY())));
        }
        return deck;
    }

    public int getSize() {
        return deck.size();
    }

    public Stack<DominoStickerPiece> getDeck() {
        return deck;
    }
}
