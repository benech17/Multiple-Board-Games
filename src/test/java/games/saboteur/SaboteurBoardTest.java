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

    }
}