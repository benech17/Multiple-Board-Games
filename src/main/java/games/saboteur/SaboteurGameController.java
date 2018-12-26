package games.saboteur;

import games.core.model.board.Coordinate;
import games.core.model.deck.Deck;
import games.core.model.deck.DeckImpl;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.actioncard.ActionCardType;
import games.saboteur.cards.actioncard.BlockCard;
import games.saboteur.cards.pathcard.SaboteurTile;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class SaboteurGameController {
    private SaboteurBoard board;
    private SaboteurPlayer[] players;
    private Deck<SaboteurCard> deck;
    private Stack<SaboteurCard> trash;
    private SaboteurDeckBuilder deckBuilder;

    private SaboteurPlayer currentPlayer;
    private int selectedHandIndex;
    private SaboteurPlayer selectedPlayer;
    private Coordinate selectedCoordinate;

    public SaboteurGameController(int nbPlayers) throws InvalidNumberOfPlayersException {
        if (nbPlayers <= 1)
            throw new InvalidNumberOfPlayersException();

        this.board = new SaboteurBoard();

        this.players = new SaboteurPlayer[nbPlayers];
        for (int i = 0; i < nbPlayers; i++)
            players[i] = new SaboteurPlayer("Player " + i, 0);

        deckBuilder = new SaboteurDeckBuilderImpl();
        this.deck = new DeckImpl<>(deckBuilder);

        SaboteurHand[] hands = new SaboteurHand[nbPlayers];
        for (int i = 0; i < nbPlayers; i++)
            hands[i] = (SaboteurHand) players[i].getHand(); // pb
        deck.shuffle();
        deck.distributeCards(hands);

        trash = new Stack<>();
    }

    public static void main(String[] args) {
        SaboteurGameController gameController = new SaboteurGameController(3);
        gameController.play();
    }

    public SaboteurBoard getBoard() {
        return board;
    }

    public SaboteurPlayer[] getPlayers() {
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
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + i + ", ");
        }
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

    public void play() {
        boolean gameEnds = false;
        while (!gameEnds) {
            for (int i = 0; i < players.length; i++) {
                currentPlayer = players[i];
                printPlayers();
                printCurrentPlayer();
                printHand();
                printBlockCards();
                printBoard();
                Scanner sc = new Scanner(System.in);
                System.out.println("Choose your action (0 : pass, 1 : play a path card, 2 : play an action card) : ");
                int action = sc.nextInt();
                switch (action) {
                    case 0:
                        System.out.println("Index of the card to put to the trash : ");
                        selectedHandIndex = sc.nextInt();
                        System.out.println(currentPlayer.getHand().getCardAt(selectedHandIndex));
                        currentPlayer.takeTurn(Action.PASS, this);
                        System.out.println("Player " + currentPlayer + " has passed their turn");
                        printHand();
                        break;
                    case 1:
                        System.out.println("Index of the path card to play : ");
                        selectedHandIndex = sc.nextInt();
                        SaboteurCard c = currentPlayer.getHand().getCardAt(selectedHandIndex);
                        System.out.println(c);
                        System.out.println(c instanceof SaboteurTile);
                        System.out.println("Coordinates of the destination in the board : ");
                        System.out.println("Row : ");
                        int row = sc.nextInt();
                        System.out.println("Column : ");
                        int column = sc.nextInt();
                        selectedCoordinate = new Coordinate(row, column);
                        boolean win = currentPlayer.takeTurn(Action.PLAY_PATH_CARD, this);
                        if (win) {
                            System.out.println(currentPlayer + "won");
                            gameEnds = true;
                        }
                        break;
                    case 2:
                        System.out.println("Index of the action card to play : ");
                        selectedHandIndex = sc.nextInt();
                        System.out.println(currentPlayer.getHand().getCardAt(selectedHandIndex));
                        System.out.println("Index of the player to put the card in front of : ");
                        int selectedPlayerIndex = sc.nextInt();
                        selectedPlayer = players[selectedPlayerIndex];
                        currentPlayer.takeTurn(Action.PLAY_ACTION_CARD, this);
                        break;
                }
            }
        }
    }

    enum Action {
        PLAY_ACTION_CARD, PLAY_PATH_CARD, PASS
    }
}
