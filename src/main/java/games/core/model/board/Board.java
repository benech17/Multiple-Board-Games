package games.core.model.board;

import games.core.model.enums.Direction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * Description of the Board type
 *
 * @param <T>
 */
public interface Board<T> {

    /**
     * Get the card at the given position if it exists
     *
     * @param c coordinate in the board
     * @return the card at the coordinate c
     * @throws NoSuchCoordinateException if the specified coordinate is outside of the board
     */
    T getTileAt(Coordinate c) throws NoSuchCoordinateException;

    /**
     * Puts a tile in the board at the given coordinate
     *
     * @param c
     * @param tile
     * @return true if the tile was put at the given coordinate as a result of this call.
     * Returns false if a tile is already present
     * @throws NoSuchCoordinateException if the specified coordinate is outside of the board
     */
    boolean putTileAt(Coordinate c, T tile) throws NoSuchCoordinateException;

    /**
     * Removes the tile at the given coordinate
     *
     * @param c coordinate of the tile to be removed
     * @return true if the tile at the given coordinate was removed as a result of this call
     * @throws NoSuchCoordinateException if the specified coordinate is outside of the board
     */
    boolean removeTileAt(Coordinate c) throws NoSuchCoordinateException;

    /**
     * Get the tiles adjacent to the given coordinate in the board
     * with their position with respect to the coordinate (TOP, RIGHT, LEFT, BOTTOM).
     * @param c
     * @return a HashMap of the tiles adjacent to the coordinate in the board
     * @throws NoSuchCoordinateException if the specified coordinate is outside of the board
     */
    HashMap<Direction, T> getAdjacentTilesByDirection(Coordinate c) throws NoSuchCoordinateException;

    /**
     * Get the coordinates of the tiles adjacent to the given coordinate in the board
     *
     * @param c the specified coordinate
     * @return a LinkedList of the coordinates of the tiles adjacent to the coordinate in the board
     * @throws NoSuchCoordinateException if the specified coordinate is outside of the board
     */
    LinkedList<Coordinate> getAdjacentTilesByCoordinates(Coordinate c) throws NoSuchCoordinateException;

    /**
     * Returns true if there is a path from the start tile to a goal tile.
     * Performs a Breadth-First Search starting from the specified coordinate
     * start to a tile verifying the isGoal condition.
     * Any visited coordinates must be unique to avoid looped paths.
     *
     * @param start  coordinate of the tile to start the search
     * @param isGoal condition for a tile to be the goal of the search
     * @return true if we found a tile verifying a special condition given by
     * the function isGoal
     * @throws NoTileAtCoordinate if there is not tile at the start coordinate
     */
    boolean hasPathFromTo(Coordinate start, Function<T, Boolean> isGoal) throws NoTileAtCoordinate;

}
