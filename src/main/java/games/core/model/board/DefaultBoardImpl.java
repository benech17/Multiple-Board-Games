package games.core.model.board;

import games.core.model.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// Should we keep it abstract?
public abstract class DefaultBoardImpl<T> implements Board<T> {

    protected List<List<T>> board;
    protected int height, length;
    protected HashMap<Direction, Coordinate> adjacentCoordinates;

    public DefaultBoardImpl(int height, int length) {
        this.height = height;
        this.length = length;
        this.board = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            board.add(new ArrayList<>(length));
            for (int j = 0; j < length; j++) {
                board.get(i).add(null);
            }
        }
    }

    public List<List<T>> getBoard() {
        return board;
    }

    @Override
    public HashMap<Direction, T> getAdjacentTiles(Coordinate c) throws NoSuchCoordinateException {
        HashMap<Direction, Coordinate> adjCoords = c.getAdjacentCoordinates();
        HashMap<Direction, T> adjTiles = new HashMap<>();
        for (Direction d : adjCoords.keySet()) {
            if (coordinateInsideBoard(adjCoords.get(d)))
                adjTiles.put(d, getTileAt(adjCoords.get(d)));
        }
        return adjTiles;
    }

    /**
     * Tests if a coordinate corresponds to an actual coordinate in the board
     *
     * @param c
     * @return true if the coordinate c is inside the board
     */
    protected boolean coordinateInsideBoard(Coordinate c) {
        int x = c.getColumn();
        int y = c.getRow();
        return (0 <= x && x < length && 0 <= y && y < height);
    }

    @Override
    public T getTileAt(Coordinate c) throws NoSuchCoordinateException {
        if (!coordinateInsideBoard(c))
            throw new NoSuchCoordinateException();
        return board.get(c.getRow()).get(c.getColumn());
    }

    @Override
    public boolean putTileAt(Coordinate c, T tile) throws NoSuchCoordinateException {
        if (!coordinateInsideBoard(c))
            throw new NoSuchCoordinateException();
        if (board.get(c.getRow()).get(c.getColumn()) != null)
            return false;
        board.get(c.getRow()).set(c.getColumn(), tile);
        return true;
    }

    @Override
    public boolean removeTileAt(Coordinate c) throws NoSuchCoordinateException {
        if (!coordinateInsideBoard(c))
            throw new NoSuchCoordinateException();
        board.get(c.getRow()).set(c.getColumn(), null);
        return true;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                s += board.get(i).get(j) == null ? "n" : board.get(i).get(j);
            }
            s += "\n";
        }
        return s;
    }

}
