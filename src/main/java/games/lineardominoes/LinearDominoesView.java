package games.lineardominoes;

public interface LinearDominoesView {
    void setGameState(LinearDominoesGameState gameState);

    void printError(Throwable t);

    void printError(String message);

    boolean selectedLeftEnd();

    void printPlayerWon();

    int selectPlayer();

    int selectCardToPlay();

    void printWrongIndex();

    int chooseAction();

    void printPlayers();

    void printHand();

    void printCurrentPlayer();

    void printBoard();

    int getNbPlayers();


}
