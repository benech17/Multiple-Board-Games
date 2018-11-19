package model.saboteur;

import model.core.board.Board;
import model.core.board.Coordinate;
import model.core.enums.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class SaboteurBoard extends Board {
    // Number of cards between the start card and goal card
    protected final int DISTANCE = 1; // should be 7
    private StartCard startCard;
    private TreasureCard treasureCard;

    public SaboteurBoard() {
        map = new HashMap<>();
        putStartCard();
        putGoalCards();
        TestCard c = new TestCard();
        addTileToMap(new Coordinate(0, 1), c);
        startCard.getSides().get(Direction.RIGHT).setNextSide(c.getSides().get(Direction.LEFT));

        c.getSides().get(Direction.LEFT).setNextSide(startCard.getSides().get(Direction.RIGHT));
        c.getSides().get(Direction.RIGHT).setNextSide(treasureCard.getSides().get(Direction.LEFT));

        treasureCard.getSides().get(Direction.LEFT).setNextSide(c.getSides().get(Direction.RIGHT));
    }

    private void putStartCard() {
        startCard = new StartCard();
        addTileToMap(new Coordinate(0, 0), startCard);
    }

    /**
     * Puts the shuffled goal cards on the board
     */
    private void putGoalCards() {
        ArrayList<GoalCard> goalCards = new ArrayList<>();
        goalCards.add(new TreasureCard());
        goalCards.add(new StoneCard());
        goalCards.add(new StoneCard());

        /*Collections.shuffle(goalCards);
        addTileToMap(new Coordinate(0, DISTANCE + 1), goalCards.get(0));
        addTileToMap(new Coordinate(2, DISTANCE + 1), goalCards.get(1));
        addTileToMap(new Coordinate(-2, DISTANCE + 1), goalCards.get(2));
        */
        // For debugging
        treasureCard = new TreasureCard();
        addTileToMap(new Coordinate(0, 2), treasureCard);
    }

    private boolean treasureReached() {
        return startCard.treasureReached();
    }

    @Override
    public String toString() {
        return "SaboteurBoard{" +
                "map=" + map +
                '}';
    }

    public static void main(String[] args) {
        SaboteurBoard board = new SaboteurBoard();
        System.out.println(board);
        System.out.println(board.startCard.getSides().get(Direction.RIGHT));
        System.out.println(board.treasureCard.getSides().get(Direction.LEFT));
        System.out.println(board.treasureReached());
    }
}
