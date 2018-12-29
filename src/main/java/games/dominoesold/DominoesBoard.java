package games.dominoesold;

import games.common.model.board.BoardImpl;
import games.common.model.board.Coordinate;


/**
 * At the end this game of dominoesold should be implemented as
 * a subset of the more general game of dominoesold in 2d
 */
public class DominoesBoard extends BoardImpl<DominoTile> {
    // These coordinates should be removed
    private Coordinate leftEnd, rightEnd; // left and right ends of the board

    public DominoesBoard(DominoTile t) {
        super(10, 10);
        leftEnd = new Coordinate(0, 0);
        rightEnd = leftEnd;
        // We put the first domino tile at the center of the board
        board.get(0).set(0, t);
    }

    /**
     * Adds the domino tile in the board at the specified position
     *
     * @param t the domino tile to put in the board
     * @param c the coordinate of the specified position
     * @return
     */
    /**
     * public boolean addDominoTile(DominoTile t, Coordinate c) {
     * System.out.println(t + " " + c);
     * if (t == null)
     * return false;
     * HashMap<Direction, Coordinate> neighbors = getAdjacentCoordinates(c);
     * if (neighbors.get(Direction.LEFT) != null) {
     * if (t.fitsWith(getTileAt(neighbors.get(Direction.LEFT)), Direction.LEFT)) {
     * // Connects the side of the domino tile t with the domino tile to its left
     * // Useless in fact
     * t.getLeftSide().setNextSide((getTileAt(neighbors.get(Direction.LEFT))).getRightSide());
     * board[0][0] = t;
     * rightEnd = c;
     * return true;
     * }
     * }
     * if (neighbors.get(Direction.RIGHT) != null) {
     * if (t.fitsWith(getTileAt(neighbors.get(Direction.RIGHT)), Direction.RIGHT)) {
     * board[0][0] = t;
     * leftEnd = c;
     * return true;
     * }
     * }
     * return false;
     * }
     * <p>
     * public boolean addToLeftEnd(DominoTile t) {
     * return addDominoTile(t, leftEnd.add(new Coordinate(0, -1)));
     * }
     * <p>
     * public boolean addToRightEnd(DominoTile t) {
     * return addDominoTile(t, rightEnd.add(new Coordinate(0, 1)));
     * }
     */

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < height; j++) {
            s.append(board.get(0).get(j));
        }
        return s.toString();
    }
}