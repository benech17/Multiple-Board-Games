import java.util.ArrayList;

public class DominoesBoard extends Board {
    private ArrayList<DominoTile> array;

    public DominoesBoard(ArrayList<DominoTile> array) {
        this.array = array;
    }

    public ArrayList<DominoTile> getArray() {
        return array;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void display() {
        return;
    }
}