package games.lineardominoes;

import games.common.model.enums.Direction;

import java.util.ArrayList;
import java.util.List;


/**
 * At the end this game of lineardominoes should be implemented as
 * a subset of the more general game of lineardominoes in 2d
 */
public class LinearDominoesBoard {
    private List<LinearDominoTile> tiles;

    public LinearDominoesBoard(LinearDominoTile t) {
        this();
        tiles.add(t);
    }

    public LinearDominoesBoard() {
        this.tiles = new ArrayList<>();
    }

    public List<LinearDominoTile> getTiles() {
        return tiles;
    }

    public LinearDominoTile getLeftEnd() throws EmptyBoardException {
        if (tiles.isEmpty())
            throw new EmptyBoardException();
        return tiles.get(0);
    }


    public LinearDominoTile getRightEnd() throws EmptyBoardException {
        if (tiles.isEmpty())
            throw new EmptyBoardException();
        return tiles.get(tiles.size() - 1);
    }

    /**
     * Adds the provided domino tile to the specified end of the board
     *
     * @param t
     * @param left
     * @return true if the domino tile was added, if not, false
     */
    public boolean addDominoTile(LinearDominoTile t, boolean left) {
        if (t == null)
            return false;
        if (tiles.size() == 0) {
            tiles.add(t);
            return true;
        }
        if (left) {
            if (t.fitsWith(getLeftEnd(), Direction.RIGHT)) {
                tiles.add(0, t);
                return true;
            }
            return false;
        } else {
            if (t.fitsWith(getRightEnd(), Direction.LEFT)) {
                tiles.add(t);
                return true;
            }
            return false;
        }
    }

    public boolean addToLeftEnd(LinearDominoTile t) {
        return addDominoTile(t, true);
    }

    public boolean addToRightEnd(LinearDominoTile t) {
        return addDominoTile(t, false);
    }

    public boolean tileCanBePut(LinearDominoTile t) {
        if (tiles.isEmpty())
            return true;
        return t.fitsWith(getRightEnd(), Direction.LEFT) || t.fitsWith(getLeftEnd(), Direction.RIGHT);
    }

    @Override
    public String toString() {
        String s = "";
        for (LinearDominoTile t : tiles) {
            s += t.toString();
        }
        return s;
    }
}