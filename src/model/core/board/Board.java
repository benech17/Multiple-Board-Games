package model.core.board;

import model.core.card.tile.Tile;
import model.core.enums.Direction;

import java.io.IOException;
import java.util.HashMap;

public abstract class Board {

    protected HashMap<Coordinate, Tile> map;
    protected HashMap<Direction, Coordinate> adjacentCoordinates;

    public HashMap<Coordinate, Tile> getMap() {
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
        return map.get(c) != null;
    }

    /**
     * Get the card at the given position
     * @param c coordinate in the map
     * @return the card at the coordinate c
     */
    protected Tile getTileAt(Coordinate c) throws NoSuchCoordinateException {
        Tile t = map.get(c);
        if (t == null)
            throw new NoSuchCoordinateException();
        return t;
    }

    protected void addTileToMap(Coordinate c, Tile tile) {
        /*adjacentCoordinates = getAdjacentCoordinates(c);
        Coordinate neighbor;
        for (Direction d : adjacentCoordinates.keySet()) {
            neighbor = adjacentCoordinates.get(d);
            if (coordinateExists(neighbor)) {
                // Connects the tile with a surrounding tile
                // Add a method connect(Tile t) in class Tile ?
                getTileAt(neighbor).getSides()
                tile.getSides().get(d).setNextSide();
            }
        }*/
        map.put(c, tile);
    }

    public abstract String toString();

    private class NoSuchCoordinateException extends RuntimeException {
    }
}
