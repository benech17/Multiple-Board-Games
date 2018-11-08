import java.util.ArrayList;

public abstract class Tile {
    private ArrayList<Side> sides;
    private ArrayList<Side> availableSides;

    public Tile(ArrayList<Side> sides) {
        this.sides = sides;
        availableSides = new ArrayList<>();
        for (Side s : sides) {
            try {
                availableSides.add(s.clone());
            } catch (CloneNotSupportedException e) {}
        }
    }

    public ArrayList<Side> getSides() {
        return sides;
    }

    public ArrayList<Side> getAvailableSides() {
        return availableSides;
    }

    @Override
    public String toString() {
        return sides.toString();
    }
}
