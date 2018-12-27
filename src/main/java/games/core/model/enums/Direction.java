package games.core.model.enums;

import games.core.model.board.Coordinate;

// Directions put in clock-wise order
public enum Direction {
    TOP(1, 0),
    RIGHT(0, 1),
    BOTTOM(-1, 0),
    LEFT(0, -1);

    private Coordinate relativeCoordinates;

    // see https://stackoverflow.com/questions/5678309/illegal-forward-reference-and-enums
    static {
        TOP.oppositeDirection = BOTTOM;
        BOTTOM.oppositeDirection = TOP;
        LEFT.oppositeDirection = RIGHT;
        RIGHT.oppositeDirection = LEFT;
    }

    private Direction oppositeDirection;

    Direction(int row, int column) {
        relativeCoordinates = new Coordinate(row, column);
    }

    public Coordinate getRelativeCoordinates() {
        return relativeCoordinates;
    }

    public Direction getOppositeDirection() {
        return oppositeDirection;
    }
}
