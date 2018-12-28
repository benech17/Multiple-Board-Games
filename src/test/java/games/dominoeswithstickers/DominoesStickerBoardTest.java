package games.dominoeswithstickers;

import games.core.model.board.Coordinate;
import games.core.model.enums.Color;
import games.core.model.enums.Direction;
import games.core.model.enums.Shape;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DominoesStickerBoardTest {
    @Test
    public void testPutTileAt() {
        DominoesStickerBoard b = new DominoesStickerBoard(10, 10,
                new Coordinate(3, 4), new DominoStickerPiece(Shape.HEART, Color.RED, Shape.CRESCENT, Color.GREEN,
                Direction.BOTTOM));
        System.out.println(b);
        assertTrue(
                b.putTileAt(new Coordinate(3, 5),
                        new DominoStickerPiece(Shape.HEART, Color.RED, Shape.STAR, Color.BLUE,
                                Direction.RIGHT)));
        System.out.println(b);
    }
}