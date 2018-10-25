import java.util.ArrayList;

public abstract class Piece {
    private ArrayList<Side> sides;

    public Piece(ArrayList<Side> sides) {
        this.sides = sides;
    }

    public ArrayList<Side> getSides() {
        return sides;
    }

}
