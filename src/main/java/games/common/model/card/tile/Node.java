package games.common.model.card.tile;

import games.common.model.enums.Direction;

import java.util.EnumMap;
import java.util.function.Function;


/**
 * Interface for a tree data structure
 * @deprecated use the method hasPathFromTo in Board instead
 */
public interface Node {
    /**
     * Get the children nodes
     * @return the children nodes
     */
    EnumMap<Direction, Node> getAdjacentNodes();

    /**
     * Performs a Breadth-First Search on the tree data structure
     * starting from the current node
     *
     * @return true if we found a node verifying a special condition given by
     * the function isGoal
     */
    boolean findGoal(Function<Node, Boolean> isGoal);

    /**
     * Checks if the current node is a leaf or not:
     * by leaf is meant that the node is connected to only one node,
     * it is an end of the tree data structure
     * @return true if and only if the node is a leaf
     */
    boolean isLeaf();
}
