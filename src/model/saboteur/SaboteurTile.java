package model.saboteur;

import model.core.card.Card;
import model.core.card.tile.Side;
import model.core.card.tile.Tile;
import model.core.enums.Direction;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


public abstract class SaboteurTile extends Tile {
    private boolean hasPath;

    public SaboteurTile(boolean hasPath) {
        this.hasPath = hasPath;
    }

    /**
     * Performs a Breadth-First Search on the graph structure
     * starting from the current instance of SaboteurTile
     *
     * @return true if a treasure has been reached
     */
    public boolean treasureReached() {
        // Queue of tiles to visit
        Queue<SaboteurTile> toVisit = new LinkedList<>();
        // Queue of visited tiles
        Queue<SaboteurTile> visitedTiles = new LinkedList<>();
        toVisit.add(this); // Push current node to the queue
        while (!toVisit.isEmpty()) {
            /* Handle the case where the current tile is null
             * This happens when a card has been removed from
             * the board using a bomb card
             */
            if (toVisit.peek() != null) {
                // Pop the next tile to visit
                SaboteurTile t = toVisit.poll();
                System.out.println(t.getClass()); // debug

                if (t instanceof TreasureCard)
                    return true;

                // This tile has already been visited, we skip it
                if (visitedTiles.contains(t))
                    continue;

                visitedTiles.add(t);

                for (Side child : t.sides.values()) {
                    if (child.getNextSide() == null)
                        continue;
                    SaboteurTile childTile = (SaboteurTile) child.getNextSide().getParent();
                    toVisit.add(childTile);
                }
            } else {
                toVisit.remove();
            }
        }
        return false;
    }

    public boolean isHasPath() {
        return hasPath;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
