package games.core.model.enums;

import games.core.model.board.Coordinate;

// Directions put in clock-wise order
public enum Direction {
    TOP(1, 0),
    RIGHT(0, 1),
    BOTTOM(-1, 0),
    LEFT(0, -1);

    private Coordinate relativeCoordinates;

    Direction(int row, int column) {
        relativeCoordinates = new Coordinate(row, column);
    }

    public Coordinate getRelativeCoordinates() {
        return relativeCoordinates;
    }
}
