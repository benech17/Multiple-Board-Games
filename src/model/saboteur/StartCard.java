package model.saboteur;

import model.core.card.side.Side;
import model.core.card.tile.Tile;
import model.core.enums.Direction;

import java.util.HashMap;

public class StartCard extends SaboteurTile {

    public StartCard() {
        super();
        setName("Start Card");
        setHidden(false);
    }
}
