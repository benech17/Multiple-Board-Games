package model.dominoes;

import model.core.board.Board;
import model.core.board.Coordinate;
import model.core.enums.Direction;
import model.core.card.Card;

import java.util.HashMap;
import java.util.Stack;

public class DominoesBoard extends Board {
    private Coordinate leftEnd, rightEnd; // left and right ends of the board

    public DominoesBoard(DominoTile t) {
        map = new HashMap<>();
        // We put the first domino tile at the center of the map
        leftEnd = new Coordinate(0, 0);
        rightEnd = leftEnd;
        Stack<Card> s = new Stack<>();
        s.push(t);
        map.put(leftEnd, s);
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
            if(t.sidesMatch((DominoTile) getStackCard(neighbors.get(Direction.LEFT)).peek(), Direction.LEFT)) {
                addCardToMap(c, t);
                rightEnd = c;
                return true;
            }
        }
        if (neighbors.get(Direction.RIGHT) != null) {
            if (t.sidesMatch((DominoTile) getStackCard(neighbors.get(Direction.RIGHT)).peek(), Direction.RIGHT)) {
                addCardToMap(c, t);
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
        for (Stack<Card> cards : map.values()) {
            s += cards.peek();
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