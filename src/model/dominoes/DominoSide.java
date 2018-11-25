package model.dominoes;

import model.core.card.tile.Side;
import java.util.Objects;


public class DominoSide extends Side {
    private final int value;

    public DominoSide(int value, DominoTile parent) {
        super(parent, null);
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
        DominoSide that = (DominoSide) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
