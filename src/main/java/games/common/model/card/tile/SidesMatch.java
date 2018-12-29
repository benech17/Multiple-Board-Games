package games.common.model.card.tile;


/**
 * Returns true if two sides match
 *
 * @param <S> the type of the side
 */
@FunctionalInterface
public interface SidesMatch<S extends Side> {
    /**
     * Checks if the two given sides fit together
     *
     * @param side1 first side
     * @param side2 second side
     * @return true if the two sides fit together
     */
    boolean apply(S side1, S side2);
}
