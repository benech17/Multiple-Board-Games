package games.core.model.board;

import games.core.model.enums.Direction;

import java.util.HashMap;
import java.util.Objects;

public class Coordinate {
    private final int row, column;


    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Returns the 4 adjacent coordinates
     * @return a HashMap containing the adjacent coordinates as value and their
     * position with respect to current instance
     */
    public HashMap<Direction, Coordinate> getAdjacentCoordinates() {
        HashMap<Direction, Coordinate> adjacentCoordinates = new HashMap<>();
        Coordinate top = new Coordinate(row + 1, column);
        Coordinate bottom = new Coordinate(row - 1, column);
        Coordinate left = new Coordinate(row, column - 1);
        Coordinate right = new Coordinate(row, column + 1);
        adjacentCoordinates.put(Direction.TOP, top);
        adjacentCoordinates.put(Direction.BOTTOM, bottom);
        adjacentCoordinates.put(Direction.LEFT, left);
        adjacentCoordinates.put(Direction.RIGHT, right);
        return adjacentCoordinates;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Coordinate add(Coordinate c) {
        return new Coordinate(row + c.getRow(), column + c.getColumn());
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row &&
                column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

}
