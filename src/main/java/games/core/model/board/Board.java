package games.core.model.board;

import games.core.model.enums.Direction;

import java.util.HashMap;

public interface Board<T> {

    HashMap<Direction, Coordinate> getAdjacentCoordinates(Coordinate c);

    boolean coordinateExists(Coordinate c);

    T getTileAt(Coordinate c);

    void putTileAt(Coordinate c, T tile);

    String toString();
}
