package games.saboteur;

import games.core.model.board.Coordinate;
import games.core.model.board.DefaultBoardImpl;
import games.core.model.board.NoSuchCoordinateException;
import games.core.model.enums.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class SaboteurBoard extends DefaultBoardImpl<SaboteurTile> {
    // Distance between the start card and goal card
    private static final int DISTANCE = 8;
    // Dimensions of the board
    private static final int NB_ROWS = 5;
    private static final int NB_COLS = 9;
    // Compute the center row (ideally the number of rows
    // should be odd to have it actually centered)
    private static final int CENTER_ROW = NB_ROWS / 2;
    // Distance that separates the goal cards
    private static final int OFFSET = 2;
    // The start card
    private static final StartCard START_CARD = new StartCard();
    // Start and goal coordinates
    private static final Coordinate START_COORDINATE = new Coordinate(CENTER_ROW, 0);
    private static final Coordinate[] GOAL_COORDINATES = new Coordinate[]{
            new Coordinate(CENTER_ROW - OFFSET, DISTANCE),
            new Coordinate(CENTER_ROW, DISTANCE),
            new Coordinate(CENTER_ROW + OFFSET, DISTANCE)
    };


    public SaboteurBoard() {
        super(NB_ROWS, NB_COLS);
        putStartCard();
        putGoalCards();
    }

    private void putStartCard() {
        super.putTileAt(START_COORDINATE, START_CARD);
    }

    @Override
    public boolean putTileAt(Coordinate c, SaboteurTile tile) {
        if (!coordinateInsideBoard(c))
            throw new NoSuchCoordinateException();
        HashMap<Direction, SaboteurTile> adjacentTiles = getAdjacentTilesByDirection(c);
        System.out.println(adjacentTiles);
        // We check if the tile fits with each adjacent tile
        for (Direction d : adjacentTiles.keySet()) {
            if (!tile.fitsWith(adjacentTiles.get(d), d))
                return false;
        }
        // The tile fits with the surrounding tiles, let's put it in the board
        return super.putTileAt(c, tile);
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
        super.putTileAt(GOAL_COORDINATES[0], goalCards.get(0));
        super.putTileAt(GOAL_COORDINATES[1], goalCards.get(1));
        super.putTileAt(GOAL_COORDINATES[2], goalCards.get(2));

    }

    public boolean treasureReached() {
        return hasPathFromTo(START_COORDINATE, tile -> tile instanceof TreasureCard);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                s += board.get(i).get(j) == null ? "n" : "X";
            }
            s += "\n";
        }
        return s;
    }
}
