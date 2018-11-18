package model.dominoes;

import model.core.enums.Direction;
import model.core.card.side.Side;
import model.core.card.tile.Tile;

import java.util.ArrayList;

public class DominoTile extends Tile {
    public DominoTile(int value1, int value2) {
        super(initSides(value1, value2));
    }

    private static ArrayList<Side> initSides(int value1, int value2) {
        if (!validSides(value1, value2))
            throw new RuntimeException();
        ArrayList<Side> sides = new ArrayList<>();
        sides.add(new DominoSide(value1));
        sides.add(new DominoSide(value2));
        return sides;
    }

    /**
     * @param value1 the first digit
     * @param value2 the second digit
     * @return true iff the digits for each side are valid
     */
    private static boolean validSides(int value1, int value2) {
        return (1 <= value1 && value1 <= 6) && (1 <= value2 && value2 <= 6);
    }

    public DominoSide getLeftSide() {
        return (DominoSide) getSides().get(0);
    }

    public DominoSide getRightSide() {
        return (DominoSide) getSides().get(1);
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
        if (d.equals(Direction.LEFT)) {
            if (getLeftSide().equals(t.getRightSide()))
                return true;
            if (getRightSide().equals(t.getRightSide())) {
                flip();
                return true;
            }
        }
        if (d.equals(Direction.RIGHT)) {
            if (getRightSide().equals(t.getLeftSide()))
                return true;
            if (getLeftSide().equals(t.getLeftSide())) {
                flip();
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a side from the list of available sides
     * @param s
     * @return
     */
    /*public void removeAvailableSide(Side s) {
        getAvailableSides().remove(s);
    }*/

    @Override
    public String toString() {
        return "[" + getSides().get(0) + "|" + getSides().get(1) + "]";
    }

    public static void main(String[] args) {
        DominoTile d1 = new DominoTile(1, 6);
        DominoTile d2 = new DominoTile(6, 4);
        //System.out.println(d1.getMatchingSide(d2)); // Sides match
        DominoTile d3 = new DominoTile(3, 3);
        //System.out.println(d2.getMatchingSide(d3)); // Sides don't match
    }


}
