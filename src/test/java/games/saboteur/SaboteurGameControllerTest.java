package games.saboteur;

import org.junit.Test;

public class SaboteurGameControllerTest {

    @Test
    public void testPlay() {
        SaboteurGameController gameController = new SaboteurGameController(3);
        gameController.play();
    }
}