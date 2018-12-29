package games.common.model.deck;


/**
 * Immutable tuple
 *
 * @param <S>
 * @param <T>
 */
public class Tuple<S, T> {
    private S x;
    private T y;

    public Tuple(S x, T y) {
        this.x = x;
        this.y = y;
    }

    public S getX() {
        return x;
    }

    public T getY() {
        return y;
    }
}
