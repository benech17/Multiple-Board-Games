package model.dominoes_stickers;

import model.core.card.tile.Tile;
import model.core.enums.Direction;
import model.dominoes.DominoSide;

import java.util.HashMap;


public class DominoStickerTile extends Tile {
    public DominoStickerTile(int leftValue, int rightValue) {
        sides = new HashMap<>();
        //sides.put(Direction.LEFT, new DominoSide(leftValue, this));
        //sides.put(Direction.RIGHT, new DominoSide(rightValue, this));
        setName();
    }

    public boolean isDouble() {
        return getLeftSide().getValue() == getRightSide().getValue();
    }

    private void setName() {
        String s;
        if (isDouble())
            s = "double " + getLeftSide().getValue();
        else
            s = getLeftSide().getValue() + "-" + getRightSide().getValue();
        setName(s);
    }

    public DominoSide getLeftSide() {
        return (DominoSide) sides.get(Direction.LEFT);
    }

    public DominoSide getRightSide() {
        return (DominoSide) sides.get(Direction.RIGHT);
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
        return "[" + getSides().get(Direction.LEFT) + "|" + getSides().get(Direction.RIGHT) + "]";
    }

    public static void main(String[] args) {
        DominoStickerTile d1 = new DominoStickerTile(1, 6);
        DominoStickerTile d2 = new DominoStickerTile(6, 4);
        //System.out.println(d1.getMatchingSide(d2)); // Sides match
        DominoStickerTile d3 = new DominoStickerTile(3, 3);
        System.out.println(d1);
        //System.out.println(d2.getMatchingSide(d3)); // Sides don't match
    }


}
