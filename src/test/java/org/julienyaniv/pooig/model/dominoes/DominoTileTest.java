package org.julienyaniv.pooig.model.dominoes;

import org.junit.Test;

import static org.junit.Assert.*;

public class DominoTileTest {
    @Test
    public void testCompareTo() {
        DominoTile t1 = new DominoTile(1, 6);
        DominoTile t2 = new DominoTile(4, 3);
        DominoTile t3 = new DominoTile(5, 7);
        assertEquals(0, t1.compareTo(t2));
        assertTrue(t1.compareTo(t3) < 0); // t1 is lighter than t3
        assertTrue(t3.compareTo(t2) > 0); // t3 is heavier than t2
    }
}