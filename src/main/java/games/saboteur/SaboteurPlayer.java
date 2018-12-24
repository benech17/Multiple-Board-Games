package games.saboteur;

import games.core.model.board.Board;
import games.core.model.board.Coordinate;
import games.core.model.card.Card;
import games.core.model.player.PlayerImpl;

public class SaboteurPlayer extends PlayerImpl<Card> {

    public SaboteurPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void takeTurn(Board b, int handIndex, Coordinate c) {
        Card pickedCard = hand.drawCard(handIndex);
        if (pickedCard instanceof SaboteurTile) {
            b.putTileAt(c, (SaboteurTile) pickedCard);
        }
    }
}
