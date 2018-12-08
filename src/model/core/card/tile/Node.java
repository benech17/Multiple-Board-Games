package model.core.card.tile;

import model.core.enums.Direction;

import java.util.EnumMap;
import java.util.function.Function;


/**
 * Interface for a tree data structure
 */
public interface Node {
    /**
     * Get the map of adjacent (children) nodes
     * @return the nodes adjacent to the current node
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
