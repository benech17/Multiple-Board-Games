package games.saboteur;


import games.core.model.enums.Direction;

public class StartCard extends SaboteurTile {

    public StartCard() {
        super(true);
        setName("Start Card");
        setHidden(false);
        // Has 4 connections
        sides.put(Direction.TOP, new SaboteurSide(this, true));
        sides.put(Direction.BOTTOM, new SaboteurSide(this, true));
        sides.put(Direction.LEFT, new SaboteurSide(this, true));
        sides.put(Direction.RIGHT, new SaboteurSide(this, true));
    }
}
