package games.dominoes;

import games.common.model.board.BoardImpl;
import games.common.model.board.CannotAddTileAtException;
import games.common.model.board.Coordinate;
import games.common.model.board.OutOfBoardBoundsException;
import games.common.model.enums.Direction;

import java.util.EnumMap;


public class DominoesBoard<P extends DominoPiece<T>, T extends DominoTile> extends BoardImpl<T> {

    public DominoesBoard(int height, int length, Coordinate c, P piece) {
        super(height, length);
        putFirstTileAt(c, piece);
    }

    /**
     * This puts the first tile on the board
     *
     * @param c     the coordinate on the board to put the first tile of the domino piece
     * @param piece the domino piece to put on the board
     * @return true if the tile was effectively put on the board as a result of this call
     */
    private boolean putFirstTileAt(Coordinate c, P piece) {
        return putTileAt(c, piece.getTile1())
                && putTileAt(c.plus(piece.getTile2Position()), piece.getTile2());
    }

    /**
     * Puts a domino piece on the board
     *
     * @param c
     * @param piece
     * @return
     * @throws OutOfBoardBoundsException
     * @throws CannotAddTileAtException
     */
    public boolean putTileAt(Coordinate c, P piece) throws OutOfBoardBoundsException,
            CannotAddTileAtException {

        T tile1 = piece.getTile1();
        T tile2 = piece.getTile2();
        Direction orientation = piece.getOrientation();

        // The adjacent tiles of each of the two tiles making the piece
        EnumMap<Direction, T> adjTilesTile1 = getAdjacentTilesByDirection(c);
        Coordinate cTile2 = c.plus(piece.getTile2Position()); // Coordinate on the board of the second tile
        EnumMap<Direction, T> adjTilesTile2 = getAdjacentTilesByDirection(cTile2);

        // Removes the tiles of the piece from the adjacent tiles of tile1 and tile2
        adjTilesTile2.remove(orientation.getOppositeDirection());
        adjTilesTile1.remove(orientation);

        // If there are more than 1 adjacent tile, the piece can't be put on the board
        if (adjTilesTile1.keySet().size() + adjTilesTile2.keySet().size() > 1)
            return false;

        EnumMap<Direction, T> adjTiles;
        T tile;

        if (adjTilesTile1.keySet().size() == 0) {
            adjTiles = adjTilesTile2;
            tile = tile2;
        } else {
            adjTiles = adjTilesTile1;
            tile = tile1;
        }

        // We check if the tile fits with the adjacent tile
        for (Direction d : adjTiles.keySet()) {
            if (tile.fitsWith(adjTiles.get(d), d)) {
                return putTileAt(c, tile1) && putTileAt(cTile2, tile2);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("   ");
        for (int i = 0; i < length; i++)
            s.append(i).append("  ");
        s.append("\n");
        for (int i = 0; i < length; i++) {
            s.append(i).append(" ");
            for (int j = 0; j < height; j++) {
                s.append((board.get(i).get(j) == null) ? "XX" : board.get(i).get(j)).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}