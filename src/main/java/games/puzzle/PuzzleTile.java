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
    public void rotateBy90() {
        rotate(1);
    }

    /**
     * Rotates by 90° counterclockwise the tile
     */
    public void rotateByMinus90() {
        rotate(-1);
    }

    @Override
    public String toString() {
        return "PuzzleTile{" +
                "sides=" + sides +
                '}';
    }
}
