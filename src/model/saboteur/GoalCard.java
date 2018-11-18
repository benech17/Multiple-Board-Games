package model.saboteur;

import model.core.enums.Direction;


public class GoalCard extends SaboteurTile {
    public GoalCard() {
        sides.put(Direction.TOP, new SaboteurSide(true, this));
        sides.put(Direction.BOTTOM, new SaboteurSide(true, this));
        sides.put(Direction.LEFT, new SaboteurSide(true, this));
        sides.put(Direction.RIGHT, new SaboteurSide(true, this));
    }

}
