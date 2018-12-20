package games.puzzle;

import games.core.model.card.tile.AbstractTile;
import games.core.model.enums.Direction;


public class PuzzleTile extends AbstractTile<PuzzleSide> {

    public PuzzleTile(int topValue, int leftValue, int rightValue, int bottomValue) {
        sides.put(Direction.TOP, new PuzzleSide(topValue, this));
        sides.put(Direction.LEFT, new PuzzleSide(leftValue, this));
        sides.put(Direction.RIGHT, new PuzzleSide(rightValue, this));
        sides.put(Direction.BOTTOM, new PuzzleSide(bottomValue, this));
    }

    /**
     * Rotates by 90° clockwise the tile
     */
    public void rotate90() {
        rotate(1);
    }

    /**
     * Rotates by 90° counterclockwise the tile
     */
    public void rotateByMinus90() {
        rotate(-1);
    }

    /**
     * Returns true if the current instance of PuzzleTile and the puzzle tile
     * tile t fit together
     * @param t a puzzle tile adjacent to the current domino tile
     * @param d the position of the domino tile t with respect to the current
     *          puzzle tile
     * @return true if the current domino tile and the domino tile t connect to
     * each other
     */
    public boolean fitsWith(PuzzleTile t, Direction d) {
        if (t == null) return false;
        switch (d) {
            case TOP:
                return getTopSide().equals(t.getBottomSide());
            case LEFT:
                return getLeftSide().equals(t.getRightSide());
            case RIGHT:
                return getRightSide().equals(t.getLeftSide());
            case BOTTOM:
                return getBottomSide().equals(t.getTopSide());
        }
        return false;
    }

    @Override
    public String toString() {
        return "PuzzleTile{" +
                "sides=" + sides +
                '}';
    }

    public static void main(String[] args) {
        PuzzleTile t = new PuzzleTile(0, 1, 2, 3);
        PuzzleTile t2 = new PuzzleTile(3,4,5,6);
    }
}
