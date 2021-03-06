package games.lineardominoes;

import games.common.model.card.tile.TileImpl;
import games.common.model.enums.Direction;


public class LinearDominoTile extends TileImpl<LinearDominoSide> implements Comparable<LinearDominoTile> {
    private final int weight;
    private String name;

    public LinearDominoTile(int leftValue, int rightValue) {
        sides.put(Direction.LEFT, new LinearDominoSide(leftValue));
        sides.put(Direction.RIGHT, new LinearDominoSide(rightValue));
        weight = rightValue + leftValue;
        setName();
    }

    public boolean isDouble() {
        return getLeftSide().getValue() == getRightSide().getValue();
    }

    /**
     * @return the sum of the values of the two sides
     */
    public int getWeight() {
        return weight;
    }

    public int compareTo(LinearDominoTile o) {
        if (o == null)
            throw new NullPointerException();
        return Integer.compare(weight, o.weight);
    }

    private void setName() {
        if (isDouble())
            name = "double " + getLeftSide().getValue();
        else
            name = getLeftSide().getValue() + "-" + getRightSide().getValue();
    }

    /**
     * Exchanges both sides
     */
    public void flip() {
        rotate(1);
    }

    /**
     * Returns true if the current instance of LinearDominoTile and the domino
     * tile t have a side in common. Flips the current instance if necessary
     * according to the direction d.
     *
     * @param t a domino tile adjacent to the current domino tile
     * @param d the position of the domino tile t with respect to the current
     *          domino tile
     * @return true if the current domino tile and the domino tile t share the
     * same side
     */
    public boolean fitsWith(LinearDominoTile t, Direction d) {
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
