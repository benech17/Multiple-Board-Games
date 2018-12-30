package games.lineardominoes;

import games.common.model.player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LinearCLIViewImpl implements LinearDominoesView {
    private LinearDominoesGameState gameState;

    public LinearCLIViewImpl() {
    }

    public void setGameState(LinearDominoesGameState gameState) {
        this.gameState = gameState;
    }


    public void printError(Throwable t) {
        System.out.println(t.toString());
    }

    public void printError(String message) {
        System.out.println(message);
    }


    public void printPlayerWon() {
        System.out.println(gameState.getCurrentPlayer() + " has won");
    }

    public int selectPlayer() {
        System.out.println("Index of the player to put the card in front of : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public int selectCardToPlay() {
        System.out.println("Index of the card to play : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public boolean selectedLeftEnd() {
        System.out.println("Put to the domino tile left (0) or to the right (1): ");
        Scanner sc = new Scanner(System.in);
        int value;
        try {
            value = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Invalid input! Please try again");
        }
        return value == 0;
    }

    public void printWrongIndex() {
        System.out.println("Wrong index, please retry");
    }

    public int chooseAction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your action (0 : pass, 1 : play a card) : ");
        return sc.nextInt();
    }

    public void printPlayers() {
        System.out.print("Players : ");
        for (Player p : gameState.getPlayers())
            System.out.println(p);
        System.out.println();
    }

    public void printHand() {
        System.out.println(gameState.getCurrentPlayer() + " hand (listed by index):");
        LinearDominoesHand hand = (LinearDominoesHand) gameState.getCurrentPlayer().getHand();
        int i = 0;
        for (LinearDominoTile c : hand.getHand()) {
            System.out.println(i + " - " + c.toString());
            i++;
        }
        System.out.println();
    }

    public void printCurrentPlayer() {
        System.out.println("Current player : " + gameState.getCurrentPlayer().toString() + "\n");
    }

    public void printBoard() {
        System.out.println("The board : \n");
        System.out.println(gameState.getBoard());
    }

    @Override
    public int getNbPlayers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the desired number of players : ");
        return sc.nextInt();
    }
}
