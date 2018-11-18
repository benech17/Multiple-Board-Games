package model.saboteur;

import model.core.enums.Direction;


public class GoalCard extends SaboteurTile {
    public GoalCard() {
        sides.put(Direction.TOP, new SaboteurSide(true, this));
    }

}
