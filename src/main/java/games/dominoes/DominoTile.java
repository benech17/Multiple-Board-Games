package games.dominoes;

import games.core.model.card.tile.AbstractTile;
import games.core.model.enums.Direction;


public class DominoTile extends AbstractTile<DominoSide> implements Comparable<DominoTile> {
    private final int weight;
    public DominoTile(int leftValue, int rightValue) {
        sides.put(Direction.LEFT, new DominoSide(leftValue, this));
        sides.put(Direction.RIGHT, new DominoSide(rightValue, this));
        weight = rightValue + leftValue;
        setName();
    }

    public boolean isDouble() {
        return getLeftSide().getValue() == getRightSide().getValue();
    }

    /**
     *
     * @return the sum of the values of the two sides
     */
    public int getWeight() {
        return weight;
    }

    public int compareTo(DominoTile o) {
        if (o == null)
            throw new NullPointerException();
        return Integer.compare(weight, o.weight);
    }

    private void setName() {
        String s;
        if (isDouble())
            s = "double " + getLeftSide().getValue();
        else
            s = getLeftSide().getValue() + "-" + getRightSide().getValue();
        setName(s);
    }

    /**
     * Exchanges both sides
     */
    public void flip() {
        rotate(1);
    }

    /**
     * Returns true if the current instance of DominoTile and the domino
     * tile t have a side in common. Flips the current instance if necessary
     * according to the direction d.
     * @param t a domino tile adjacent to the current domino tile
     * @param d the position of the domino tile t with respect to the current
     *          domino tile
     * @return true if the current domino tile and the domino tile t share the
     * same side
     */
    public boolean sidesMatch(DominoTile t, Direction d) {
        if (t == null) return false;
        switch (d) {
            case LEFT:
                if (getLeftSide().equals(t.getRightSide()))
                    return true;
                if (getRightSide().equals(t.getRightSide())) {
                    flip();
                    return true;
                }
                break;
            case RIGHT:
                if (getRightSide().equals(t.getLeftSide()))
                    return true;
                if (getLeftSide().equals(t.getLeftSide())) {
                    flip();
                    return true;
                }
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + getLeftSide().toString() + "|" + getRightSide().toString() + "]";
    }

}
