package games.core.model.board;

import games.core.model.card.tile.Tile;
import games.core.model.enums.Direction;

import java.util.*;
import java.util.function.Function;


// Should we keep it abstract?
public abstract class DefaultBoardImpl<T extends Tile> implements Board<T> {

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
    public HashMap<Direction, T> getAdjacentTilesByDirection(Coordinate c) throws OutOfBoardBoundsException {
        HashMap<Direction, Coordinate> adjCoords = c.getAdjacentCoordinates();
        HashMap<Direction, T> adjTiles = new HashMap<>();
        for (Direction d : adjCoords.keySet()) {
            if (coordinateInsideBoard(adjCoords.get(d)) && getTileAt(adjCoords.get(d)) != null)
                adjTiles.put(d, getTileAt(adjCoords.get(d)));
        }
        return adjTiles;
    }

    public LinkedList<Coordinate> getAdjacentTilesByCoordinates(Coordinate c) throws OutOfBoardBoundsException {
        HashMap<Direction, Coordinate> adjCoords = c.getAdjacentCoordinates();
        LinkedList<Coordinate> adjTiles = new LinkedList<>();
        for (Direction d : adjCoords.keySet()) {
            if (coordinateInsideBoard(adjCoords.get(d)) && getTileAt(adjCoords.get(d)) != null)
                adjTiles.add(adjCoords.get(d));
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
    public T getTileAt(Coordinate c) throws OutOfBoardBoundsException {
        if (!coordinateInsideBoard(c))
            throw new OutOfBoardBoundsException(c.toString());
        return board.get(c.getRow()).get(c.getColumn());
    }

    @Override
    public boolean putTileAt(Coordinate c, T tile)
            throws OutOfBoardBoundsException,
            CannotAddTileAtException {
        if (!coordinateInsideBoard(c))
            throw new OutOfBoardBoundsException(c.toString());
        if (board.get(c.getRow()).get(c.getColumn()) != null)
            throw new CannotAddTileAtException("A tile is already on the board at " + c);
        board.get(c.getRow()).set(c.getColumn(), tile);
        return true;
    }

    @Override
    public boolean removeTileAt(Coordinate c) throws OutOfBoardBoundsException {
        if (!coordinateInsideBoard(c))
            throw new OutOfBoardBoundsException(c.toString());
        board.get(c.getRow()).set(c.getColumn(), null);
        return true;
    }

    @Override
    public boolean hasPathFromTo(Coordinate start, Function<T, Boolean> isGoal)
            throws NoTileAtCoordinateException {
        if (getTileAt(start) == null)
            throw new NoTileAtCoordinateException(start.toString());
        // Queue of tiles to visit (we keep their coordinates)
        Queue<Coordinate> toVisit = new LinkedList<>();
        // Queue of visited tiles (we keep their coordinates)
        Queue<Coordinate> visitedTiles = new LinkedList<>();
        toVisit.add(start); // Push the current node to the queue
        Coordinate currentCoordinate;
        while (!toVisit.isEmpty()) {
            // Pop the next tile to visit
            currentCoordinate = toVisit.poll();
            // We've found the goal, the job is done
            if (isGoal.apply(getTileAt(currentCoordinate)))
                return true;
            // This tile has already been visited, we skip it
            if (visitedTiles.contains(currentCoordinate))
                continue;
            visitedTiles.add(currentCoordinate);
            // Adding the adjacent tiles to the queue
            toVisit.addAll(getAdjacentTilesByCoordinates(currentCoordinate));
        }
        return false;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                s.append(board.get(i).get(j) == null ? "n" : board.get(i).get(j));
            }
            s.append("\n");
        }
        return s.toString();
    }

}
