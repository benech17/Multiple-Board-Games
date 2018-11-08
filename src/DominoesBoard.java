import java.util.ArrayList;

public class DominoesBoard extends Board {
    private ArrayList<DominoTile> tiles;

    public DominoesBoard(ArrayList<DominoTile> tiles) {
        this.tiles = tiles;
    }

    public DominoesBoard() {
        this(new ArrayList<>());
    }

    public ArrayList<DominoTile> getTiles() {
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
     *
     * @return the outward-facing value on the left end of the board
     * @throws EmptyBoardException
     */
    public DominoSide getLeftEndSide() throws EmptyBoardException {
        return  getLeftEnd().getLeftSide();
    }

    /**
     *
     * @return the outward-facing value on the right end of the board
     * @throws EmptyBoardException
     */
    public DominoSide getRightEndSide() throws EmptyBoardException {
        return getRightEnd().getRightSide();
    }

    /**
     * Adds the provided domino tile to the specified end of the board
     * @param t
     * @param left
     * @return true if the domino tile was added, if not, false
     */
    public boolean addDominoTile(DominoTile t, boolean left) {
        if (t == null)
            return false;
        if (tiles.isEmpty()) {
            tiles.add(t);
            return true;
        }
        DominoSide match;
        if (left) match = t.getMatchingSide(getLeftEndSide(), left);
        else match = t.getMatchingSide(getRightEndSide(), left);
        if (match != null) {
            if (left) {
                tiles.add(0, t);
                getLeftEnd().removeAvailableSide(match);
            }
            else {
                tiles.add(t);
                getRightEnd().removeAvailableSide(match);
            }
            t.removeAvailableSide(match);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (DominoTile t : tiles) {
            s += t.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        DominoTile d1 = new DominoTile(1, 6);
        DominoTile d2 = new DominoTile(2, 4);
        DominoTile d3 = new DominoTile(2, 1);
        DominoesBoard board = new DominoesBoard();
        System.out.println(board.addDominoTile(d1, true));
        System.out.println(board.addDominoTile(d2, false));
        System.out.println(board);
        System.out.println(board.addDominoTile(d3, true));
        System.out.println(board);
        System.out.println(board.addDominoTile(new DominoTile(2, 6), true));
        System.out.println(board);
    }

    private class EmptyBoardException extends RuntimeException {
    }
}