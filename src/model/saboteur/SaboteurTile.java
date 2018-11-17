package model.saboteur;

import model.core.card.side.Side;
import model.core.card.tile.Tile;

import java.util.ArrayList;

public abstract class SaboteurTile extends Tile {
    public SaboteurTile(ArrayList<Side> sides) {
        super(sides);
    }
}
