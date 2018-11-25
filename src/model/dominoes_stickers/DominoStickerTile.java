package model.dominoes_stickers;

import model.core.card.tile.Tile;
import model.core.enums.Color;
import model.core.enums.Direction;
import model.core.enums.Shape;

import java.util.EnumMap;
import java.util.function.Supplier;


public class DominoStickerTile extends Tile<DominoStickerSide> {
    private boolean vertical;

    public DominoStickerTile(Shape leftShape, Color leftColor, Shape rightShape, Color rightColor) {
        sides = new EnumMap<>(Direction.class);
        sides.put(Direction.TOP, null);
        sides.put(Direction.BOTTOM, null);
        sides.put(Direction.LEFT, new DominoStickerSide(leftShape, leftColor, this));
        sides.put(Direction.RIGHT, new DominoStickerSide(rightShape, rightColor, this));
        vertical = true;
        setName();
    }

    public boolean isDouble() {
        return getLeftSide().equals(getRightSide());
    }

    private void setName() {
        String s;
        if (isDouble())
            s = "double " + getLeftSide().toString();
        else
            s = getLeftSide().toString() + "-" + getRightSide().toString();
        setName(s);
    }

    public DominoStickerSide getTopSide() {
        return sides.get(Direction.TOP);
    }

    public DominoStickerSide getBottomSide() {
        return (DominoStickerSide) sides.get(Direction.BOTTOM);
    }

    public DominoStickerSide getLeftSide() {
        return (DominoStickerSide) sides.get(Direction.LEFT);
    }

    public DominoStickerSide getRightSide() {
        return (DominoStickerSide) sides.get(Direction.RIGHT);
    }

    public boolean isVertical() {
        return vertical;
    }

    /**
     * Rotates by 90° clockwise the domino tile
     */
    public void rotate90() {
        rotate(1);
        // Change orientation
        vertical = !vertical;
    }

    /**
     * Exchanges both sides
     */
    public void flip() {
        rotate(2);
    }

    // TODO Add doc
    private boolean aux(Supplier<DominoStickerSide> firstSide,
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
    }

    /**
     * Returns true if the current instance of DominoTile and the domino
     * tile t have a side in common. Flips the current instance if necessary
     * according to the direction d.
     * @param t a domino tile adjacent to the current domino tile
     * @param d the position of the domino tile t with respect to the current
     *          domino tile
     * @return true if the current domino tile and the domino tile t share the
     * same side
     */
    public boolean sidesMatch(DominoStickerTile t, Direction d) {
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
    }

    @Override
    public String toString() {
        if (vertical)
            return "[" + getLeftSide().toString() + "|" + getRightSide().toString() + "]";
        else
            return  getTopSide() + "\n" + getBottomSide();
    }

    public static void main(String[] args) {
        DominoStickerTile d1 = new DominoStickerTile(Shape.HEART, Color.RED, Shape.CRESCENT, Color.GREEN);
        d1.rotate90();
        DominoStickerTile d2 = new DominoStickerTile(Shape.HEART, Color.BLUE, Shape.HEART, Color.RED);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1.sidesMatch(d2, Direction.LEFT));
        //System.out.println(d1.getTopSide());
        //System.out.println(d2.getRightSide().equals(d1.getTopSide()));
    }


}