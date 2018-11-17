package model.core.card.tile;

import model.core.card.side.Side;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Tile {
    private ArrayList<Side> sides;
    //private ArrayList<Side> availableSides; // do we need that?

    public Tile(ArrayList<Side> sides) {
        this.sides = sides;
        /*availableSides = new ArrayList<>();
        for (Side s : sides) {
            try {
                availableSides.add(s.clone());
            } catch (CloneNotSupportedException e) {}
        }*/
    }

    public ArrayList<Side> getSides() {
        return sides;
    }

    /*public ArrayList<Side> getAvailableSides() {
        return availableSides;
    }*/

    public void rotate(int distance) {
        Collections.rotate(sides, distance);
        //Collections.rotate(availableSides, distance);
    }

    @Override
    public String toString() {
        return sides.toString();
    }
}
