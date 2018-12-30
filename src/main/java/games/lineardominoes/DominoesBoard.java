package games.lineardominoes;

import games.common.model.enums.Direction;

import java.util.ArrayList;
import java.util.List;


/**
 * At the end this game of lineardominoes should be implemented as
 * a subset of the more general game of lineardominoes in 2d
 */
public class DominoesBoard {
    private List<DominoTile> tiles;

    public DominoesBoard(DominoTile t) {
        this.tiles = new ArrayList<>();
        tiles.add(t);
    }

    public List<DominoTile> getTiles() {
        return tiles;
    }

    public DominoTile getLeftEnd() throws EmptyBoardException {
        if (tiles.isEmpty())
            throw new EmptyBoardException();
        return tiles.get(0);
    }


    public DominoTile getRightEnd() throws EmptyBoardException {
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
    public boolean addDominoTile(DominoTile t, boolean left) {
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
                tiles.add(tiles.size() - 1, t);
                return true;
            }
            return false;
        }
    }

    public boolean addToLeftEnd(DominoTile t) {
        return addDominoTile(t, true);
    }

    public boolean addToRightEnd(DominoTile t) {
        return addDominoTile(t, false);
    }

    @Override
    public String toString() {
        String s = "";
        for (DominoTile t : tiles) {
            s += t.toString();
        }
        return s;
    }
}