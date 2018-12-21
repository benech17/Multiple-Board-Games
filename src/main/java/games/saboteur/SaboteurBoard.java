package games.saboteur;

import games.core.model.board.AbstractBoard;
import games.core.model.board.Coordinate;
import games.core.model.enums.Direction;

import java.util.ArrayList;


public class SaboteurBoard extends AbstractBoard<SaboteurTile> {
    // Number of cards between the start card and goal card
    protected final int DISTANCE = 7;
    private StartCard startCard;
    private TreasureCard treasureCard;

    public SaboteurBoard() {
        super(5, 9);
        putStartCard();
        putGoalCards();
        TestCard c = new TestCard();
        putTileAt(new Coordinate(0, 1), c);
        startCard.getSides().get(Direction.RIGHT).setNextSide(c.getSides().get(Direction.LEFT));

        c.getSides().get(Direction.LEFT).setNextSide(startCard.getSides().get(Direction.RIGHT));
        c.getSides().get(Direction.RIGHT).setNextSide(treasureCard.getSides().get(Direction.LEFT));

        treasureCard.getSides().get(Direction.LEFT).setNextSide(c.getSides().get(Direction.RIGHT));
    }

    private void putStartCard() {
        startCard = new StartCard();
        putTileAt(new Coordinate(0, 0), startCard);
    }

    // TODO
    public boolean putCardAt(Coordinate c) {
        if (coordinateExists(c))
            return false;
        SaboteurTile saboteurTile = getTileAt(c);
        adjacentCoordinates = getAdjacentCoordinates(c);
        for (Coordinate coord : adjacentCoordinates.values()) {
            SaboteurTile t = getTileAt(coord);
            for (Direction d : t.getSides().keySet()) {
                /*switch (d) {
                    case TOP:
                        if ((SaboteurTile) t.getSides().get(Direction.BOTTOM);
                }*/
            }

        }
        return true;
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
        putTileAt(new Coordinate(0, 2), treasureCard);
    }

    private boolean treasureReached() {
        return startCard.treasureReached();
    }

    @Override
    public String toString() {
        return "SaboteurBoard{" +
                "board=" + board +
                '}';
    }

    public static void main(String[] args) {
        SaboteurBoard board = new SaboteurBoard();
        System.out.println(board);
        System.out.println(board.startCard.getSides().get(Direction.RIGHT));
        System.out.println(board.treasureCard.getSides().get(Direction.LEFT));
        System.out.println(board.treasureReached());
        System.out.println(board.getTileAt(new Coordinate(0, 2)).getAdjacentNodes());
        System.out.println(board.getTileAt(new Coordinate(0, 2)).isLeaf());
    }
}
