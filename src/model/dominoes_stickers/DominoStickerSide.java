package model.dominoes_stickers;

import model.core.card.tile.Side;
import model.core.enums.Color;
import model.core.enums.Shape;
import model.dominoes.DominoTile;

import java.util.Objects;

public class DominoStickerSide extends Side {
    private final Shape shape;
    private final Color color;

    public DominoStickerSide(Shape shape, Color color, DominoStickerTile parent) {
        super(parent, null);
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
        return "DominoStickerSide{" +
                "shape=" + shape +
                ", color=" + color +
                '}';
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
