package games.saboteur;

import games.core.model.player.PlayerImpl;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.WrongCardException;
import games.saboteur.cards.actioncard.*;
import games.saboteur.cards.pathcard.SaboteurTile;

import java.util.HashMap;


public class SaboteurPlayer extends PlayerImpl<SaboteurBoard, SaboteurCard> {
    private HashMap<ActionCardType, BlockCard> blockCards;

    public SaboteurPlayer(String name, int age) {
        super(name, age);
        // Block cards applied to the player
        // There are at most three of the different types of block cards
        int nbBlockCards = ActionCardType.values().length;
        blockCards = new HashMap<>();
        hand = new SaboteurHand();
    }

    public HashMap<ActionCardType, BlockCard> getBlockCards() {
        return blockCards;
    }

    /**
     * Returns true if the player found the treasure
     *
     * @return
     */
    public boolean takeTurn(SaboteurGameController.Action action, SaboteurGameController game)
            throws BlockedPlayerException, BlockCardAlreadyAppliedException,
            NoMatchingBlockCardAppliedException, WrongCardException {
        SaboteurCard pickedCard = hand.drawCard(game.getSelectedHandIndex());
        switch (action) {
            case PASS:
                game.getTrash().add(pickedCard);
                break;
            case PLAY_PATH_CARD:
                System.out.println(pickedCard);
                if (pickedCard instanceof SaboteurTile) {
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
                // Play an action card
                if (pickedCard instanceof BlockCard) {
                    BlockCard blockCard = (BlockCard) pickedCard;
                    ActionCardType type = blockCard.getType();
                    if (blockCards.containsKey(type))
                        throw new BlockCardAlreadyAppliedException();
                    game.getSelectedPlayer().blockCards.put(type, blockCard);
                }
                if (pickedCard instanceof RepairCard) {
                    RepairCard repairCard = (RepairCard) pickedCard;
                    ActionCardType type = repairCard.getType();
                    if (blockCards.containsKey(type))
                        throw new NoMatchingBlockCardAppliedException();
                    game.getSelectedPlayer().blockCards.remove(type);
                }
                break;
            default:
                throw new WrongCardException(); // Really necessary?
        }
        game.getDeck().deal(hand); // Deal a card from the deck
        return false;
    }


}
