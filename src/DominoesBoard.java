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

    public DominoTile getHead() {
        return tiles.get(0);
    }

    public DominoTile getTail() {
        return tiles.get(tiles.size() - 1);
    }

    public boolean addDominoTile(DominoTile t) {
        if (t == null)
            return false;
        if (tiles.size() == 0) {
            tiles.add(t);
            return true;
        }
        DominoSide match = getHead().getMatchingSide(t);
        if (match != null) {
            tiles.add(0, t);
            getHead().removeAvailableSide(match);
            t.removeAvailableSide(match);
            return true;
        }
        match = getTail().getMatchingSide(t);
        if (match != null) {
            tiles.add(t);
            getTail().removeAvailableSide(match);
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
        System.out.println(board.addDominoTile(d1));
        System.out.println(board.addDominoTile(d2));
        System.out.println(board.addDominoTile(d3));
    }
}