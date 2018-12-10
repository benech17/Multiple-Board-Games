package org.julienyaniv.pooig.model.saboteur;

import org.julienyaniv.pooig.model.core.enums.Direction;

public class TestCard extends SaboteurTile {
    public TestCard() {
        super(true);
        setName("Test Card");
        setHidden(false);
        // Has 4 connections
        sides.put(Direction.TOP, new SaboteurSide(this, true));
        sides.put(Direction.BOTTOM, new SaboteurSide(this, true));
        sides.put(Direction.LEFT, new SaboteurSide(this, true));
        sides.put(Direction.RIGHT, new SaboteurSide(this, true));
    }
}
