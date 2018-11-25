package model.core.card.tile;

import model.core.card.Card;
import model.core.enums.Direction;

import java.util.*;


public abstract class Tile<S> extends Card {
    protected EnumMap<Direction, S> sides;

    public Tile() {
        super("Tile", true);
        sides = new EnumMap<>(Direction.class);
    }

    public EnumMap<Direction, S> getSides() {
        return sides;
    }

    public S getTopSide() {
        return sides.get(Direction.TOP);
    }

    public S getBottomSide() {
        return sides.get(Direction.BOTTOM);
    }

    public S getLeftSide() {
        return sides.get(Direction.LEFT);
    }

    public S getRightSide() {
        return sides.get(Direction.RIGHT);
    }

    public void rotate(int distance) {
        ArrayList<S> sideList = new ArrayList<>(sides.values());
        Collections.rotate(sideList, distance);
        Iterator<S> iterator = sideList.iterator();
        for (Direction d : sides.keySet())
            sides.put(d, iterator.next());
    }

    @Override
    public String toString() {
        return sides.toString();
    }
}
