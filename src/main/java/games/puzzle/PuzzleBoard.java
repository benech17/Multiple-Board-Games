package games.puzzle;

import games.common.model.board.BoardImpl;
import games.common.model.board.CannotAddTileAtException;
import games.common.model.board.Coordinate;
import games.common.model.board.OutOfBoardBoundsException;
import games.common.model.enums.Direction;
import games.saboteur.cards.pathcard.PathCardException;

import java.util.EnumMap;


public class PuzzleBoard extends BoardImpl<PuzzleTile> {
    public PuzzleBoard(int height, int length) {
        super(height, length);
    }

    @Override
    public boolean putTileAt(Coordinate c, PuzzleTile tile) throws OutOfBoardBoundsException, CannotAddTileAtException {
        EnumMap<Direction, PuzzleTile> adjacentTiles = getAdjacentTilesByDirection(c);
        // We check if the tile fits with each adjacent tile
        for (Direction d : adjacentTiles.keySet()) {
            // We could move the unconnectedPathException in common
            if (!tile.fitsWith(adjacentTiles.get(d), d))
                throw new PathCardException.UnconnectedPathException("Illegal move: tunnels must connect!");
        }
        return c.equals(tile.getPosition()) && super.putTileAt(c, tile);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("  ");
        for (int i = 0; i < length; i++)
            s.append(i);
        s.append("\n");
        for (int i = 0; i < height; i++) {
            s.append(i).append(" ");
            for (int j = 0; j < length; j++) {
                s.append(board.get(i).get(j) == null ? "n" : "X");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
