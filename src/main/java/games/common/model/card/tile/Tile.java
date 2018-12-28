package games.common.model.card.tile;

import games.common.model.enums.Direction;


/**
 * Abstract data type for a tile
 * @param <S> the type of side of the tile
 */
public interface Tile<S extends Side<? extends Tile<S>>> {

    S getSide(Direction d);

    S getTopSide();

    S getLeftSide();

    S getRightSide();

    S getBottomSide();

    /**
     * Returns true if the current instance of Tile and the Tile t
     * fit together (if their adjacent sides are equal).
     * @param t a tile adjacent to the current tile
     * @param d the position of the tile t with respect to the current tile
     * @return true if the current tile and the tile t fit together
     */
    boolean fitsWith(Tile<S> t, Direction d);

    /**
     * Returns true if the current instance of Tile and the Tile t
     * fir together according to a rule.
     *
     * @param t         a tile adjacent to the current tile
     * @param d         the position of the tile t with respect to the current tile
     * @param matchRule rule that returns true if the two tiles fit together
     * @return true if the current tile and the tile t fit together
     */
    boolean fitsWith(Tile<S> t, Direction d, SidesMatch<S> matchRule);
}
