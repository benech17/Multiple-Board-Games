package games.saboteur;

import games.common.model.enums.Direction;
import games.saboteur.cards.pathcard.PathCard;
import games.saboteur.cards.pathcard.SaboteurTile;
import org.junit.Test;

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