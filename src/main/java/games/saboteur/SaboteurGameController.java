package games.saboteur;

import games.common.controller.GameController;
import games.common.model.board.Coordinate;
import games.saboteur.cards.BombCard;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.actioncard.BlockCard;
import games.saboteur.cards.actioncard.RepairCard;
import games.saboteur.cards.pathcard.PathCard;
import games.saboteur.cards.pathcard.SaboteurTile;
import games.saboteur.view.SaboteurCLIViewImpl;
import games.saboteur.view.SaboteurView;


/**
 * The controller provides the "view logic": it responds to user input
 * from the view and updates the model as a result.
 * Reciprocally it refreshes the view as a result of a change of the model
 */
public class SaboteurGameController extends GameController {
    private SaboteurGameState gameState; // Game model
    private SaboteurView saboteurView; // Game view

    public SaboteurGameController(SaboteurView saboteurView) throws InvalidNumberOfPlayersException {

        this.saboteurView = saboteurView;
        gameState = new SaboteurGameState(saboteurView.getNbPlayers());
        this.saboteurView.setGameState(gameState);

    }

    public static void main(String[] args) {
        // Testing
        SaboteurGameController gameController = new SaboteurGameController(new SaboteurCLIViewImpl());
        SaboteurBoard b = gameController.getGameState().getBoard();
        for (int i = 1; i < 8; i++) {
            b.putTileAt(new Coordinate(2, i), new SaboteurTile(PathCard.TWELVE));
        }
        gameController.play();
    }

    public SaboteurGameState getGameState() {
        return gameState;
    }

    public SaboteurView getSaboteurView() {
        return saboteurView;
    }

    public boolean takeTurn() {
        saboteurView.printPlayers();
        saboteurView.printCurrentPlayer();
        saboteurView.printHand();
        saboteurView.printBlockCards();
        saboteurView.printBoard();
        int action = saboteurView.chooseAction();
        switch (action) {
            case 0:
                if (!gameState.setSelectedHandIndex(saboteurView.selectCardToPutToTrash())) {
                    saboteurView.printWrongIndex();
                    return false;
                }
                try {
                    gameState.getCurrentPlayer().takeTurn(Action.PASS, gameState);
                } catch (Throwable t) {
                    saboteurView.printError(t);
                    return false;
                }
                saboteurView.printPassTurn();
                saboteurView.printHand();
                break;
            case 1:
                if (!gameState.setSelectedHandIndex(saboteurView.selectCardToPutToTrash())) {
                    saboteurView.printWrongIndex();
                    return false;
                }
                SaboteurCard c = gameState.getCurrentPlayer().getHand().getCardAt(gameState.getSelectedHandIndex());
                if (c instanceof SaboteurTile || c instanceof BombCard) {
                    gameState.setSelectedCoordinate(saboteurView.selectCoordinate());
                    try {
                        gameState.getCurrentPlayer().takeTurn(
                                c instanceof SaboteurTile ? Action.PLAY_PATH_CARD : Action.PLAY_BOMB_CARD,
                                gameState);
                    } catch (Throwable t) {
                        saboteurView.printError(t);
                        return false;
                    }
                }
                if (c instanceof BlockCard || c instanceof RepairCard) {
                    if (!gameState.setSelectedPlayer(saboteurView.selectPlayer())) {
                        saboteurView.printWrongIndex();
                        return false;
                    }
                    try {
                        gameState.getCurrentPlayer().takeTurn(
                                c instanceof BlockCard ? Action.PLAY_BLOCK_CARD : Action.PLAY_REPAIR_CARD,
                                gameState);
                    } catch (Throwable t) {
                        saboteurView.printError(t);
                        return false;
                    }
                }
                break;
            default:
                saboteurView.printWrongAction();
                return false;
        }
        return true;
    }

    public void play() {
        while (true) {
            for (SaboteurPlayer player : gameState.getPlayers()) {
                gameState.setCurrentPlayer(player);
                boolean validPlay = false;
                while (!validPlay) {
                    if (takeTurn())
                        validPlay = true;
                }
                if (gameState.getCurrentPlayer().hasWon()) {
                    saboteurView.printPlayerWon();
                    saboteurView.printPlayers();
                    return; // Ends the game
                }
            }
        }
    }

}
