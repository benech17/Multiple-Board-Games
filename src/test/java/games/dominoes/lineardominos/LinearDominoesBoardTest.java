package games.dominoes.lineardominos;

import games.common.model.board.Coordinate;
import games.common.model.enums.Direction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinearDominoesBoardTest {
    @Test
    public void testPutTileAt() {
        LinearDominoesBoard b = new LinearDominoesBoard(10, 10,
                new Coordinate(3, 4), new LinearDominoPiece(5, 4, Direction.BOTTOM));
        System.out.println(b);
        assertFalse(
                b.putTileAt(new Coordinate(2, 5),
                        new LinearDominoPiece(4, 6, Direction.RIGHT)));
        System.out.println("head : " + b.getHead() + ", tail : " + b.getTail());
        assertTrue(
                b.putTileAt(new Coordinate(5, 4),
                        new LinearDominoPiece(4, 6, Direction.RIGHT)));
        System.out.println(b);
        System.out.println("head : " + b.getHead() + ", tail : " + b.getTail());
        assertFalse(
                b.putTileAt(new Coordinate(5, 3),
                        new LinearDominoPiece(4, 2, Direction.LEFT))
        );
        System.out.println(b);
        assertTrue(
                b.putTileAt(new Coordinate(4, 6),
                        new LinearDominoPiece(4, 6, Direction.BOTTOM))
        );
        System.out.println(b);
        System.out.println("head : " + b.getHead() + ", tail : " + b.getTail());
        assertFalse(
                b.putTileAt(new Coordinate(6, 5),
                        new LinearDominoPiece(6, 6, Direction.RIGHT))
        );
    }

    @Test
    public void test2() {

    }
}