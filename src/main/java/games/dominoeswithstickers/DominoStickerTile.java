package games.dominoeswithstickers;

import games.core.model.board.Coordinate;
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
    private DominoStickerSide side1;
    private DominoStickerSide side2;
    private Direction side2Direction;
    private Coordinate side2Position;

    public DominoStickerTile(Shape shape1, Color color1, Shape shape2, Color color2) {
        side1 = new DominoStickerSide(shape1, color1, this);
        side2 = new DominoStickerSide(shape2, color2, this);
        side2Direction = Direction.TOP;
        side2Position = side2Direction.getRelativeCoordinates();
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
    public static void main(String[] args) {
        DominoStickerTile d1 = new DominoStickerTile(Shape.HEART, Color.RED, Shape.CRESCENT, Color.GREEN);
        //d1.rotate90();
        DominoStickerTile d2 = new DominoStickerTile(Shape.HEART, Color.BLUE, Shape.HEART, Color.RED);
        System.out.println(d1);
        System.out.println(d2);
        //System.out.println(d1.fitsWith(d2, Direction.LEFT));
        //System.out.println(d1.getTopSide());
        //System.out.println(d2.getRightSide().equals(d1.getTopSide()));
    }

    public void rotate(Direction d) {
        side2Direction = d;
        side2Position = side2Direction.getRelativeCoordinates();
    }

    public DominoStickerSide getSide1() {
        return side1;
    }

    public DominoStickerSide getSide2() {
        return side2;
    }

    public Direction getSide2Direction() {
        return side2Direction;
    }

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
    public Coordinate getSide2Position() {
        return side2Position;
    }


}
