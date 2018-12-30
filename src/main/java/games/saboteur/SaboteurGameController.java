package games.saboteur;

import games.common.model.board.Coordinate;
import games.common.model.deck.Deck;
import games.common.model.deck.DeckImpl;
import games.common.model.hand.Hand;
import games.common.model.player.Player;
import games.saboteur.cards.BombCard;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.actioncard.ActionCardType;
import games.saboteur.cards.actioncard.BlockCard;
import games.saboteur.cards.actioncard.RepairCard;
import games.saboteur.cards.pathcard.PathCard;
import games.saboteur.cards.pathcard.SaboteurTile;

import java.util.*;


public class SaboteurGameController {
    private SaboteurBoard board;
    private List<SaboteurPlayer> players;
    private Deck<SaboteurCard> deck;
    private Stack<SaboteurCard> trash;

    private SaboteurPlayer currentPlayer;
    private int selectedHandIndex;
    private SaboteurPlayer selectedPlayer;
    private Coordinate selectedCoordinate;

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
    }

    public static void main(String[] args) {
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

    public void printPlayers() {
        System.out.print("Players : ");
        for (Player p : players)
            System.out.println(p);
        System.out.println();
    }

    public void printHand() {
        System.out.println(currentPlayer + " hand (listed by index):");
        SaboteurHand hand = (SaboteurHand) currentPlayer.getHand();
        int i = 0;
        for (SaboteurCard c : hand.getHand()) {
            System.out.println(i + " - " + c.toString());
            i++;
        }
        System.out.println();
    }

    public void printCurrentPlayer() {
        System.out.println("Current player : " + currentPlayer.toString() + "\n");
    }

    public void printBlockCards() {
        System.out.print("Block cards applied to " + currentPlayer + " : ");
        HashMap<ActionCardType, BlockCard> blockCards = currentPlayer.getBlockCards();
        for (BlockCard blockCard : blockCards.values()) {
            System.out.print(blockCard + ", ");
        }
        System.out.println("\n");
    }

    public void printBoard() {
        System.out.println("The board : \n");
        System.out.println(board);
    }

    public boolean takeTurn() {
        printPlayers();
        printCurrentPlayer();
        printHand();
        printBlockCards();
        printBoard();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your action (0 : pass, 1 : play a card) : ");
        int action = sc.nextInt();
        switch (action) {
            case 0:
                System.out.println("Index of the card to put to the trash : ");
                selectedHandIndex = sc.nextInt();
                try {
                    currentPlayer.getHand().getCardAt(selectedHandIndex);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Wrong index, please retry");
                    return false;
                }
                try {
                    currentPlayer.takeTurn(Action.PASS, this);
                } catch (Throwable t) {
                    System.out.println(t.toString());
                    return false;
                }
                System.out.println("Player " + currentPlayer + " has passed their turn");
                printHand();
                break;
            case 1:
                System.out.println("Index of the card to play : ");
                selectedHandIndex = sc.nextInt();
                SaboteurCard c;
                try {
                    c = currentPlayer.getHand().getCardAt(selectedHandIndex);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Wrong index, please retry");
                    return false;
                }
                if (c instanceof SaboteurTile || c instanceof BombCard) {
                    System.out.println("Coordinates of the destination in the board : ");
                    System.out.println("Row : ");
                    int row = sc.nextInt();
                    System.out.println("Column : ");
                    int column = sc.nextInt();
                    selectedCoordinate = new Coordinate(row, column);
                    try {
                        currentPlayer.takeTurn(
                                c instanceof SaboteurTile ? Action.PLAY_PATH_CARD : Action.PLAY_BOMB_CARD,
                                this);
                    } catch (Throwable t) {
                        System.out.println(t.toString());
                        return false;
                    }
                }
                if (c instanceof BlockCard || c instanceof RepairCard) {
                    System.out.println(currentPlayer.getHand().getCardAt(selectedHandIndex));
                    System.out.println("Index of the player to put the card in front of : ");
                    int selectedPlayerIndex = sc.nextInt();
                    try {
                        selectedPlayer = players.get(selectedPlayerIndex);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Wrong index, please retry");
                        return false;
                    }
                    try {
                        currentPlayer.takeTurn(
                                c instanceof BlockCard ? Action.PLAY_BLOCK_CARD : Action.PLAY_REPAIR_CARD,
                                this);
                    } catch (Throwable t) {
                        System.out.println(t.toString());
                        return false;
                    }
                }
                break;
            default:
                System.out.println("Please enter a valid integer (either 0 or 1)");
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
                    System.out.println(currentPlayer + " has won");
                    printPlayers();
                    return; // Ends the game
                }
            }
        }
    }

}
