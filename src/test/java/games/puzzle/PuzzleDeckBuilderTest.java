package games.puzzle;

import org.junit.Test;

import java.util.Stack;

public class PuzzleDeckBuilderTest {
    @Test
    public void testBuild() {
        PuzzleDeckBuilder b = new PuzzleDeckBuilder(2, 2);
        Stack<PuzzleTile> deck = b.build();
        for (PuzzleTile t : deck) {
            System.out.println(t);
        }
    }
}