package games.saboteur;

import games.common.model.player.PlayerImpl;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.WrongCardException;
import games.saboteur.cards.actioncard.ActionCardException;
import games.saboteur.cards.actioncard.ActionCardType;
import games.saboteur.cards.actioncard.BlockCard;
import games.saboteur.cards.actioncard.RepairCard;
import games.saboteur.cards.pathcard.CantRemoveGoalOrStartCardException;
import games.saboteur.cards.pathcard.GoalCard;
import games.saboteur.cards.pathcard.SaboteurTile;
import games.saboteur.cards.pathcard.StartCard;

import java.util.HashMap;


public class SaboteurPlayer extends PlayerImpl<SaboteurCard> {
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
     * Take a turn based on an action and the game state
     *
     * @param action the action to do in the turn
     * @param game   the game manager
     * @throws BlockedPlayerException                                  if a blocked player attempts to play a path card
     * @throws ActionCardException.BlockCardAlreadyAppliedException    if a player plays an already applied action card
     * @throws ActionCardException.NoMatchingBlockCardAppliedException if a player plays a repair card that don't match a block card
     * @throws WrongCardException                                      if the picked card don't correspond to the specified action
     * @throws ActionCardException.UnsupportedActionException          if the action provided is not handled
     */
    public void takeTurn(Action action, SaboteurGameController game)
            throws BlockedPlayerException,
            ActionCardException.BlockCardAlreadyAppliedException,
            ActionCardException.NoMatchingBlockCardAppliedException,
            ActionCardException.UnsupportedActionException {
        SaboteurCard pickedCard = hand.getCardAt(game.getSelectedHandIndex());
        switch (action) {
            case PASS:
                game.getTrash().add(pickedCard);
                hand.drawCard(game.getSelectedHandIndex());
                break;
            case PLAY_PATH_CARD:
                if (!blockCards.isEmpty())
                    throw new BlockedPlayerException("You can't play a path card until you have no blocked card in front of you");
                // Put the tile in the board
                game.getBoard().putTileAt(game.getSelectedCoordinate(), (SaboteurTile) pickedCard);
                hand.drawCard(game.getSelectedHandIndex());
                if (game.getBoard().treasureReached()) {
                    // Collect treasure, update score
                    increaseScore(game.getBoard().getTreasureCard().getAmountPoints());
                    hasWon = true; // The player won
                }
                break;
            case PLAY_BLOCK_CARD:
                // Play an action card
                ActionCardType type = ((BlockCard) pickedCard).getType();
                if (blockCards.containsKey(type))
                    throw new ActionCardException.BlockCardAlreadyAppliedException();
                game.getSelectedPlayer().blockCards.put(type, (BlockCard) hand.drawCard(game.getSelectedHandIndex()));
                break;
            case PLAY_REPAIR_CARD:
                type = ((RepairCard) pickedCard).getType();
                if (!blockCards.containsKey(type))
                    throw new ActionCardException.NoMatchingBlockCardAppliedException();
                hand.drawCard(game.getSelectedHandIndex());
                game.getSelectedPlayer().blockCards.remove(type);
                break;
            case PLAY_BOMB_CARD:
                if (!blockCards.isEmpty())
                    throw new BlockedPlayerException("You can't play a path card until you have no blocked card in front of you");
                // Remove tile from the board
                if (game.getBoard().getTileAt(game.getSelectedCoordinate()) instanceof GoalCard
                        || game.getBoard().getTileAt(game.getSelectedCoordinate()) instanceof StartCard)
                    throw new CantRemoveGoalOrStartCardException();
                game.getBoard().removeTileAt(game.getSelectedCoordinate());
                hand.drawCard(game.getSelectedHandIndex());
                break;
            default:
                throw new ActionCardException.UnsupportedActionException("Action " + action.toString() + " is not supported");
        }
        game.getDeck().deal(hand); // Deal a card from the deck
    }
}
