package model.dominoes_stickers;

import model.core.board.Board;
import model.core.board.Coordinate;
import model.core.enums.Color;
import model.core.enums.Direction;
import model.core.enums.Shape;
import model.dominoes.DominoTile;

import java.util.HashMap;

public class DominoesStickerBoard extends Board<DominoStickerSide> {

    public DominoesStickerBoard(DominoStickerTile t) {
        // We put the first domino tile at the center of the map
        super(50, 50);

        addTileToMap(new Coordinate(0, 0), t.getLeftSide());
        addTileToMap(new Coordinate(0, 1), t.getRightSide());
    }

    /**
     * Adds the domino tile in the board at the specified position
     * @param t the domino tile to put in the board
     * @param c the coordinate of the specified position
     * @return
     */
    public boolean addDominoTile(DominoTile t, Coordinate c) {
        if (t == null)
            return false;
        HashMap<Direction, Coordinate> neighbors = getAdjacentCoordinates(c);
        if (neighbors.get(Direction.TOP) != null) {

        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                s += ((map.get(i).get(j) == null)?"XX":map.get(i).get(j)) + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        DominoesStickerBoard b = new DominoesStickerBoard(new DominoStickerTile(Shape.HEART, Color.BLUE, Shape.STAR,
                Color.YELLOW));
        System.out.println(b.toString());

    }
}