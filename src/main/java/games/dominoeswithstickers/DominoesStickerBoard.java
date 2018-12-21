package games.dominoeswithstickers;

import games.core.model.board.AbstractBoard;
import games.core.model.board.Coordinate;
import games.core.model.enums.Color;
import games.core.model.enums.Shape;


public class DominoesStickerBoard extends AbstractBoard<DominoStickerSide> {

    public DominoesStickerBoard(DominoStickerTile t) {
        // We put the first domino tile at the center of the board
        super(50, 50);

        putTileAt(new Coordinate(0, 0), t.getLeftSide());
        putTileAt(new Coordinate(0, 1), t.getRightSide());
    }

    /**
     * Adds the domino tile in the board at the specified position
     * @param t the domino tile to put in the board
     * @param c the coordinate of the specified position
     * @return
     */
    public boolean addDominoTile(DominoStickerTile t, Coordinate c) {
        /*if (t == null)
            return false;
        HashMap<Direction, Coordinate> neighbors = getAdjacentCoordinates(c);
        if (neighbors.get(Direction.LEFT) != null) {
            if(t.sidesMatch(getTileAt(neighbors.get(Direction.LEFT)), Direction.LEFT)) {
                // Connects the side of the domino tile t with the domino tile to its left
                // Useless in fact
                t.getLeftSide().setNextSide((getTileAt(neighbors.get(Direction.LEFT))).getRightSide());
                board.get(0).add(t);
                return true;
            }
        }
        if (neighbors.get(Direction.RIGHT) != null) {
            if (t.sidesMatch(getTileAt(neighbors.get(Direction.RIGHT)), Direction.RIGHT)) {
                board.get(0).add(0, t);
                return true;
            }
        }
        */
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                s += ((board[i][j] == null) ? "XX" : board[i][j]) + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        DominoesStickerBoard b = new DominoesStickerBoard(new DominoStickerTile(Shape.HEART, Color.BLUE, Shape.STAR,
                Color.YELLOW));
        System.out.println(b.toString());

    }
}