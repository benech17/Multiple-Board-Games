package model.dominoes;

import model.core.enums.Direction;
import model.core.card.tile.Tile;

import java.util.HashMap;


public class DominoTile extends Tile {
    public DominoTile(int leftValue, int rightValue) {
        sides = new HashMap<>();
        sides.put(Direction.LEFT, new DominoSide(leftValue, this));
        sides.put(Direction.RIGHT, new DominoSide(rightValue, this));
        setName();
    }

    public boolean isDouble() {
        return getLeftSide().getValue() == getRightSide().getValue();
    }

    private void setName() {
        String s;
        if (isDouble())
            s = "double " + getLeftSide().getValue();
        else
            s = getLeftSide().getValue() + "-" + getRightSide().getValue();
        setName(s);
    }

    public DominoSide getLeftSide() {
        return (DominoSide) sides.get(Direction.LEFT);
    }

    public DominoSide getRightSide() {
        return (DominoSide) sides.get(Direction.RIGHT);
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

    /*public void removeAvailableSide(Side s) {
        getAvailableSides().remove(s);
    }*/

    @Override
    public String toString() {
        return "[" + getSides().get(Direction.LEFT) + "|" + getSides().get(Direction.RIGHT) + "]";
    }

    public static void main(String[] args) {
        DominoTile d1 = new DominoTile(1, 6);
        DominoTile d2 = new DominoTile(6, 4);
        //System.out.println(d1.getMatchingSide(d2)); // Sides match
        DominoTile d3 = new DominoTile(3, 3);
        System.out.println(d1);
        //System.out.println(d2.getMatchingSide(d3)); // Sides don't match
    }


}
