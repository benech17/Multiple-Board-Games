package games.saboteur;

import games.core.model.board.Coordinate;
import games.core.model.card.Card;
import games.core.model.deck.Deck;
import games.core.model.player.PlayerImpl;


public class SaboteurPlayer extends PlayerImpl<SaboteurBoard, Card> {

    public SaboteurPlayer(String name, int age) {
        super(name, age);
    }

    public void takeTurn(SaboteurBoard b, int handIndex, Coordinate c, Deck trash,
                         SaboteurPlayer p, boolean discardCard) {
        Card pickedCard = hand.drawCard(handIndex);
        if (discardCard) {
            // Put the card to the trash
            trash.addCard(pickedCard);
        }
        if (pickedCard instanceof SaboteurTile) {
            // Put the tile in the board
            b.putTileAt(c, (SaboteurTile) pickedCard);
        }
        if (pickedCard instanceof ActionCard) {
            // Play an action card

        }
    }
}
