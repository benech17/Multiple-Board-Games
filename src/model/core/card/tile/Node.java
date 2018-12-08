package model.core.card.tile;

import model.core.enums.Direction;

import java.util.EnumMap;
import java.util.function.Function;


public interface Node {
    EnumMap<Direction, Node> getAdjacentNodes();

    boolean findGoal(Node startNode, Function<Node, Boolean> isGoal);

    boolean isLeaf();
}
