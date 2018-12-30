package games.lineardominoes;

import games.common.controller.GameController;
import games.saboteur.InvalidNumberOfPlayersException;

import java.util.InputMismatchException;


/**
 * The controller provides the "view logic": it responds to user input
 * from the view and updates the model as a result.
 * Reciprocally it refreshes the view as a result of a change of the model
 */
public class LinearDominoesGameController extends GameController {
    private LinearDominoesGameState gameState; // Game model
    private LinearDominoesView linearDominoesView; // Game view

    public LinearDominoesGameController(LinearDominoesView linearDominoesView) throws InvalidNumberOfPlayersException {

        this.linearDominoesView = linearDominoesView;
        gameState = new LinearDominoesGameState(linearDominoesView.getNbPlayers());
        this.linearDominoesView.setGameState(gameState);

    }

    public static void main(String[] args) {
        // Testing
        LinearDominoesGameController gameController = new LinearDominoesGameController(new LinearCLIViewImpl());
        gameController.play();
    }

    public LinearDominoesGameState getGameState() {
        return gameState;
    }

    public LinearDominoesView getLinearDominoesView() {
        return linearDominoesView;
    }

    public boolean takeTurn() {
        linearDominoesView.printPlayers();
        linearDominoesView.printCurrentPlayer();
        linearDominoesView.printHand();
        linearDominoesView.printBoard();
        if (gameState.getCurrentPlayer().isBlocked(gameState))
            System.out.println("Player is blocked");
        if (!gameState.setSelectedHandIndex(linearDominoesView.selectCardToPlay())) {
            linearDominoesView.printWrongIndex();
            return false;
        }
        try {
            gameState.setAddToLeftEnd(linearDominoesView.selectedLeftEnd());
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        try {
            gameState.getCurrentPlayer().takeTurn(gameState);
        } catch (DominoesDontFitException e) {
            linearDominoesView.printError(e);
            return false;
        }
        return true;
    }

    public void play() {
        while (true) {
            for (LinearDominoesPlayer player : gameState.getPlayers()) {
                gameState.setCurrentPlayer(player);
                boolean validPlay = false;
                while (!validPlay) {
                    if (takeTurn())
                        validPlay = true;
                }
                if (gameState.getCurrentPlayer().hasWon()) {
                    linearDominoesView.printPlayerWon();
                    linearDominoesView.printPlayers();
                    return; // Ends the game
                }
            }
        }
    }

}
