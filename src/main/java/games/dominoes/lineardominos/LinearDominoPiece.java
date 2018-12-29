package games.dominoes.lineardominos;

import games.common.model.enums.Direction;
import games.dominoes.DominoPiece;


public class LinearDominoPiece extends DominoPiece<LinearDominoTile> {

    public LinearDominoPiece(int value1, int value2) {
        this(new LinearDominoTile(value1), new LinearDominoTile(value2));
    }

    public LinearDominoPiece(int value1, int value2, Direction orientation) {
        this(new LinearDominoTile(value1), new LinearDominoTile(value2), orientation);
    }

    public LinearDominoPiece(LinearDominoTile tile1, LinearDominoTile tile2) {
        super(tile1, tile2);
    }

    public LinearDominoPiece(LinearDominoTile tile1, LinearDominoTile tile2, Direction orientation) {
        super(tile1, tile2, orientation);
    }
}
