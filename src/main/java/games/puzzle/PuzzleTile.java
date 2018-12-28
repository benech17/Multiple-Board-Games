package games.puzzle;

import games.common.model.board.Coordinate;
import games.common.model.card.tile.TileImpl;
import games.common.model.enums.Direction;


public class PuzzleTile extends TileImpl<PuzzleSide> {
    public final Coordinate position;

    public PuzzleTile(Coordinate position, int topValue, int rightValue, int bottomValue, int leftValue) {
        this.position = position;
        sides.put(Direction.TOP, new PuzzleSide(topValue));
        sides.put(Direction.LEFT, new PuzzleSide(leftValue));
        sides.put(Direction.RIGHT, new PuzzleSide(rightValue));
        sides.put(Direction.BOTTOM, new PuzzleSide(bottomValue));
    }

    public Coordinate getPosition() {
        return position;
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
                "position=" + position +
                "sides=" + sides +
                '}';
    }
}
