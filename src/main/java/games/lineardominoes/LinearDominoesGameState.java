package games.lineardominoes;

import games.common.model.board.Coordinate;
import games.common.model.deck.Deck;
import games.common.model.deck.DeckBuilder;
import games.common.model.deck.DeckImpl;
import games.common.model.hand.Hand;
import games.saboteur.InvalidNumberOfPlayersException;

import java.util.ArrayList;
import java.util.List;


/**
 * The model which provides access to the data
 * (may provide mechanisms for registering listeners for notification of
 * changes to the data)
 * <p>
 * Has no knowledge of the presentation of the data
 * It knows nothing at all about the view and the controller
 */
public class LinearDominoesGameState {
    private LinearDominoesBoard board;
    private int nbPlayers;
    private List<LinearDominoesPlayer> players;
    private Deck<LinearDominoTile> deck;

    private LinearDominoesPlayer currentPlayer;
    private int selectedHandIndex;
    private LinearDominoesPlayer selectedPlayer;
    private boolean addToLeftEnd;
    private Coordinate selectedCoordinate;

    public LinearDominoesGameState(int nbPlayers) {
        this.nbPlayers = nbPlayers;

        if (nbPlayers <= 1)
            throw new InvalidNumberOfPlayersException();

        this.board = new LinearDominoesBoard();

        this.players = new ArrayList<>(nbPlayers);
        for (int i = 0; i < nbPlayers; i++)
            players.add(new LinearDominoesPlayer("Player " + i, 0));

        DeckBuilder<LinearDominoTile> deckBuilder = new LinearDominoesDeckBuilder();
        this.deck = new DeckImpl<>(deckBuilder);

        List<Hand<LinearDominoTile>> hands = new ArrayList<>(nbPlayers);
        for (int i = 0; i < nbPlayers; i++)
            hands.add(players.get(i).getHand()); // pb
        deck.shuffle();
        deck.distributeCards(hands);

    }

    public boolean isAddToLeftEnd() {
        return addToLeftEnd;
    }

    public void setAddToLeftEnd(boolean addToLeftEnd) {
        this.addToLeftEnd = addToLeftEnd;
    }

    public LinearDominoesBoard getBoard() {
        return board;
    }

    public List<LinearDominoesPlayer> getPlayers() {
        return players;
    }

    public Deck<LinearDominoTile> getDeck() {
        return deck;
    }


    public LinearDominoesPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(LinearDominoesPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getSelectedHandIndex() {
        return selectedHandIndex;
    }

    public LinearDominoesPlayer getSelectedPlayer() {
        return selectedPlayer;
    }

    public boolean setSelectedHandIndex(int selectedHandIndex) {
        try {
            currentPlayer.getHand().getCardAt(selectedHandIndex);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        this.selectedHandIndex = selectedHandIndex;
        return true;
    }

    public boolean setSelectedPlayer(int selectedPlayerIndex) {
        try {
            players.get(selectedPlayerIndex);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        this.selectedPlayer = players.get(selectedPlayerIndex);
        return true;
    }

    public Coordinate getSelectedCoordinate() {
        return selectedCoordinate;
    }

    public void setSelectedCoordinate(Coordinate selectedCoordinate) {
        this.selectedCoordinate = selectedCoordinate;
    }
}
