package games.saboteur;

import games.core.model.board.Coordinate;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SaboteurBoardTest {

    @Test
    public void test() {
        SaboteurBoard board = new SaboteurBoard();
        System.out.println(board);
        assertFalse(board.putTileAt(new Coordinate(2, 1), new SaboteurTile(PathCard.ONE)));
        System.out.println(
                new SaboteurTile(PathCard.TWO)
        );
        assertTrue(board.putTileAt(new Coordinate(2, 1), new SaboteurTile(PathCard.TWO)));
        System.out.println(board);

        assertFalse(board.putTileAt(new Coordinate(2, 1), new SaboteurTile(PathCard.TWO)));
        assertFalse(board.putTileAt(new Coordinate(2, 2), new SaboteurTile(PathCard.EIGHT)));
        assertTrue(board.putTileAt(new Coordinate(1, 0), new SaboteurTile(PathCard.SIXTEEN)));
        System.out.println(board);
        System.out.println(board.treasureReached());
        board.removeTileAt(new Coordinate(2, 1));
        System.out.println(board);
        for (int i = 1; i < 8; i++) {
            assertTrue(board.putTileAt(new Coordinate(2, i), new SaboteurTile(PathCard.ELEVEN)));
            System.out.println(board + " " + board.treasureReached());
        }
        System.out.println(board.treasureReached());
        System.out.println(board.getTileAt(new Coordinate(0, 8)).getClass());
        System.out.println(board.getTileAt(new Coordinate(4, 8)).getClass());
        System.out.println(board.getTileAt(new Coordinate(2, 8)).getClass());

    }
}