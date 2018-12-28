package games.puzzle;

import games.common.model.board.Coordinate;
import games.common.model.deck.Deck;
import games.common.model.deck.DeckImpl;
import games.common.model.hand.Hand;
import games.common.model.hand.HandImpl;
import games.common.model.player.Player;
import games.common.model.player.PlayerImpl;
import games.saboteur.InvalidNumberOfPlayersException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PuzzleGameController {
    private PuzzleBoard board;
    private List<Player> players;
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

        Hand<PuzzleTile> hand = new HandImpl<>() {
            @Override
            public int getCardNumberAtStart() {
                // Distribute all cards to the hand
                return height * length;
            }
        };
        players = new ArrayList<>();
        players.add(new PlayerImpl<>("Player", 0) {
        });
        List<Hand<PuzzleTile>> hands = new ArrayList<>(1);
        hands.add(hand);
        deck.shuffle();
        deck.distributeCards(hands);

    }

    public static void main(String[] args) {
        PuzzleGameController gameController = new PuzzleGameController(6, 6);
        gameController.play();
    }

    public PuzzleBoard getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
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
        System.out.println("Choose your action (0 : pass, 1 : play a path card, 2 : play an action card) : ");
        int action = sc.nextInt();
        switch (action) {
            case 1:
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
                    // TODO
                    //currentPlayer.takeTurn(Action.PLAY_PATH_CARD, this);
                } catch (Throwable t) {
                    System.out.println(t.toString());
                    return false;
                }
                break;
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
                /*if (currentPlayer.hasWon()) {
                    System.out.println(currentPlayer + " has won");
                    printPlayers();
                    return; // Ends the game
                }*/
            }
        }
    }

}
