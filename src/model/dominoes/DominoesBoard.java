package model.dominoes;

import model.core.board.Board;
import model.core.board.Coordinate;
import model.core.enums.Direction;
import model.core.card.Card;

import java.util.HashMap;

public class DominoesBoard extends Board {
    private Coordinate leftEnd, rightEnd; // left and right ends of the board

    public DominoesBoard(DominoTile t) {
        leftEnd = new Coordinate(0, 0);
        rightEnd = leftEnd;
        // We put the first domino tile at the center of the map
        map = new HashMap<>();
        map.put(leftEnd, t);
    }

    /**
     * Adds the domino tile in the board at the specified position
     * @param t the domino tile to put in the board
     * @param c the coordinate of the specified position
     * @return
     */
    public boolean addDominoTile(DominoTile t, Coordinate c) {
        if (t == null)
            return false;
        HashMap<Direction, Coordinate> neighbors = getAdjacentCoordinates(c);
        if (neighbors.get(Direction.LEFT) != null) {
            if(t.sidesMatch((DominoTile) getTileAt(neighbors.get(Direction.LEFT)), Direction.LEFT)) {
                // Connects the side of the domino tile t with the domino tile to its left
                t.getLeftSide().setNextSide(((DominoTile) getTileAt(neighbors.get(Direction.LEFT))).getRightSide());
                addTileToMap(c, t);
                rightEnd = c;
                return true;
            }
        }
        if (neighbors.get(Direction.RIGHT) != null) {
            if (t.sidesMatch((DominoTile) getTileAt(neighbors.get(Direction.RIGHT)), Direction.RIGHT)) {
                addTileToMap(c, t);
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
        String s = "";
        for (Card c : map.values()) {
            s += c;
        }
        return s;
    }

    public static void main(String[] args) {
        DominoTile d1 = new DominoTile(1, 6);
        DominoTile d2 = new DominoTile(2, 4);
        DominoTile d3 = new DominoTile(2, 1);
        DominoesBoard board = new DominoesBoard(d1);
        System.out.println(board);

        System.out.println(board.addDominoTile(d2, new Coordinate(0, 1)));
        System.out.println(board);
        System.out.println(board.addToLeftEnd(d3));
        System.out.println(board);
        System.out.println(board.addToRightEnd(new DominoTile(2, 6)));
        System.out.println(board.leftEnd);
        System.out.println(board.rightEnd);

        System.out.println(board);

    }
}