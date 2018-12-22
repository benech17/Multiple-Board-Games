package games.saboteur;

import games.core.model.board.Coordinate;
import games.core.model.board.DefaultBoardImpl;
import games.core.model.board.NoSuchCoordinateException;
import games.core.model.enums.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class SaboteurBoard extends DefaultBoardImpl<SaboteurTile> {
    // Number of cards between the start card and goal card
    private static final int DISTANCE = 7;
    private static final int NB_ROWS = 5;
    private static final int NB_COLS = 9;
    private static final int CENTER_ROW = NB_ROWS / 2;
    StartCard startCard;


    public SaboteurBoard() {
        super(NB_ROWS, NB_COLS);
        putStartCard();
        putGoalCards();
    }

    private void putStartCard() {
        startCard = new StartCard();
        super.putTileAt(new Coordinate(CENTER_ROW, 0), startCard);
    }

    @Override
    public boolean putTileAt(Coordinate c, SaboteurTile tile) {
        if (!coordinateInsideBoard(c))
            throw new NoSuchCoordinateException();
        HashMap<Direction, SaboteurTile> adjacentTiles = getAdjacentTiles(c);
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
        super.putTileAt(new Coordinate(CENTER_ROW - 2, DISTANCE + 1), goalCards.get(0));
        super.putTileAt(new Coordinate(CENTER_ROW, DISTANCE + 1), goalCards.get(1));
        super.putTileAt(new Coordinate(CENTER_ROW + 2, DISTANCE + 1), goalCards.get(2));

    }

    private boolean treasureReached() {
        return startCard.treasureReached();
    }
}
