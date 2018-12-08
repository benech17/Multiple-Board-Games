package model.core.board;

import model.core.enums.Direction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public abstract class Board<T> {

    protected List<List<T>> map;
    protected int height, length;
    protected HashMap<Direction, Coordinate> adjacentCoordinates;

    public Board(int height, int length) {
        this.height = height;
        this.length = length;
        this.map = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            map.add(new LinkedList<>());
            for (int j = 0; j < height; j++) {
                map.get(i).add(null);
            }
        }
    }

    public List<List<T>> getMap() {
        return map;
    }

    public HashMap<Direction, Coordinate> getAdjacentCoordinates(Coordinate c) {
        adjacentCoordinates = new HashMap<>();
        int column = c.getColumn();
        int row = c.getRow();
        Coordinate top = new Coordinate(row + 1, column);
        Coordinate bottom = new Coordinate(row - 1, column);
        Coordinate left = new Coordinate(row, column - 1);
        Coordinate right = new Coordinate(row, column + 1);
        if (coordinateExists(top))
            adjacentCoordinates.put(Direction.TOP, top);
        if (coordinateExists(bottom))
            adjacentCoordinates.put(Direction.BOTTOM, bottom);
        if (coordinateExists(left))
            adjacentCoordinates.put(Direction.LEFT, left);
        if (coordinateExists(right))
            adjacentCoordinates.put(Direction.RIGHT, right);
        return adjacentCoordinates;
    }

    protected boolean coordinateExists(Coordinate c) {
        int x = c.getColumn();
        int y = c.getRow();
        return (0 <= x && x < length && 0 <= y && y < height);
    }

    /**
     * Get the card at the given position if it exists
     * and throws a NoSuchCoordinateException otherwise
     *
     * @param c coordinate in the map
     * @return the card at the coordinate c
     */
    protected T getTileAt(Coordinate c) {
        if (!coordinateExists(c))
            throw new NoSuchCoordinateException();
        return map.get(c.getRow()).get(c.getColumn());
    }

    protected void addTileToMap(Coordinate c, T tile) {
        if (!coordinateExists(c))
            throw new NoSuchCoordinateException();
        map.get(c.getRow()).set(c.getColumn(), tile);
    }

    public abstract String toString();

}

class NoSuchCoordinateException extends RuntimeException {
}
