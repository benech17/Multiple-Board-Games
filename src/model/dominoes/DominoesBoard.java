package model.dominoes;

import model.core.board.Board;
import model.core.board.Coordinate;
import model.core.enums.Direction;
import model.core.card.Card;

import java.util.HashMap;
import java.util.Stack;

public class DominoesBoard extends Board {

    public DominoesBoard() {
        map = new HashMap<>();
    }

    public HashMap<Coordinate, Stack<Card>> getTiles() {
        return map;
    }

    /*public DominoTile getLeftEnd() throws EmptyBoardException {
        if (map.isEmpty())
            throw new EmptyBoardException();
        return map.get(0);
    }*/

    /*public DominoTile getRightEnd() throws EmptyBoardException {
        if (map.isEmpty())
            throw new EmptyBoardException();
        return map.get(map.size() - 1);
    }*/

    /**
     *
     * @return the outward-facing value on the left end of the board
     * @throws EmptyBoardException
     */
    /*public DominoSide getLeftEndSide() throws EmptyBoardException {
        return  getLeftEnd().getLeftSide();
    }*/

    /**
     *
     * @return the outward-facing value on the right end of the board
     * @throws EmptyBoardException
     */
    /*public DominoSide getRightEndSide() throws EmptyBoardException {
        return getRightEnd().getRightSide();
    }*/

    /**
     * Adds the domino tile in the board at the specified position
     * @param t the domino tile to put in the board
     * @param c the coordinate of the specified position
     * @return
     */
    public boolean addDominoTile(DominoTile t, Coordinate c) {
        if (t == null)
            return false;
        if (map.isEmpty()) {
            // If the map is empty we put the first domino tile at the center
            addCardToMap(new Coordinate(0, 0), t);
            return true;
        }
        HashMap<Direction, Coordinate> neighbors = getAdjacentCoordinates(c);
        if (neighbors.get(Direction.LEFT) != null) {
            if(t.sidesMatch((DominoTile) getStackCard(neighbors.get(Direction.LEFT)).peek(), Direction.LEFT)) {
                addCardToMap(c, t);
                return true;
            }
        }
        if (neighbors.get(Direction.RIGHT) != null) {
            if (t.sidesMatch((DominoTile) getStackCard(neighbors.get(Direction.RIGHT)).peek(), Direction.RIGHT)) {
                addCardToMap(c, t);
                return true;
            }
        }
        return false;
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
        DominoesBoard board = new DominoesBoard();
        System.out.println(board);

        System.out.println(board.addDominoTile(d1, new Coordinate(0, 0)));
        System.out.println(board);
        System.out.println(board.addDominoTile(d2, new Coordinate(0, 1)));
        System.out.println(board);
        System.out.println(board.addDominoTile(d3, new Coordinate(0, -1)));
        System.out.println(board);
        System.out.println(board.addDominoTile(new DominoTile(2, 6), new Coordinate(0, 1)));
        System.out.println(board);

    }

    private class EmptyBoardException extends RuntimeException {
    }
}