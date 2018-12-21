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

    @Override
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

    @Override
    public boolean coordinateExists(Coordinate c) {
        int x = c.getColumn();
        int y = c.getRow();
        return (0 <= x && x < length && 0 <= y && y < height);
    }

    /**
     * Get the card at the given position if it exists
     * and throws a NoSuchCoordinateException otherwise
     *
     * @param c coordinate in the board
     * @return the card at the coordinate c
     */
    @Override
    public T getTileAt(Coordinate c) {
        if (!coordinateExists(c))
            throw new NoSuchCoordinateException();
        return board[c.getRow()][c.getColumn()];
    }

    @Override
    public void putTileAt(Coordinate c, T tile) {
        if (!coordinateExists(c))
            throw new NoSuchCoordinateException();
        board[c.getRow()][c.getColumn()] = tile;
    }

    @Override
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
