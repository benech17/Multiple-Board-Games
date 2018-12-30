package games.lineardominoes;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class LinearDominoesBoardTest {
    @Test
    public void checkAddDomino() {
        LinearDominoesBoard board = new LinearDominoesBoard(new LinearDominoTile(1, 6));
        System.out.println(board);

        assertFalse(board.addToLeftEnd(new LinearDominoTile(2, 4)));
        System.out.println(board);
        assertTrue(board.addToLeftEnd(new LinearDominoTile(1, 2)));
        System.out.println(board);
        assertTrue(board.addToLeftEnd(new LinearDominoTile(2, 6))); // Test fails


        System.out.println(board);
    }
}