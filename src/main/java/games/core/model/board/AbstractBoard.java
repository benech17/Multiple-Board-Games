package games.core.model.board;

import games.core.model.enums.Direction;

import java.util.HashMap;


public abstract class AbstractBoard<T> implements Board<T> {

    protected T[][] board;
    protected int height, length;
    protected HashMap<Direction, Coordinate> adjacentCoordinates;

    @SuppressWarnings("unchecked")
    public AbstractBoard(int height, int length) {
        this.height = height;
        this.length = length;
        this.board = (T[][]) new Object[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                board[i][j] = null;
            }
        }
    }

    public T[][] getBoard() {
        return board;
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
        return board[c.getRow()][c.getColumn()];
    }

    @Override
    public boolean putTileAt(Coordinate c, T tile) throws NoSuchCoordinateException {
        if (!coordinateInsideBoard(c))
            throw new NoSuchCoordinateException();
        if (board[c.getRow()][c.getColumn()] != null)
            return false;
        board[c.getRow()][c.getColumn()] = tile;
        return true;
    }

    @Override
    public boolean removeTileAt(Coordinate c) throws NoSuchCoordinateException {
        if (!coordinateInsideBoard(c))
            throw new NoSuchCoordinateException();
        board[c.getRow()][c.getColumn()] = null;
        return true;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                s += board[i][j];
            }
            s += "/n";
        }
        return s;
    }

}

class NoSuchCoordinateException extends RuntimeException {
}
