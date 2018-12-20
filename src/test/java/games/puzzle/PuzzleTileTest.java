package games.puzzle;

import games.core.model.enums.Direction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PuzzleTileTest {

    @Test
    public void testFitsWith() {
        PuzzleTile t = new PuzzleTile(0, 1, 2, 3);
        PuzzleTile t2 = new PuzzleTile(3,4,5,6);
        assertTrue(t2.fitsWith(t, Direction.TOP));
        assertFalse(t.fitsWith(t2, Direction.LEFT));
    }

}