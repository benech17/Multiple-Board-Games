package model.dominoes_stickers;

import model.core.card.tile.Tile;
import model.core.enums.Color;
import model.core.enums.Direction;
import model.core.enums.Shape;
import model.dominoes.DominoSide;

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

    public DominoStickerSide getLeftSide() {
        return (DominoStickerSide) sides.get(Direction.LEFT);
    }

    public DominoStickerSide getRightSide() {
        return (DominoStickerSide) sides.get(Direction.RIGHT);
    }

    /**
     * Exchanges both sides
     */
    public void flip() {
        rotate(1);
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
            case LEFT:
                if (getLeftSide().equals(t.getRightSide()))
                    return true;
                if (getRightSide().equals(t.getRightSide())) {
                    flip();
                    return true;
                }
                break;
            case RIGHT:
                if (getRightSide().equals(t.getLeftSide()))
                    return true;
                if (getLeftSide().equals(t.getLeftSide())) {
                    flip();
                    return true;
                }
        }
        return false;
    }

    /*public void removeAvailableSide(Side s) {
        getAvailableSides().remove(s);
    }*/

    @Override
    public String toString() {
        return "[" + getLeftSide().toString() + "|" + getRightSide().toString() + "]";
    }

    public static void main(String[] args) {
        DominoStickerTile d1 = new DominoStickerTile(Shape.HEART, Color.RED, Shape.CRESCENT, Color.GREEN);
        System.out.println(d1);
    }


}
