package model.dominoes_stickers;

import model.core.card.tile.Tile;
import model.core.enums.Color;
import model.core.enums.Direction;
import model.core.enums.Shape;

import java.util.HashMap;


public class DominoStickerTile extends Tile {
    public DominoStickerTile(Shape leftShape, Color leftColor, Shape rightShape, Color rightColor) {
        sides = new HashMap<>();
        sides.put(Direction.TOP, null);
        sides.put(Direction.BOTTOM, null);
        sides.put(Direction.LEFT, new DominoStickerSide(leftShape, leftColor, this));
        sides.put(Direction.RIGHT, new DominoStickerSide(rightShape, rightColor, this));
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
        return (DominoStickerSide) sides.get(Direction.TOP);
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

    public void rotate90() {
        rotate(1);
    }

    /**
     * Exchanges both sides
     */
    public void flip() {
        rotate(2);
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
                if (getTopSide() == null)
                    rotate90();
                if (getTopSide().equals(t.getBottomSide()))
                    return true;
                if (getBottomSide().equals(t.getBottomSide())) {
                    flip();
                    return true;
                }
            case BOTTOM:
                if (getBottomSide() == null)
                    rotate90();
                if (getBottomSide().equals(t.getTopSide()))
                    return true;
                if (getTopSide().equals(t.getBottomSide())) {
                    flip();
                    return true;
                }
            case LEFT:
                if (getLeftSide() == null)
                    rotate90();
                if (getLeftSide().equals(t.getRightSide()))
                    return true;
                if (getRightSide().equals(t.getRightSide())) {
                    flip();
                    return true;
                }
                break;
            case RIGHT:
                if (getRightSide() == null)
                    rotate90();
                if (getRightSide().equals(t.getLeftSide()))
                    return true;
                if (getLeftSide().equals(t.getLeftSide())) {
                    flip();
                    return true;
                }
                break;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + getLeftSide().toString() + "|" + getRightSide().toString() + "]";
    }

    public static void main(String[] args) {
        DominoStickerTile d1 = new DominoStickerTile(Shape.HEART, Color.RED, Shape.CRESCENT, Color.GREEN);
        System.out.println(d1);
    }


}
