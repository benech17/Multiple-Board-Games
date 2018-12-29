package games.dominoes.lineardominos;

import games.common.model.enums.Direction;
import games.dominoes.DominoTile;


public class LinearDominoTile extends DominoTile<LinearDominoSide> {

    public LinearDominoTile(int value) {
        for (Direction d : Direction.values())
            sides.put(d, new LinearDominoSide(value));
    }

    @Override
    public String toString() {
        return getSide(Direction.TOP).toString();
    }
}
