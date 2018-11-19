package model.saboteur;

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
     * @return true if a treasure has been reached
     */
    public boolean treasureReached() {
        // TODO comment the code
        // Queue of tiles to visit
        Queue<SaboteurTile> queue = new ArrayDeque<>();
        LinkedList<SaboteurTile> visitedTiles = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                SaboteurTile t = queue.poll();

                if (t instanceof GoalCard)
                    return true;

                if (visitedTiles.contains(t))
                    continue;

                visitedTiles.add(t);

                for (Side child : sides.values()) {
                    if (child.getNextSide() == null) continue;
                    SaboteurTile childTile = (SaboteurTile) child.getNextSide().getParent();
                    queue.add(childTile);
                }
            } else {
                queue.remove();
            }
        }
        return false;
    }

    public boolean isHasPath() {
        return hasPath;
    }
}
