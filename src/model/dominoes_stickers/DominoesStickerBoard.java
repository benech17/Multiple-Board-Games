package model.dominoes_stickers;

import model.core.board.Board;
import model.core.board.Coordinate;
import model.core.card.Card;
import model.core.enums.Direction;
import model.dominoes.DominoTile;

import java.util.HashMap;

public class DominoesStickerBoard extends Board {

    public DominoesStickerBoard(DominoStickerTile t) {
        // We put the first domino tile at the center of the map
        map = new HashMap<>();
        map.put(new Coordinate(0, 0), t);
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
        if (neighbors.get(Direction.TOP) != null) {

        }
        return false;
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

    }
}