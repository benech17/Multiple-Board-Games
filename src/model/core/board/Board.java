package model.core.board;

import model.core.card.Card;
import model.core.enums.Direction;

import java.util.HashMap;

public abstract class Board {

    protected HashMap<Coordinate, Card> map;
    protected HashMap<Direction, Coordinate> adjacentCoordinates;

    public HashMap<Coordinate, Card> getMap() {
        return map;
    }

    public HashMap<Direction, Coordinate> getAdjacentCoordinates(Coordinate c) {
        adjacentCoordinates = new HashMap<>();
        int column = c.getColumn();
        int row = c.getRow();
        for (Direction d : Direction.values()) {
            adjacentCoordinates.put(d, null);
        }
        Coordinate top = new Coordinate(row + 1, column);
        Coordinate bottom = new Coordinate(row - 1, column);
        Coordinate left = new Coordinate(row, column - 1);
        Coordinate right = new Coordinate(row, column + 1);
        // TODO simplify that code
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
        return map.get(c) != null;
    }

    /**
     * Get the card at the given position
     * @param c coordinate in the map
     * @return the card at the coordinate c
     */
    protected Card getCard(Coordinate c) throws NoSuchCoordinateException {
        Card s = map.get(c);
        if (s == null)
            throw new NoSuchCoordinateException();
        return s;
    }

    protected void addCardToMap(Coordinate c, Card card) {
        map.put(c, card);
    }

    public abstract String toString();

    private class NoSuchCoordinateException extends RuntimeException {
    }
}
