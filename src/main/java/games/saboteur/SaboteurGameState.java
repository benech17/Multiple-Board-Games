package games.saboteur;

import games.common.model.board.Coordinate;
import games.common.model.deck.Deck;
import games.common.model.deck.DeckImpl;
import games.common.model.hand.Hand;
import games.saboteur.cards.SaboteurCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * The model which provides access to the data
 * (may provide mechanisms for registering listeners for notification of
 * changes to the data)
 * <p>
 * Has no knowledge of the presentation of the data
 * It knows nothing at all about the view and the controller
 */
public class SaboteurGameState {
    private SaboteurBoard board;
    private int nbPlayers;
    private List<SaboteurPlayer> players;
    private Deck<SaboteurCard> deck;
    private Stack<SaboteurCard> trash;

    private SaboteurPlayer currentPlayer;
    private int selectedHandIndex;
    private SaboteurPlayer selectedPlayer;
    private Coordinate selectedCoordinate;

    public SaboteurGameState(int nbPlayers) {
        this.nbPlayers = nbPlayers;

        if (nbPlayers <= 1)
            throw new InvalidNumberOfPlayersException();

        this.board = new SaboteurBoard();

        this.players = new ArrayList<>(nbPlayers);
        for (int i = 0; i < nbPlayers; i++)
            players.add(new SaboteurPlayer("Player " + i, 0));

        SaboteurDeckBuilder deckBuilder = new SaboteurDeckBuilderImpl();
        this.deck = new DeckImpl<>(deckBuilder);

        List<Hand<SaboteurCard>> hands = new ArrayList<>(nbPlayers);
        for (int i = 0; i < nbPlayers; i++)
            hands.add(players.get(i).getHand()); // pb
        deck.shuffle();
        deck.distributeCards(hands);

        trash = new Stack<>();
    }

    public SaboteurBoard getBoard() {
        return board;
    }

    public List<SaboteurPlayer> getPlayers() {
        return players;
    }

    public Deck<SaboteurCard> getDeck() {
        return deck;
    }

    public Stack<SaboteurCard> getTrash() {
        return trash;
    }

    public SaboteurPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(SaboteurPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getSelectedHandIndex() {
        return selectedHandIndex;
    }

    public SaboteurPlayer getSelectedPlayer() {
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
