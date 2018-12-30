package games.saboteur.view;

import games.common.model.board.Coordinate;
import games.common.model.player.Player;
import games.saboteur.SaboteurGameController;
import games.saboteur.SaboteurHand;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.actioncard.ActionCardType;
import games.saboteur.cards.actioncard.BlockCard;

import java.util.HashMap;
import java.util.Scanner;

public class SaboteurCLIView {
    private SaboteurGameController gameController;

    public SaboteurCLIView(SaboteurGameController gameController) {
        this.gameController = gameController;
    }

    public void printPassTurn() {
        System.out.println("Player " + gameController.getCurrentPlayer() + " has passed their turn");
    }

    public void printError(Throwable t) {
        System.out.println(t.toString());
    }

    public void printWrongAction() {
        System.out.println("Please enter a valid integer (either 0 or 1)");
    }

    public int selectCardToPutToTrash() {
        System.out.println("Index of the card to put to the trash : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void printPlayerWon() {
        System.out.println(gameController.getCurrentPlayer() + " has won");
    }

    public int selectPlayer() {
        System.out.println("Index of the player to put the card in front of : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public Coordinate selectCoordinate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Coordinates of the destination in the board : ");
        System.out.println("Row : ");
        int row = sc.nextInt();
        System.out.println("Column : ");
        int column = sc.nextInt();
        return new Coordinate(row, column);
    }

    public int selectCardToPlay() {
        System.out.println("Index of the card to play : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
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
        for (Player p : gameController.getPlayers())
            System.out.println(p);
        System.out.println();
    }

    public void printHand() {
        System.out.println(gameController.getCurrentPlayer() + " hand (listed by index):");
        SaboteurHand hand = (SaboteurHand) gameController.getCurrentPlayer().getHand();
        int i = 0;
        for (SaboteurCard c : hand.getHand()) {
            System.out.println(i + " - " + c.toString());
            i++;
        }
        System.out.println();
    }

    public void printCurrentPlayer() {
        System.out.println("Current player : " + gameController.getCurrentPlayer().toString() + "\n");
    }

    public void printBlockCards() {
        System.out.print("Block cards applied to " + gameController.getCurrentPlayer() + " : ");
        HashMap<ActionCardType, BlockCard> blockCards = gameController.getCurrentPlayer().getBlockCards();
        for (BlockCard blockCard : blockCards.values()) {
            System.out.print(blockCard + ", ");
        }
        System.out.println("\n");
    }

    public void printBoard() {
        System.out.println("The board : \n");
        System.out.println(gameController.getBoard());
    }
}
