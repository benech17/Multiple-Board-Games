package games.puzzle;

import games.common.model.card.tile.Side;

import java.util.Objects;


/**
 * The puzzle side holds a unique value shared with the adjacent side
 * This value is used to check if a side connects to an other one
 */
public class PuzzleSide extends Side<PuzzleTile> {
    private final int value;

    public PuzzleSide(int value, PuzzleTile parent) {
        super(parent);
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
     * Two puzzle sides are equal if they share the same value
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuzzleSide that = (PuzzleSide) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
