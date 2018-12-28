package games.dominoes;

import games.common.model.board.Coordinate;
import games.common.model.enums.Color;
import games.common.model.enums.Direction;
import games.common.model.enums.Shape;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DominoesBoardTest {
    @Test
    public void testPutTileAt() {
        DominoesBoard b = new DominoesBoard(10, 10,
                new Coordinate(3, 4), new DominoStickerPiece(Shape.HEART, Color.RED, Shape.CRESCENT, Color.GREEN,
                Direction.BOTTOM));
        System.out.println(b);
        assertFalse(
                b.putTileAt(new Coordinate(2, 5),
                        new DominoStickerPiece(Shape.HEART, Color.RED,
                                Shape.STAR, Color.BLUE, Direction.RIGHT)));
        assertFalse(
                b.putTileAt(new Coordinate(5, 4),
                        new DominoStickerPiece(Shape.DISK, Color.YELLOW,
                                Shape.HEART, Color.BLUE, Direction.LEFT))
        );
        assertTrue(
                b.putTileAt(new Coordinate(6, 4),
                        new DominoStickerPiece(Shape.DISK, Color.GREEN,
                                Shape.CRESCENT, Color.GREEN, Direction.TOP))
        );
        System.out.println(b);
        assertFalse(
                b.putTileAt(new Coordinate(1, 0),
                        new DominoStickerPiece(Shape.STAR, Color.YELLOW,
                                Shape.DISK, Color.RED, Direction.TOP))
        );
        assertFalse(
                b.putTileAt(new Coordinate(-1, 3),
                        new DominoStickerPiece(Shape.STAR, Color.YELLOW,
                                Shape.DISK, Color.RED, Direction.BOTTOM))
        );
    }
}