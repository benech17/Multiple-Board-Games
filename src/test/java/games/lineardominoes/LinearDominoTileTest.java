package games.lineardominoes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinearDominoTileTest {
    @Test
    public void testCompareTo() {
        LinearDominoTile t1 = new LinearDominoTile(1, 6);
        LinearDominoTile t2 = new LinearDominoTile(4, 3);
        LinearDominoTile t3 = new LinearDominoTile(5, 7);
        assertEquals(0, t1.compareTo(t2));
        assertTrue(t1.compareTo(t3) < 0); // t1 is lighter than t3
        assertTrue(t3.compareTo(t2) > 0); // t3 is heavier than t2
    }
}