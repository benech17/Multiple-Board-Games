package games.puzzle;

import games.common.model.hand.HandImpl;
import games.common.model.player.PlayerImpl;

public class PuzzlePlayer extends PlayerImpl<PuzzleTile> {
    public PuzzlePlayer(String name, int age, int dimPuzzle) {
        super(name, age);
        hand = new HandImpl<>() {
            @Override
            public int getCardNumberAtStart() {
                return dimPuzzle;
            }
        };
    }

    public void takeTurn(PuzzleGameController game) {
        if (game.getBoard().putTileAt(game.getSelectedCoordinate(),
                hand.getCardAt(game.getSelectedHandIndex()))) {
            hand.drawCard(game.getSelectedHandIndex());
            if (hand.isEmpty())
                hasWon = true; // The player completed the puzzle
        }
    }
}
