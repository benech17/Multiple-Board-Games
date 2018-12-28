package games.dominoes;

import games.common.model.card.tile.Side;
import games.common.model.enums.Color;
import games.common.model.enums.Shape;

import java.util.Objects;


public class DominoStickerSide extends Side {
    private final Shape shape;
    private final Color color;

    public DominoStickerSide(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color.name().charAt(0) + "" + shape.name().charAt(0);
    }

    /**
     * Two domino sticker sides are equal if they share
     * the same shape and color
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DominoStickerSide that = (DominoStickerSide) o;
        return shape == that.shape && color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape, color);
    }
}
