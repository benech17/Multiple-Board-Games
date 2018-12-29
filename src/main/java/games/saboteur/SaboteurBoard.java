package games.saboteur;

import games.common.model.board.BoardImpl;
import games.common.model.board.Coordinate;
import games.common.model.board.OutOfBoardBoundsException;
import games.common.model.enums.Direction;
import games.saboteur.cards.pathcard.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;


public class SaboteurBoard extends BoardImpl<SaboteurTile> {
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
    private final StartCard startCard = new StartCard();
    // The treasure card
    private final TreasureCard treasureCard = new TreasureCard();
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
        super.putTileAt(START_COORDINATE, startCard);
    }

    public TreasureCard getTreasureCard() {
        return treasureCard;
    }

    /**
     * {@inheritDoc}
     *
     * @throws PathCardException.UnconnectedPathException if the path card don't connect with adjacent path cards
     */
    @Override
    public boolean putTileAt(Coordinate c, SaboteurTile tile) throws PathCardException.UnconnectedPathException {
        if (!coordinateInsideBoard(c))
            throw new OutOfBoardBoundsException(c.toString());
        EnumMap<Direction, SaboteurTile> adjacentTiles = getAdjacentTilesByDirection(c);
        // If there are no adjacent tiles to connect to
        if (adjacentTiles.isEmpty())
            throw new PathCardException.UnconnectedPathException("No adjacent path card to connect to!");
        // We check if the tile fits with each adjacent tile
        for (Direction d : adjacentTiles.keySet()) {
            if (adjacentTiles.get(d).isHidden())
                adjacentTiles.get(d).reveal(); // Reveal card if hidden
            if (!tile.fitsWith(adjacentTiles.get(d), d))
                throw new PathCardException.UnconnectedPathException("Illegal move: tunnels must connect!");
        }
        // The tile fits with the surrounding tiles, let's put it in the board
        return super.putTileAt(c, tile);
    }

    /**
     * Puts the shuffled goal cards on the board
     */
    private void putGoalCards() {
        ArrayList<GoalCard> goalCards = new ArrayList<>();
        goalCards.add(treasureCard);
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
        StringBuilder s = new StringBuilder("  ");
        for (int i = 0; i < length; i++)
            s.append(i);
        s.append("\n");
        for (int i = 0; i < height; i++) {
            s.append(i).append(" ");
            for (int j = 0; j < length; j++) {
                s.append(board.get(i).get(j) == null ? "n" : "X");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
