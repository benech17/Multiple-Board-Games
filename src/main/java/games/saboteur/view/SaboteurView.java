package games.saboteur.view;

import games.common.model.board.Coordinate;
import games.saboteur.SaboteurGameState;

public interface SaboteurView {
    void setGameState(SaboteurGameState gameState);

    void printPassTurn();

    void printError(Throwable t);

    void printWrongAction();

    int selectCardToPutToTrash();

    void printPlayerWon();

    int selectPlayer();

    Coordinate selectCoordinate();

    int selectCardToPlay();

    void printWrongIndex();

    int chooseAction();

    void printPlayers();

    void printHand();

    void printCurrentPlayer();

    void printBlockCards();

    void printBoard();

    int getNbPlayers();
}
