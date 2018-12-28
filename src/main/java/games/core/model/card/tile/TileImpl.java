package games.core.model.card.tile;

import games.core.model.enums.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;


/**
 * Default implementation of a tile
 * In the future make several implementations of a tile that implement
 * different behaviours (using interfaces)
 *
 * @param <S>
 */
// Got help from StackOverflow https://stackoverflow.com/questions/53958810/two-generic-interfaces-referencing-each-other
public abstract class TileImpl<S extends Side<? extends Tile<S>>> implements Tile<S>, Turnable { //
    // implement
    // Node
    protected EnumMap<Direction, S> sides;
    //protected EnumMap<Direction, Node> adjacentNodes;

    public TileImpl() {
        sides = new EnumMap<>(Direction.class);
        //adjacentNodes = new EnumMap<>(Direction.class);
    }

    /*@Override
    public EnumMap<Direction, Node> getAdjacentNodes() {
        // We build the board each time we call the function:
        // we may update it each time we add a new connexion
        for (Direction d : sides.keySet()) {
            //System.out.println(sides.get(d));
            if (sides.get(d) != null && sides.get(d).getNextSide() != null)
                adjacentNodes.put(d, sides.get(d).getNextSide().getParent());
        }
        return adjacentNodes;
    }*/

    public EnumMap<Direction, S> getSides() {
        return sides;
    }

    @Override
    public S getSide(Direction d) {
        return sides.get(d);
    }

    @Override
    public S getTopSide() {
        return getSide(Direction.TOP);
    }

    @Override
    public S getBottomSide() {
        return getSide(Direction.BOTTOM);
    }

    @Override
    public S getLeftSide() {
        return getSide(Direction.LEFT);
    }

    @Override
    public S getRightSide() {
        return getSide(Direction.RIGHT);
    }

    @Override
    public void rotate(int distance) {
        ArrayList<S> sideList = new ArrayList<>(sides.values());
        Collections.rotate(sideList, distance);
        Iterator<S> iterator = sideList.iterator();
        for (Direction d : sides.keySet())
            sides.put(d, iterator.next());
    }

    @Override
    public boolean fitsWith(Tile t, Direction d) {
        return (t != null) && getSide(d).equals(t.getSide(d.getOppositeDirection()));
    }

    /*@Override
    public boolean findGoal(Function<Node, Boolean> isGoal) {
        // Queue of tiles to visit
        Queue<Node> toVisit = new LinkedList<>();
        // Queue of visited tiles
        Queue<Node> visitedTiles = new LinkedList<>();
        toVisit.add(this); // Push the current node to the queue
        while (!toVisit.isEmpty()) {
            if (toVisit.peek() != null) {
                // Pop the next tile to visit
                Node t = toVisit.poll();
                // We've found the goal, the job is done
                if (isGoal.apply(t))
                    return true;
                // This tile has already been visited, we skip it
                if (visitedTiles.contains(t))
                    continue;
                visitedTiles.add(t);
                for (Node child : t.getAdjacentNodes().values()) {
                    if (child != null)
                        toVisit.add(child);
                }
            } else {
                // Handle the case where the current tile is null
                toVisit.remove();
            }
        }
        return false;
    }*/

    /**
     * Checks if the current node is a leaf or not
     * @return true if and only if all the adjacent nodes
     * (child nodes) are null
     */
    /*@Override
    public boolean isLeaf() {
        *//* If the current node is a leaf then it has only one adjacent
            node which isn't null *//*
        // Is that true for all the games ? Might be overrided
        // Moreover the puzzle doesn't need a tree
        return getAdjacentNodes().size() == 1;
    }*/

    @Override
    public String toString() {
        return sides.toString();
    }
}
