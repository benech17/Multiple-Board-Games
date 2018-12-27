package games.puzzle;

import games.core.model.board.Board;
import games.core.model.board.Coordinate;
import games.core.model.board.DefaultBoardImpl;
import games.core.model.deck.DeckBuilder;
import games.core.model.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


public class PuzzleDeckBuilder implements DeckBuilder<PuzzleTile> {
    private final int height, length;
    private Board<PuzzleTile> board;
    private HashMap<Coordinate, PuzzleTile> map;
    private Stack<PuzzleTile> deck;

    public PuzzleDeckBuilder(int height, int length) {
        this.height = height;
        this.length = length;
        this.deck = new Stack<>();
        this.board = new DefaultBoardImpl<>(height, length);
    }

    @Override
    public Stack<PuzzleTile> build() {
        int id = 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                List<Integer> connections = new ArrayList<>(4);
                Coordinate currentCoord = new Coordinate(i, j);
                for (Direction d : Direction.values()) {
                    // If the adjacent coordinate is inside the board
                    if (board.coordinateInsideBoard(currentCoord.add(d.getRelativeCoordinates()))) {
                        PuzzleTile adjTile = board.getTileAt(currentCoord.add(d.getRelativeCoordinates()));
                        if (adjTile == null) {
                            connections.add(id++);
                        } else {
                            // If the adjacent side has a value that is initialised (that is, does not equal -1)
                            // we add the value to the connections
                            connections.add(adjTile.getSide(d.getOppositeDirection()).getValue());
                        }
                    } else
                        connections.add(0); // The edge is in the border of the board
                }
                PuzzleTile tile = new PuzzleTile(currentCoord, connections.get(0), connections.get(1),
                        connections.get(2), connections.get(3));
                board.putTileAt(currentCoord, tile);
            }
        }
        // Add the initialised tiles to the deck
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                deck.add(board.getTileAt(new Coordinate(i, j)));
            }
        }
        return deck;
    }
}
