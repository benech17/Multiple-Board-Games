package games.saboteur;

import games.core.model.player.PlayerImpl;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.WrongCardException;
import games.saboteur.cards.actioncard.*;
import games.saboteur.cards.pathcard.SaboteurTile;

import java.util.ArrayList;
import java.util.List;


public class SaboteurPlayer extends PlayerImpl<SaboteurBoard, SaboteurCard> {
    List<BlockCard> blockCards;

    public SaboteurPlayer(String name, int age) {
        super(name, age);
        // Block cards applied to the player
        // There are at most three of the different types of block cards
        blockCards = new ArrayList<>(ActionCardType.values().length);
        hand = new SaboteurHand();
    }

    /**
     * Returns true if the player found the treasure
     *
     * @return
     */
    public boolean takeTurn(SaboteurGameController.Action action, SaboteurGameController game)
            throws BlockedPlayerException, BlockCardAlreadyAppliedException,
            NoMatchingBlockCardAppliedException, WrongCardException {
        System.out.println("hello");
        SaboteurCard pickedCard = hand.drawCard(game.getSelectedHandIndex());
        switch (action) {
            case PASS:
                System.out.println("pass");
                game.getTrash().add(pickedCard);
                break;
            case PLAY_PATH_CARD:
                System.out.println(pickedCard);
                System.out.println("play path card");
                if (pickedCard instanceof SaboteurTile) {
                    System.out.println("hey !!!!!");
                    if (!blockCards.isEmpty())
                        throw new BlockedPlayerException();
                    // Put the tile in the board
                    game.getBoard().putTileAt(game.getSelectedCoordinate(), (SaboteurTile) pickedCard);
                    if (game.getBoard().treasureReached()) {
                        return true; // The player won
                    }
                }
                break;
            case PLAY_ACTION_CARD:
                System.out.println("play action card");
                // Play an action card
                if (pickedCard instanceof BlockCard) {
                    BlockCard blockCard = (BlockCard) pickedCard;
                    int index = blockCard.getIndex();
                    if (blockCards.get(index) != null)
                        throw new BlockCardAlreadyAppliedException();
                    game.getSelectedPlayer().blockCards.add(index, blockCard);
                }
                if (pickedCard instanceof RepairCard) {
                    RepairCard repairCard = (RepairCard) pickedCard;
                    int index = repairCard.getIndex();
                    if (blockCards.get(index) == null)
                        throw new NoMatchingBlockCardAppliedException();
                    game.getSelectedPlayer().blockCards.set(index, null);
                }
                break;
            default:
                throw new WrongCardException(); // Really necessary?
        }
        System.out.println("passé switch");
        game.getDeck().deal(hand); // Deal a card from the deck
        return false;
    }


}
