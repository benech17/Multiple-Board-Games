package games.saboteur;

import games.core.model.player.PlayerImpl;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.WrongCardException;
import games.saboteur.cards.actioncard.*;
import games.saboteur.cards.pathcard.SaboteurTile;

import java.util.ArrayList;
import java.util.List;


public class SaboteurPlayer extends PlayerImpl<SaboteurBoard, SaboteurCard> {
    private List<BlockCard> blockCards;

    public SaboteurPlayer(String name, int age) {
        super(name, age);
        // Block cards applied to the player
        // There are at most three of the different types of block cards
        int nbBlockCards = ActionCardType.values().length;
        blockCards = new ArrayList<>(nbBlockCards);
        for (int i = 0; i < nbBlockCards; i++)
            blockCards.add(null);
        hand = new SaboteurHand();
    }

    public List<BlockCard> getBlockCards() {
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
        game.getDeck().deal(hand); // Deal a card from the deck
        return false;
    }


}
