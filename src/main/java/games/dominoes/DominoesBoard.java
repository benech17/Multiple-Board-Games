package games.dominoes;

import games.core.model.board.Board;
import games.core.model.board.Coordinate;
import games.core.model.enums.Direction;

import java.util.HashMap;
import java.util.LinkedList;


/**
 * At the end this game of dominoes should be implemented as
 * a subset of the more general game of dominoes in 2d
 */
public class DominoesBoard extends Board<DominoTile> {
    // These coordinates should be removed
    private Coordinate leftEnd, rightEnd; // left and right ends of the board

    public DominoesBoard(DominoTile t) {
        super(1, 10); // à revoir
        map = new LinkedList<>();
        map.add(new LinkedList<>());
        leftEnd = new Coordinate(0, 0);
        rightEnd = leftEnd;
        // We put the first domino tile at the center of the map
        map.get(0).add(t);
    }

    /**
     * Adds the domino tile in the board at the specified position
     *
     * @param t the domino tile to put in the board
     * @param c the coordinate of the specified position
     * @return
     */
    public boolean addDominoTile(DominoTile t, Coordinate c) {
        System.out.println(t + " " + c);
        if (t == null)
            return false;
        HashMap<Direction, Coordinate> neighbors = getAdjacentCoordinates(c);
        if (neighbors.get(Direction.LEFT) != null) {
            if (t.sidesMatch(getTileAt(neighbors.get(Direction.LEFT)), Direction.LEFT)) {
                // Connects the side of the domino tile t with the domino tile to its left
                // Useless in fact
                t.getLeftSide().setNextSide((getTileAt(neighbors.get(Direction.LEFT))).getRightSide());
                map.get(0).add(t);
                rightEnd = c;
                return true;
            }
        }
        if (neighbors.get(Direction.RIGHT) != null) {
            if (t.sidesMatch(getTileAt(neighbors.get(Direction.RIGHT)), Direction.RIGHT)) {
                map.get(0).add(0, t);
                leftEnd = c;
                return true;
            }
        }
        return false;
    }

    public boolean addToLeftEnd(DominoTile t) {
        return addDominoTile(t, leftEnd.add(new Coordinate(0, -1)));
    }

    public boolean addToRightEnd(DominoTile t) {
        return addDominoTile(t, rightEnd.add(new Coordinate(0, 1)));
    }

    @Override
    public String toString() {
        System.out.println(map.get(0).size());
        String s = "";
        for (int j = 0; j < map.get(0).size(); j++) {
            s += map.get(0).get(j);
        }
        return s;
    }
}