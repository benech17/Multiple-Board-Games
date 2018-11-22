package model.core.card.tile;

import model.core.card.Card;
import model.core.enums.Direction;

import java.util.*;


public abstract class Tile extends Card {
    protected EnumMap<Direction, Side> sides;

    public Tile() {
        super("Tile", true);
    }

    public EnumMap<Direction, Side> getSides() {
        return sides;
    }

    public void rotate(int distance) {
        ArrayList<Side> sideList = new ArrayList<>(sides.values());
        Collections.rotate(sideList, distance);
        Iterator<Side> iterator = sideList.iterator();
        for (Direction d : sides.keySet())
            sides.put(d, iterator.next());
    }

    @Override
    public String toString() {
        return sides.toString();
    }
}
