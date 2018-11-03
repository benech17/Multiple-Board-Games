import java.util.ArrayList;

public class DominoTile extends Piece {
    public DominoTile(int value1, int value2) {
        super(initSides(value1, value2));
    }

    private static ArrayList<Side> initSides(int value1, int value2) {
        if (!validSides(value1, value2))
            throw new RuntimeException();
        ArrayList<Side> sides = new ArrayList<>();
        sides.add(new DominoSide(value1));
        sides.add(new DominoSide(value2));
        return sides;
    }

    /**
     * Checks if the digits for each side are valid
     * @param value1
     * @param value2
     * @return
     */
    private static boolean validSides(int value1, int value2) {
        return (1 <= value1 && value1 <= 6) && (1 <= value2 && value2 <= 6);
    }

    /**
     * Returns the side matching with a side from the given domino tile
     * @param t
     * @return
     */
    public DominoSide getMatchingSide(DominoTile t) {
        for (Side s1 : t.getAvailableSides()) {
            for (Side s2 : getAvailableSides()) {
                if (s2.equals(s1)) return (DominoSide) s2;
            }
        }
        return null;
    }

    /**
     * Removes a side from the list of available sides
     * @param s
     * @return
     */
    public void removeAvailableSide(Side s) {
        getAvailableSides().remove(s);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        DominoTile d1 = new DominoTile(1, 6);
        DominoTile d2 = new DominoTile(6, 4);
        System.out.println(d1.getMatchingSide(d2)); // Sides match
        DominoTile d3 = new DominoTile(3, 3);
        System.out.println(d2.getMatchingSide(d3)); // Sides don't match
    }


}
