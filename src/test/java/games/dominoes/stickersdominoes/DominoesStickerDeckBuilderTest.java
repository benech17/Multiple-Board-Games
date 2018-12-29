package games.dominoes.stickersdominoes;

import org.junit.Test;

public class DominoesStickerDeckBuilderTest {
    @Test
    public void testBuild() {
        DominoesStickerDeckBuilder b = new DominoesStickerDeckBuilder();
        b.build();
        System.out.println(b.getDeck());
    }
}