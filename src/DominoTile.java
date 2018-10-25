import java.util.ArrayList;

public class DominoTile extends Piece {
    public DominoTile(int value1, int value2) {
        super(initSides(value1, value2));
    }

    private static ArrayList<Side> initSides(int value1, int value2) {
        ArrayList<Side> sides = new ArrayList<>();
        sides.add(new DominoSide(value1));
        sides.add(new DominoSide(value2));
        return sides;
    }
}
