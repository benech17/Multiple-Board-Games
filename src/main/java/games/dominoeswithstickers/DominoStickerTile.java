package games.dominoeswithstickers;

import games.core.model.card.tile.TileImpl;
import games.core.model.enums.Color;
import games.core.model.enums.Direction;
import games.core.model.enums.Shape;


/**
 * A domino sticker tile is made of two domino sticker sides that implement
 * the Tile interface.
 * <p>
 * The orientation of the domino sticker side is determined by the position of
 * the second side with respect to the first side (TOP, RIGHT, BOTTOM, LEFT).
 */
public class DominoStickerTile extends TileImpl<DominoStickerSide> {
    private DominoStickerPiece parentPiece;


    public DominoStickerTile(Shape shape, Color color, DominoStickerPiece parentPiece) {
        for (Direction d : Direction.values())
            sides.put(d, new DominoStickerSide(shape, color, this));
        this.parentPiece = parentPiece;
    }

    /**
     * Returns true if the current instance of DominoTile and the domino
     * tile t have a side in common. Flips or rotate the current instance
     * if necessary according to the direction d.
     *
     * @param t a domino tile adjacent to the current domino tile
     * @param d the position of the domino tile t with respect to the current
     *          domino tile
     * @return true if the current domino tile and the domino tile t share the
     * same side
     */
    /*public boolean fitsWith(DominoStickerTile t, Direction d) {
        if (t == null) return false;
        switch (d) {
            case TOP:
                return aux(this::getTopSide, this::getBottomSide, t::getBottomSide);
            case BOTTOM:
                return aux(this::getBottomSide, this::getTopSide, t::getTopSide);
            case LEFT:
                return aux(this::getLeftSide, this::getRightSide, t::getRightSide);
            case RIGHT:
                return aux(this::getRightSide, this::getLeftSide, t::getLeftSide);
        }
        return false;
    }*/



    /*@Override
    public String toString() {
        if (vertical)
            return "[" + getLeftSide().toString() + "|" + getRightSide().toString() + "]";
        else
            return  getTopSide() + "\n" + getBottomSide();
    }*/


    // write public void rotate(int distance) ?


    /**
     * We'd like to make a DominoStickerTile made of two DominoStickerTiles
     * @return
     */
    /*public DominoStickerTile(Shape shape, Color color) {
        sides = new EnumMap<>(Direction.class);
        for (Direction d : Direction.values()) {
            sides.put(d, new DominoStickerSide(shape, color, this));
        }
        vertical = true;
        setName();
    }*/

    /**
     * Rotates by 90° clockwise the domino tile
     */
    /*public void rotate90() {
        rotate(1);
        // Change orientation
        vertical = !vertical;
    }*/

    /**
     * Exchanges both sides
     */
    /*public void flip() {
        rotate(2);
    }*/

    // TODO Add doc
    /*private boolean aux(Supplier<DominoStickerSide> firstSide,
                        Supplier<DominoStickerSide> secondSide,
                        Supplier<DominoStickerSide> otherSide) {
        if (firstSide.get() == null)
            rotate90();
        if (firstSide.get().equals(otherSide.get()))
            return true;
        if (secondSide.get().equals(otherSide.get())) {
            flip();
            return true;
        }
        return false;
    }*/

    /*@Override
    public boolean fitsWith(Tile t, Direction d) {
        return super.fitsWith(t, d);
    }*/
    @Override
    public String toString() {
        return getSide(Direction.TOP).toString();
    }
}
