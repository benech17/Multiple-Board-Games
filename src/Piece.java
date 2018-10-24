import java.util.ArrayList;

public abstract class Piece {
    private ArrayList<Cote> cotes;

    public Piece(ArrayList<Cote> cotes) {
        this.cotes = cotes;
    }

    public ArrayList<Cote> getCotes() {
        return cotes;
    }

}
