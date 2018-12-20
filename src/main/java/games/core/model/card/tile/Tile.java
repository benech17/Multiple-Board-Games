package games.core.model.card.tile;

import games.core.model.enums.Direction;


/**
 * Abstract data type for a tile
 * @param <S> the type of side of the tile
 */
public interface Tile<S> {

    S getTopSide();

    S getLeftSide();

    S getRightSide();

    S getBottomSide();

    /**
     * Returns true if the current instance of Tile and the Tile t
     * fit together. Can flip or rotate the current instance according
     * to the direction d as an option.
     * @param t a tile adjacent to the current tile
     * @param d the position of the tile t with respect to the current tile
     * @return true if the current tile and the tile t fit together
     */
    boolean fitsWith(Tile<S> t, Direction d);
}
