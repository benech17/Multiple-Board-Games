package games.core.model.card.tile;

import games.core.model.enums.Direction;
import games.core.model.card.Card;

import java.util.*;
import java.util.function.Function;


/**
 * Default implementation of a tile
 * In the future make several implementations of a tile that implement
 * different behaviours (using interfaces)
 *
 * @param <S>
 */
public abstract class AbstractTile<S extends Side> extends Card implements Node, Turnable {
    protected EnumMap<Direction, S> sides;
    protected EnumMap<Direction, Node> adjacentNodes;

    public AbstractTile() {
        super("AbstractTile", true);
        sides = new EnumMap<>(Direction.class);
        adjacentNodes = new EnumMap<>(Direction.class);
    }

    @Override
    public EnumMap<Direction, Node> getAdjacentNodes() {
        // We build the map each time we call the function:
        // we may update it each time we add a new connexion
        for (Direction d : sides.keySet()) {
            //System.out.println(sides.get(d));
            if (sides.get(d) != null && sides.get(d).getNextSide() != null)
                adjacentNodes.put(d, sides.get(d).getNextSide().getParent());
        }
        return adjacentNodes;
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

    @Override
    public void rotate(int distance) {
        ArrayList<S> sideList = new ArrayList<>(sides.values());
        Collections.rotate(sideList, distance);
        Iterator<S> iterator = sideList.iterator();
        for (Direction d : sides.keySet())
            sides.put(d, iterator.next());
    }

    @Override
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
    }

    /**
     * Checks if the current node is a leaf or not
     * @return true if and only if all the adjacent nodes
     * (child nodes) are null
     */
    @Override
    public boolean isLeaf() {
        /* If the current node is a leaf then it has only one adjacent
            node which isn't null */
        // Is that true for all the games ? Might be overrided
        // Moreover the puzzle doesn't need a tree
        return getAdjacentNodes().size() == 1;
    }

    @Override
    public String toString() {
        return sides.toString();
    }
}
