package games.saboteur;

import games.core.model.board.Coordinate;
import games.core.model.card.Card;
import games.core.model.deck.Deck;
import games.core.model.player.PlayerImpl;


public class SaboteurPlayer extends PlayerImpl<SaboteurBoard, Card> {
    BlockCard[] blockCards;

    public SaboteurPlayer(String name, int age) {
        super(name, age);
        // Block cards applied to the player
        // There are at most three of the different types of block cards
        blockCards = new BlockCard[ActionCardType.values().length];
    }

    public void takeTurn(SaboteurBoard b, int handIndex, Coordinate c, Deck deck, Deck trash,
                         SaboteurPlayer p, boolean discardCard) {
        Card pickedCard = hand.drawCard(handIndex);
        if (discardCard) {
            // Put the card to the trash
            trash.addCard(pickedCard);
        }
        if (pickedCard instanceof SaboteurTile) {
            // Put the tile in the board
            b.putTileAt(c, (SaboteurTile) pickedCard);
        } else if (pickedCard instanceof ActionCard) {
            // Play an action card
            if (pickedCard instanceof BlockCard) {
                BlockCard blockCard = (BlockCard) pickedCard;
                int index = blockCard.getIndex();
                if (blockCards[index] != null)
                    throw new BlockCardAlreadyAppliedToPlayerException();
                blockCards[index] = blockCard;
            }
            if (pickedCard instanceof RepairCard) {
                RepairCard repairCard = (RepairCard) pickedCard;
                int index = repairCard.getIndex();
                if (blockCards[index] == null)
                    throw new NoMatchingBlockCardAppliedException();
                blockCards[index] = null;
            }
        } else {
            throw new WrongCardException(); // Really necessary?
        }
        deck.deal(hand); // Deal a card from the deck
    }


}
