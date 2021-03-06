package games.dominoes.stickersdominoes;

import games.common.model.board.Coordinate;
import games.common.model.enums.Color;
import games.common.model.enums.Direction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DominoesStickerBoardTest {
    @Test
    public void testPutTileAt() {
        DominoesStickerBoard b = new DominoesStickerBoard(10, 10,
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
                                Shape.CRESCENT, Color.RED, Direction.TOP))
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

        assertTrue(
                b.putTileAt(new Coordinate(5, 5),
                        new DominoStickerPiece(Shape.STAR, Color.RED,
                                Shape.DISK, Color.RED, Direction.RIGHT))
        );
        System.out.println(b);
        assertTrue(
                b.putTileAt(new Coordinate(5, 7),
                        new DominoStickerPiece(Shape.DISK, Color.YELLOW,
                                Shape.DISK, Color.RED, Direction.BOTTOM))
        );
        System.out.println(b);
        assertTrue(
                b.putTileAt(new Coordinate(3, 3),
                        new DominoStickerPiece(Shape.HEART, Color.YELLOW,
                                Shape.DISK, Color.RED, Direction.TOP))
        );
        assertTrue(
                b.putTileAt(new Coordinate(4, 6),
                        new DominoStickerPiece(Shape.DISK, Color.YELLOW,
                                Shape.DISK, Color.RED, Direction.TOP))
        );
        System.out.println(b);
        assertFalse(
                b.putTileAt(new Coordinate(6, 6),
                        new DominoStickerPiece(Shape.DISK, Color.YELLOW,
                                Shape.DISK, Color.RED, Direction.BOTTOM))
        );
    }

}