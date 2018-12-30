package games.lineardominoes;

import games.common.model.player.PlayerImpl;


public class LinearDominoesPlayer extends PlayerImpl<LinearDominoTile> {

    public LinearDominoesPlayer(String name, int age) {
        super(name, age);
        hand = new LinearDominoesHand();
    }

    /**
     * Take a turn based on an action and the game state
     *
     * @param game the game manager
     */
    public void takeTurn(LinearDominoesGameState game) {
        LinearDominoTile pickedTile = hand.getCardAt(game.getSelectedHandIndex());
        System.out.println(game.getSelectedHandIndex());
        if (game.isAddToLeftEnd()) {
            if (!game.getBoard().addToLeftEnd(pickedTile))
                throw new DominoesDontFitException("Dominoes don't fit together, please try again");
        } else {
            if (!game.getBoard().addToRightEnd(pickedTile))
                throw new DominoesDontFitException("Dominoes don't fit together, please try again");
        }
        hand.drawCard(game.getSelectedHandIndex());
        if (hand.getHand().isEmpty()) hasWon = true;
    }

    public boolean isBlocked(LinearDominoesGameState game) {
        for (LinearDominoTile t : hand.getHand()) {
            if (game.getBoard().tileCanBePut(t))
                return false;
        }
        return true;
    }
}
