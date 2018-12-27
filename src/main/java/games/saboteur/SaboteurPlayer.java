package games.saboteur;

import games.core.model.player.PlayerImpl;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.WrongCardException;
import games.saboteur.cards.actioncard.*;
import games.saboteur.cards.pathcard.SaboteurTile;

import java.util.HashMap;


public class SaboteurPlayer extends PlayerImpl<SaboteurBoard, SaboteurCard> {
    private HashMap<ActionCardType, BlockCard> blockCards;
    private boolean hasWon = false;

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

    public boolean hasWon() {
        return hasWon;
    }

    /**
     * Take a turn based on an action and the game state
     * @param action the action to do in the turn
     * @param game the game manager
     * @throws BlockedPlayerException if a blocked player attempts to play a path card
     * @throws BlockCardAlreadyAppliedException if a player plays an already applied action card
     * @throws NoMatchingBlockCardAppliedException if a player plays a repair card that don't match a block card
     * @throws WrongCardException if the picked card don't correspond to the specified action
     * @throws UnsupportedActionException if the action provided is not handled
     */
    public void takeTurn(Action action, SaboteurGameController game)
            throws BlockedPlayerException,
            BlockCardAlreadyAppliedException,
            NoMatchingBlockCardAppliedException,
            WrongCardException,
            UnsupportedActionException {
        SaboteurCard pickedCard = hand.getCardAt(game.getSelectedHandIndex());
        switch (action) {
            case PASS:
                game.getTrash().add(pickedCard);
                hand.drawCard(game.getSelectedHandIndex());
                break;
            case PLAY_PATH_CARD:
                if (pickedCard instanceof SaboteurTile) {
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
                } else
                    throw new WrongCardException("Got " + pickedCard + " but expected a path card");
                break;
            case PLAY_ACTION_CARD:
                // Play an action card
                if (pickedCard instanceof BlockCard) {
                    ActionCardType type = ((BlockCard) pickedCard).getType();
                    if (blockCards.containsKey(type))
                        throw new BlockCardAlreadyAppliedException();
                    game.getSelectedPlayer().blockCards.put(type, (BlockCard) hand.drawCard(game.getSelectedHandIndex()));
                } else if (pickedCard instanceof RepairCard) {
                    ActionCardType type = ((RepairCard) pickedCard).getType();
                    if (!blockCards.containsKey(type))
                        throw new NoMatchingBlockCardAppliedException();
                    hand.drawCard(game.getSelectedHandIndex());
                    game.getSelectedPlayer().blockCards.remove(type);
                } else
                    throw new WrongCardException("Got " + pickedCard + " but expected an action card");
                break;
            default:
                throw new UnsupportedActionException("Action " + action.toString() + " is not supported");
        }
        game.getDeck().deal(hand); // Deal a card from the deck
    }
}
