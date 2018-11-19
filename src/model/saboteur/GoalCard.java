package model.saboteur;

import model.core.enums.Direction;


public class GoalCard extends SaboteurTile {
    public GoalCard() {
        super(true);
        // Has 4 connections
        sides.put(Direction.TOP, new SaboteurSide(this));
        sides.put(Direction.BOTTOM, new SaboteurSide(this));
        sides.put(Direction.LEFT, new SaboteurSide(this));
        sides.put(Direction.RIGHT, new SaboteurSide(this));
    }

}
