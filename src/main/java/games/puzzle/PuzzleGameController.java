package games.puzzle;

import games.common.model.board.Coordinate;
import games.common.model.deck.Deck;
import games.common.model.deck.DeckImpl;
import games.common.model.hand.Hand;
import games.common.model.player.Player;
import games.saboteur.InvalidNumberOfPlayersException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PuzzleGameController {
    private PuzzleBoard board;
    private List<PuzzlePlayer> players;
    private Deck<PuzzleTile> deck;
    private int selectedHandIndex;
    private PuzzlePlayer currentPlayer;

    private Coordinate selectedCoordinate;

    public PuzzleGameController(int height, int length) throws InvalidNumberOfPlayersException {
        /**
         * Same pattern as in the SaboteurGameController
         * might refactor this
         */

        this.board = new PuzzleBoard(height, length);

        PuzzleDeckBuilder deckBuilder = new PuzzleDeckBuilder(height, length);
        this.deck = new DeckImpl<>(deckBuilder);

        players = new ArrayList<>();
        players.add(new PuzzlePlayer("Player", 0, height * length) {
        });
        List<Hand<PuzzleTile>> hands = new ArrayList<>(1);
        hands.add(players.get(0).getHand()); // one player
        System.out.println(hands.size());
        deck.shuffle();
        System.out.println(deck.getCards());
        deck.distributeCards(hands);
        System.out.println(deck.getCards());
        System.out.println(hands.get(0).getHand());
        //System.out.println(((PuzzlePlayer) players.get(0)).getHand());

    }

    public static void main(String[] args) {
        PuzzleGameController gameController = new PuzzleGameController(2, 2);
        gameController.play();
    }

    public PuzzleBoard getBoard() {
        return board;
    }

    public List<PuzzlePlayer> getPlayers() {
        return players;
    }

    public Deck<PuzzleTile> getDeck() {
        return deck;
    }

    public int getSelectedHandIndex() {
        return selectedHandIndex;
    }

    public Coordinate getSelectedCoordinate() {
        return selectedCoordinate;
    }

    public PuzzlePlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void printPlayers() {
        System.out.print("Players : ");
        for (Player p : players)
            System.out.println(p);
        System.out.println();
    }

    public void printHand() {
        System.out.println(currentPlayer + " hand (listed by index):");
        Hand<PuzzleTile> hand = currentPlayer.getHand();
        int i = 0;
        for (PuzzleTile c : hand.getHand()) {
            System.out.println(i + " - " + c.toString());
            i++;
        }
        System.out.println();
    }

    public void printCurrentPlayer() {
        System.out.println("Current player : " + currentPlayer.toString() + "\n");
    }


    public void printBoard() {
        System.out.println("The board : \n");
        System.out.println(board);
    }

    public boolean takeTurn() {
        printPlayers();
        printCurrentPlayer();
        printHand();
        printBoard();
        Scanner sc = new Scanner(System.in);
        System.out.println("Index of the puzzle card to play : ");
        selectedHandIndex = sc.nextInt();
        PuzzleTile c = currentPlayer.getHand().getCardAt(selectedHandIndex);
        System.out.println(c);
        System.out.println(c instanceof PuzzleTile);
        System.out.println("Coordinates of the destination in the board : ");
        System.out.println("Row : ");
        int row = sc.nextInt();
        System.out.println("Column : ");
        int column = sc.nextInt();
        selectedCoordinate = new Coordinate(row, column);
        try {
            currentPlayer.takeTurn(this);
        } catch (Throwable t) {
            System.out.println(t.toString());
            return false;
        }
        return true;
    }

    public void play() {
        while (true) {
            for (Player player : players) {
                currentPlayer = (PuzzlePlayer) player;
                boolean validPlay = false;
                while (!validPlay)
                    if (takeTurn())
                        validPlay = true;
                // TODO
                if (currentPlayer.hasWon()) {
                    System.out.println(currentPlayer + " has won");
                    return; // Ends the game
                }
            }
        }
    }

}
