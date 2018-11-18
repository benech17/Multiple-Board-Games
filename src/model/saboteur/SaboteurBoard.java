package model.saboteur;

import model.core.board.Board;
import model.core.board.Coordinate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class SaboteurBoard extends Board {
    // Number of cards between the start card and goal card
    protected final int DISTANCE = 7;

    public SaboteurBoard() {
        map = new HashMap<>();
        StartCard startCard = new StartCard();
        addTileToMap(new Coordinate(0, 0), startCard);
        putGoalCards();

    }

    /**
     * Puts the shuffled goal cards on the board
     */
    private void putGoalCards() {
        ArrayList<GoalCard> goalCards = new ArrayList<>();
        goalCards.add(new TreasureCard());
        goalCards.add(new StoneCard());
        goalCards.add(new StoneCard());
        Collections.shuffle(goalCards);
        addTileToMap(new Coordinate(0, DISTANCE + 1), goalCards.get(0));
        addTileToMap(new Coordinate(2, DISTANCE + 1), goalCards.get(1));
        addTileToMap(new Coordinate(-2, DISTANCE + 1), goalCards.get(2));
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
    }
}
