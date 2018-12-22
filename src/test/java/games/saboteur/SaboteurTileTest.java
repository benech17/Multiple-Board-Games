package games.saboteur;

import games.core.model.enums.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaboteurTileTest {

    @Test
    public void fitsWith() {
        SaboteurTile ten = new SaboteurTile(PathCard.TEN);
        SaboteurTile one = new SaboteurTile(PathCard.ONE);
        SaboteurTile two = new SaboteurTile(PathCard.TWO);
        System.out.println(one.fitsWith(ten, Direction.LEFT));
        System.out.println(two.fitsWith(ten, Direction.LEFT));
    }
}