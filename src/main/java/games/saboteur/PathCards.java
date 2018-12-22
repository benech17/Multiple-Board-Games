package games.saboteur;


/**
 * Enumerates the different sorts of path cards
 */
public enum PathCards {
    ONE(false, true, true, false, false),
    TWO(false, false, true, true, false),
    THREE(true, false, true, false, false),
    FOUR(false, false, false, true, false),
    FIVE(false, false, true, false, false),
    SIX(true, false, true, true, false),
    SEVEN(true, true, true, true, false),
    EIGHT(false, true, false, true, false),
    NINE(false, true, true, true, false),
    TEN(true, true, true, true, true),
    ELEVEN(false, true, false, true, true),
    TWELVE(false, true, true, true, true),
    THIRTEEN(false, true, true, false, true),
    FOURTEEN(false, false, true, true, true),
    FIFTEEN(true, false, true, false, true),
    SIXTEEN(true, true, true, false, true);

    private Boolean[] paths;

    /**
     * Initialize a path card
     * @param top true if there is a top connection
     * @param right true if there is a right connection
     * @param bottom true if there is a bottom connection
     * @param left true if there is a left connection
     * @param path true if the connections are connected by a path
     */
    PathCards(boolean top, boolean right, boolean bottom, boolean left, boolean path) {
        this.paths = new Boolean[]{top, right, bottom, left, path};
    }

    public Boolean[] getPaths() {
        return paths;
    }
}
