package games.dominoeswithstickers;

import games.core.model.board.CannotAddTileAtException;
import games.core.model.board.Coordinate;
import games.core.model.board.DefaultBoardImpl;
import games.core.model.board.OutOfBoardBoundsException;
import games.core.model.enums.Color;
import games.core.model.enums.Direction;
import games.core.model.enums.Shape;

import java.util.EnumMap;


public class DominoesStickerBoard extends DefaultBoardImpl<DominoStickerTile> {

    public DominoesStickerBoard(DominoStickerTile t) {
        // We put the first domino tile at the center of the board
        super(50, 50);

        //putTileAt(new Coordinate(0, 0), t.getLeftSide());
        //putTileAt(new Coordinate(0, 1), t.getRightSide());
    }


    public boolean putTileAt(Coordinate c, DominoStickerTile tile) throws OutOfBoardBoundsException,
            CannotAddTileAtException {
        DominoStickerSide side1 = tile.getSide1();
        DominoStickerSide side2 = tile.getSide2();
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

    public static void main(String[] args) {
        DominoesStickerBoard b = new DominoesStickerBoard(new DominoStickerTile(Shape.HEART, Color.BLUE, Shape.STAR,
                Color.YELLOW));
        System.out.println(b.toString());

    }
}