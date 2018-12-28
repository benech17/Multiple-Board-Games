package games.dominoeswithstickers;

import games.core.model.board.CannotAddTileAtException;
import games.core.model.board.Coordinate;
import games.core.model.board.DefaultBoardImpl;
import games.core.model.board.OutOfBoardBoundsException;
import games.core.model.enums.Direction;

import java.util.EnumMap;


public class DominoesStickerBoard extends DefaultBoardImpl<DominoStickerTile> {

    public DominoesStickerBoard(int height, int length) {
        super(height, length);
    }

    public boolean putTileAt(Coordinate c, DominoStickerPiece tile) throws OutOfBoardBoundsException,
            CannotAddTileAtException {
        DominoStickerTile side1 = tile.getTile1();
        DominoStickerTile side2 = tile.getTile2();
        Coordinate position = tile.getSide2Position();

        EnumMap<Direction, DominoStickerTile> adjacentTiles = getAdjacentTilesByDirection(c);
        // We check if the tile fits with each adjacent tile
        for (Direction d : adjacentTiles.keySet()) {
            // We could move the unconnectedPathException in core
            /*if (!tile.fitsWith(adjacentTiles.get(d), d))
                throw new PathCardException.UnconnectedPathException("Illegal move: tunnels must connect!");
        }*/
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                s.append((board.get(i).get(j) == null) ? "XX" : board.get(i).get(j)).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}