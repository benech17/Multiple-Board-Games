package games.dominoes;

import games.common.model.board.CannotAddTileAtException;
import games.common.model.board.Coordinate;
import games.common.model.board.DefaultBoardImpl;
import games.common.model.board.OutOfBoardBoundsException;
import games.common.model.enums.Direction;

import java.util.EnumMap;


public class DominoesBoard extends DefaultBoardImpl<DominoTile> {

    public DominoesBoard(int height, int length, Coordinate c, DominoPiece piece) {
        super(height, length);
        putTileAt(c, piece.getTile1());
        putTileAt(c.plus(piece.getSide2Position()), piece.getTile2());
    }

    public boolean putTileAt(Coordinate c, DominoPiece piece) throws OutOfBoardBoundsException,
            CannotAddTileAtException {

        DominoTile tile1 = piece.getTile1();
        DominoTile tile2 = piece.getTile2();
        Coordinate position = piece.getSide2Position();
        Direction orientation = piece.getOrientation();

        EnumMap<Direction, DominoTile> adjTilesTile1 = getAdjacentTilesByDirection(c);
        Coordinate cTile2 = c.plus(position); // Coordinate on the board of the second tile
        EnumMap<Direction, DominoTile> adjTilesTile2 = getAdjacentTilesByDirection(cTile2);

        // Removes the tiles of the piece from the adjacent tiles of tile1 and tile2
        adjTilesTile2.remove(orientation.getOppositeDirection());
        adjTilesTile1.remove(orientation);

        // If there are more than 1 adjacent tile, the piece can't be put on the board
        if (adjTilesTile1.keySet().size() + adjTilesTile2.keySet().size() > 1)
            return false;

        EnumMap<Direction, DominoTile> adjTiles;
        DominoTile tile;

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
            s.append(i + "  ");
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