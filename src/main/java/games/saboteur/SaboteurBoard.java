package games.saboteur;

import games.core.model.board.Coordinate;
import games.core.model.board.DefaultBoardImpl;

import java.util.ArrayList;
import java.util.Collections;


public class SaboteurBoard extends DefaultBoardImpl<SaboteurTile> {
    // Number of cards between the start card and goal card
    private final static int DISTANCE = 7;
    private final static int NB_ROWS = 5;
    private final static int NB_COLS = 9;
    private final static int CENTER_ROW = NB_ROWS / 2;
    StartCard startCard;


    public SaboteurBoard() {
        super(NB_ROWS, NB_COLS);
        putStartCard();
        putGoalCards();
        /*TestCard c = new TestCard();
        putTileAt(new Coordinate(0, 1), c);
        startCard.getSides().get(Direction.RIGHT).setNextSide(c.getSides().get(Direction.LEFT));
        */
        //c.getSides().get(Direction.LEFT).setNextSide(startCard.getSides().get(Direction.RIGHT));
        //c.getSides().get(Direction.RIGHT).setNextSide(treasureCard.getSides().get(Direction.LEFT));

        //treasureCard.getSides().get(Direction.LEFT).setNextSide(c.getSides().get(Direction.RIGHT));
    }

    private void putStartCard() {
        startCard = new StartCard();
        putTileAt(new Coordinate(CENTER_ROW, 0), startCard);
    }

    // TODO
    /*public boolean putCardAt(Coordinate c) {
        if (coordinateInsideBoard(c))
            return false;
        SaboteurTile saboteurTile = getTileAt(c);
        adjacentCoordinates = getAdjacentCoordinates(c);
        for (Coordinate coord : adjacentCoordinates.values()) {
            SaboteurTile t = getTileAt(coord);
            for (Direction d : t.getSides().keySet()) {
                *//*switch (d) {
                    case TOP:
                        if ((SaboteurTile) t.getSides().get(Direction.BOTTOM);
                }*//*
            }

        }
        return true;
    }*/

    /**
     * Puts the shuffled goal cards on the board
     */
    private void putGoalCards() {
        ArrayList<GoalCard> goalCards = new ArrayList<>();
        goalCards.add(new TreasureCard());
        goalCards.add(new StoneCard());
        goalCards.add(new StoneCard());

        Collections.shuffle(goalCards);
        putTileAt(new Coordinate(CENTER_ROW - 2, DISTANCE + 1), goalCards.get(0));
        putTileAt(new Coordinate(CENTER_ROW, DISTANCE + 1), goalCards.get(1));
        putTileAt(new Coordinate(CENTER_ROW + 2, DISTANCE + 1), goalCards.get(2));

    }

    private boolean treasureReached() {
        return startCard.treasureReached();
    }

    public static void main(String[] args) {
        SaboteurBoard board = new SaboteurBoard();
        System.out.println(board);
    }
}
