package games.saboteur;

import games.common.model.board.Coordinate;
import games.common.model.deck.Deck;
import games.common.model.deck.DeckImpl;
import games.common.model.hand.Hand;
import games.saboteur.cards.BombCard;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.actioncard.BlockCard;
import games.saboteur.cards.actioncard.RepairCard;
import games.saboteur.cards.pathcard.PathCard;
import games.saboteur.cards.pathcard.SaboteurTile;
import games.saboteur.view.SaboteurCLIView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class SaboteurGameController {
    private SaboteurBoard board;
    private List<SaboteurPlayer> players;
    private Deck<SaboteurCard> deck;
    private Stack<SaboteurCard> trash;

    private SaboteurPlayer currentPlayer;
    private int selectedHandIndex;
    private SaboteurPlayer selectedPlayer;
    private Coordinate selectedCoordinate;

    private SaboteurCLIView saboteurCLIView;

    public SaboteurGameController(int nbPlayers) throws InvalidNumberOfPlayersException {
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

        saboteurCLIView = new SaboteurCLIView(this);
    }

    public static void main(String[] args) {
        // Testing
        SaboteurGameController gameController = new SaboteurGameController(3);
        SaboteurBoard b = gameController.getBoard();
        for (int i = 1; i < 8; i++) {
            b.putTileAt(new Coordinate(2, i), new SaboteurTile(PathCard.TWELVE));
        }
        gameController.play();
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

    public int getSelectedHandIndex() {
        return selectedHandIndex;
    }

    public SaboteurPlayer getSelectedPlayer() {
        return selectedPlayer;
    }

    public Coordinate getSelectedCoordinate() {
        return selectedCoordinate;
    }


    public boolean takeTurn() {
        saboteurCLIView.printPlayers();
        saboteurCLIView.printCurrentPlayer();
        saboteurCLIView.printHand();
        saboteurCLIView.printBlockCards();
        saboteurCLIView.printBoard();
        int action = saboteurCLIView.chooseAction();
        switch (action) {
            case 0:
                selectedHandIndex = saboteurCLIView.selectCardToPutToTrash();
                try {
                    currentPlayer.getHand().getCardAt(selectedHandIndex);
                } catch (IndexOutOfBoundsException e) {
                    saboteurCLIView.printWrongIndex();
                    return false;
                }
                try {
                    currentPlayer.takeTurn(Action.PASS, this);
                } catch (Throwable t) {
                    saboteurCLIView.printError(t);
                    return false;
                }
                saboteurCLIView.printPassTurn();
                saboteurCLIView.printHand();
                break;
            case 1:
                selectedHandIndex = saboteurCLIView.selectCardToPlay();
                SaboteurCard c;
                try {
                    c = currentPlayer.getHand().getCardAt(selectedHandIndex);
                } catch (IndexOutOfBoundsException e) {
                    saboteurCLIView.printWrongIndex();
                    return false;
                }
                if (c instanceof SaboteurTile || c instanceof BombCard) {
                    selectedCoordinate = saboteurCLIView.selectCoordinate();
                    try {
                        currentPlayer.takeTurn(
                                c instanceof SaboteurTile ? Action.PLAY_PATH_CARD : Action.PLAY_BOMB_CARD,
                                this);
                    } catch (Throwable t) {
                        saboteurCLIView.printError(t);
                        return false;
                    }
                }
                if (c instanceof BlockCard || c instanceof RepairCard) {
                    int selectedPlayerIndex = saboteurCLIView.selectPlayer();
                    try {
                        selectedPlayer = players.get(selectedPlayerIndex);
                    } catch (IndexOutOfBoundsException e) {
                        saboteurCLIView.printWrongIndex();
                        return false;
                    }
                    try {
                        currentPlayer.takeTurn(
                                c instanceof BlockCard ? Action.PLAY_BLOCK_CARD : Action.PLAY_REPAIR_CARD,
                                this);
                    } catch (Throwable t) {
                        saboteurCLIView.printError(t);
                        return false;
                    }
                }
                break;
            default:
                saboteurCLIView.printWrongAction();
                return false;
        }
        return true;
    }

    public void play() {
        while (true) {
            for (SaboteurPlayer player : players) {
                currentPlayer = player;
                boolean validPlay = false;
                while (!validPlay) {
                    if (takeTurn())
                        validPlay = true;
                }
                if (currentPlayer.hasWon()) {
                    saboteurCLIView.printPlayerWon();
                    saboteurCLIView.printPlayers();
                    return; // Ends the game
                }
            }
        }
    }

}
