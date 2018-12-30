package games.lineardominoes;

import games.common.model.card.tile.Side;

import java.util.Objects;


public class LinearDominoSide extends Side {
    private final int value;

    public LinearDominoSide(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    /**
     * Two domino sides are equal if they share the same value
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinearDominoSide that = (LinearDominoSide) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
