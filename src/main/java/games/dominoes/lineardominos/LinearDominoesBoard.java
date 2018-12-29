package games.dominoes.lineardominos;

import games.common.model.board.CannotAddTileAtException;
import games.common.model.board.Coordinate;
import games.common.model.board.OutOfBoardBoundsException;
import games.dominoes.DominoesBoard;

public class LinearDominoesBoard extends DominoesBoard<LinearDominoPiece, LinearDominoTile> {
    private Coordinate head, tail;

    public LinearDominoesBoard(int height, int length, Coordinate c, LinearDominoPiece piece) {
        super(height, length, c, piece);
        head = c;
        tail = c.plus(piece.getTile2Position());
    }

    public Coordinate getHead() {
        return head;
    }

    public Coordinate getTail() {
        return tail;
    }

    @Override
    public boolean putTileAt(Coordinate c, LinearDominoPiece piece) throws OutOfBoardBoundsException, CannotAddTileAtException {
        boolean tile1AdjacentToHead = getAdjacentTilesByCoordinates(c).contains(head);
        boolean tile2AdjacentToHead = getAdjacentTilesByCoordinates(c.plus(piece.getTile2Position())).contains(head);
        boolean tile1AdjacentToTail = getAdjacentTilesByCoordinates(c).contains(tail);
        boolean tile2AdjacentToTail = getAdjacentTilesByCoordinates(c.plus(piece.getTile2Position())).contains(tail);

        if (tile1AdjacentToHead && super.putTileAt(c, piece)) {
            head = c.plus(piece.getTile2Position());
            return true;
        }
        if (tile2AdjacentToHead && super.putTileAt(c, piece)) {
            head = c;
            return true;
        }
        if (tile1AdjacentToTail && super.putTileAt(c, piece)) {
            tail = c.plus(piece.getTile2Position());
            return true;
        }
        if (tile2AdjacentToTail && super.putTileAt(c, piece)) {
            tail = c;
            return true;
        }
        return false;
    }
}
