package games.saboteur;

import games.core.model.enums.Direction;


public class GoalCard extends SaboteurTile {
    public GoalCard() {
        super(true);
        // Has 4 connections
        sides.put(Direction.TOP, new SaboteurSide(this, true));
        sides.put(Direction.BOTTOM, new SaboteurSide(this, true));
        sides.put(Direction.LEFT, new SaboteurSide(this, true));
        sides.put(Direction.RIGHT, new SaboteurSide(this, true));
    }


}
