package games.puzzle;

import games.common.model.board.CannotAddTileAtException;
import games.common.model.board.Coordinate;
import games.common.model.board.DefaultBoardImpl;
import games.common.model.board.OutOfBoardBoundsException;
import games.common.model.enums.Direction;
import games.saboteur.cards.pathcard.PathCardException;

import java.util.EnumMap;


public class PuzzleBoard extends DefaultBoardImpl<PuzzleTile> {
    public PuzzleBoard(int height, int length) {
        super(height, length);
    }

    @Override
    public boolean putTileAt(Coordinate c, PuzzleTile tile) throws OutOfBoardBoundsException, CannotAddTileAtException {
        EnumMap<Direction, PuzzleTile> adjacentTiles = getAdjacentTilesByDirection(c);
        // No adjacent tiles to connect to
        if (adjacentTiles.isEmpty())
            return false;
        // We check if the tile fits with each adjacent tile
        for (Direction d : adjacentTiles.keySet()) {
            // We could move the unconnectedPathException in common
            if (!tile.fitsWith(adjacentTiles.get(d), d))
                throw new PathCardException.UnconnectedPathException("Illegal move: tunnels must connect!");
        }
        return c.equals(tile.getPosition()) && super.putTileAt(c, tile);
    }
}
