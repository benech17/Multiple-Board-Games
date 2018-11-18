package model.core.board;

import model.core.card.Card;
import model.core.enums.Direction;

import java.util.HashMap;
import java.util.Stack;

public abstract class Board {

    protected HashMap<Coordinate, Stack<Card>> map;
    protected HashMap<Direction, Coordinate> adjacentCoordinates;

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
     * Get the stack of cards at the given position
     * @param c coordinate in the map
     * @return the stack of card at the coordinate c
     */
    protected Stack<Card> getStackCard(Coordinate c) throws NoSuchCoordinateException {
        Stack<Card> s = map.get(c);
        if (s == null)
            throw new NoSuchCoordinateException();
        return s;
    }

    protected void addCardToMap(Coordinate c, Card card) {
        Stack<Card> s;
        try {
            s = getStackCard(c);
        } catch (NoSuchCoordinateException e) {
            // In the situation where the coordinate doesn't exist yet
            s = new Stack<>();
            s.push(card);
            map.put(c, s);
            return;
        }
        s.push(card);
    }

    public abstract String toString();

    private class NoSuchCoordinateException extends RuntimeException {
    }
}
