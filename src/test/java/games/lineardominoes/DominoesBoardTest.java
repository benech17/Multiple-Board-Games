package games.lineardominoes;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class DominoesBoardTest {
    @Test
    public void checkAddDomino() {
        DominoesBoard board = new DominoesBoard(new DominoTile(1, 6));
        System.out.println(board);

        assertFalse(board.addToLeftEnd(new DominoTile(2, 4)));
        System.out.println(board);
        assertTrue(board.addToLeftEnd(new DominoTile(1, 2)));
        System.out.println(board);
        assertTrue(board.addToLeftEnd(new DominoTile(2, 6))); // Test fails


        System.out.println(board);
    }
}