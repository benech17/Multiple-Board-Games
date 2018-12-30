package games.saboteur.view;

import games.common.model.board.Coordinate;
import games.common.model.player.Player;
import games.saboteur.SaboteurGameState;
import games.saboteur.SaboteurHand;
import games.saboteur.cards.SaboteurCard;
import games.saboteur.cards.actioncard.ActionCardType;
import games.saboteur.cards.actioncard.BlockCard;

import java.util.HashMap;
import java.util.Scanner;

public class SaboteurCLIViewImpl implements SaboteurView {
    private SaboteurGameState gameState;

    public SaboteurCLIViewImpl() {
    }

    public void setGameState(SaboteurGameState gameState) {
        this.gameState = gameState;
    }

    public void printPassTurn() {
        System.out.println("Player " + gameState.getCurrentPlayer() + " has passed their turn");
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
        System.out.println(gameState.getCurrentPlayer() + " has won");
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
        for (Player p : gameState.getPlayers())
            System.out.println(p);
        System.out.println();
    }

    public void printHand() {
        System.out.println(gameState.getCurrentPlayer() + " hand (listed by index):");
        SaboteurHand hand = (SaboteurHand) gameState.getCurrentPlayer().getHand();
        int i = 0;
        for (SaboteurCard c : hand.getHand()) {
            System.out.println(i + " - " + c.toString());
            i++;
        }
        System.out.println();
    }

    public void printCurrentPlayer() {
        System.out.println("Current player : " + gameState.getCurrentPlayer().toString() + "\n");
    }

    public void printBlockCards() {
        System.out.print("Block cards applied to " + gameState.getCurrentPlayer() + " : ");
        HashMap<ActionCardType, BlockCard> blockCards = gameState.getCurrentPlayer().getBlockCards();
        for (BlockCard blockCard : blockCards.values()) {
            System.out.print(blockCard + ", ");
        }
        System.out.println("\n");
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
